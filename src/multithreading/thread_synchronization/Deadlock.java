package multithreading.thread_synchronization;

public class Deadlock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("method 1 : lock1");
            synchronized (lock2) {
                // Critical section
                System.out.println("method 1 : lock2");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("method 2 : lock2");
            synchronized (lock1) { // Potential deadlock
                // Critical section
                System.out.println("method 2 : lock1");
            }
        }
    }

    public static void main() {
        Deadlock obj = new Deadlock();
        Thread t1 = new Thread(()->{
            obj.method1();
        });

        Thread t2 = new Thread(()->{
            obj.method2();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e) {
            System.out.println("InterruptedException"+ e.getMessage());
        }
        System.out.println("DONE");
    }
}