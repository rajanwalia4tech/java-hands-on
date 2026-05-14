package multithreading.thread_synchronization;

class BankAccount {
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount; // Critical section
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount; // Critical section
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class SynchronizationUsingBankExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            account.deposit(100);
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