package test;
public class Main {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread lowPriorityThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Low priority thread holding the lock");
                try {
                    Thread.sleep(500); // Simulate long task
                    System.out.println("Low priority thread task completed");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread highPriorityThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("High priority thread running");
                    Thread.sleep(501);
                    System.out.println("High priority thread task completed");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        lowPriorityThread.start();
        highPriorityThread.start();
    }
}