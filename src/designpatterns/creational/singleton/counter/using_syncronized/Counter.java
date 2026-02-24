package designpatterns.creational.singleton.counter.using_syncronized;

/*
    Implement a thread safe counter
 */
public class Counter {
    private int counter = 0;

    // synchronized ensures atomic integers
    public void increment() {
        counter++;
    }

    // synchronized ensures visibility + consistency
    public synchronized int getCount() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + c.getCount());
    }
}
