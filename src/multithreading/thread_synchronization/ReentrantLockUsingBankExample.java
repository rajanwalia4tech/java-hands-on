package multithreading.thread_synchronization;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockUsingBankExample {
    private int balance = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void deposit(int amount) {
        lock.lock(); // Acquire lock
        try {
            balance += amount; // Critical section
        } finally {
            lock.unlock(); // Always release lock in a finally block
        }
    }

    public void withdraw(int amount) {
        lock.lock(); // Acquire lock
        try {
            if (balance >= amount) {
                balance -= amount; // Critical section
            }
        } finally {
            lock.unlock(); // Always release lock in a finally block
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        ReentrantLockUsingBankExample account = new ReentrantLockUsingBankExample();
        Thread t1 = new Thread(() -> {
            account.deposit(1000);
        });

        Thread t2 = new Thread(() -> {
            account.withdraw(50);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}