package designpatterns.creational.singleton.connectionpool;

/*
    Implement Singleton Database Connection Pool
    Problem: Implement a ConnectionPool singleton that manages a fixed number of reusable
    database connections. Components request connections, use them, and release them back
    to the pool.

    Requirements:
    - Constructor takes a maxConnections parameter (e.g., 5)
    - getConnection() returns an available connection (blocks or throws if none available)
    - releaseConnection(connection) returns a connection to the pool
    - getAvailableCount() returns the number of idle connections
    - Thread-safe: multiple threads request and release connections concurrently
    - Connections are represented as simple objects with an id and inUse flag
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    // TODO: Implement as singleton


    private final BlockingQueue<Connection> pool;
    private final int maxConnections;

    public static class Connection {
        private final int id;

        Connection(int id) { this.id = id; }

        public int getId() { return id; }

        @Override
        public String toString() { return "Connection-" + id; }
    }

    private static class Holder {
        static final ConnectionPool INSTANCE = new ConnectionPool(1);
    }

    public static ConnectionPool getInstance() {
        return Holder.INSTANCE;
    }

    private ConnectionPool(int maxConnections) {
        this.maxConnections = maxConnections;
        this.pool = new LinkedBlockingQueue<>(maxConnections);
        // Pre-create connections and add to pool
        for(int i=1;i<=maxConnections;i++){
            this.pool.add(new Connection(i));
        }
    }

    public Connection getConnection() throws InterruptedException {
        return pool.take();
    }

    public void releaseConnection(Connection conn) {
        pool.offer(conn);
    }

    public int getAvailableCount() {
        return pool.size();
    }

    public static void main(String[] args) throws InterruptedException {
        // After implementing, usage should look like:
         ConnectionPool p1 = ConnectionPool.getInstance();
         ConnectionPool p2 = ConnectionPool.getInstance();
         System.out.println("Same instance: " + (p1 == p2));
         System.out.println("Available connections: " + p1.getAvailableCount());
         ConnectionPool.Connection c1 = p1.getConnection();

         // below is to simulate connection c1 will release after some time till the tile p2
        // has to wait to get the connection
         Runnable task = ()->{
             for(long i=0;i<10000000000l;i++){}
             p1.releaseConnection(c1);
         };

         Thread t1 = new Thread(task);
         System.out.println("Acquired: " + c1);
         t1.start();
         t1.join();

         ConnectionPool.Connection c2 = p1.getConnection();
         System.out.println("Acquired: " + c2);
         System.out.println("Available connections after acquiring 2 : " + p1.getAvailableCount());
         p1.releaseConnection(c1);
         System.out.println("Released: " + c1);
         System.out.println("Available after release: " + p1.getAvailableCount());
    }
}