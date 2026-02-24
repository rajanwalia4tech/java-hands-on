package designpatterns.creational.singleton.counter.using_atomic_integers;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/*
    Implement a thread safe counter
 */
public class Counter {
    // AtomicInteger over synchronized because it avoids blocking.”
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                c.increment();
            }
            System.out.println("5");
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
