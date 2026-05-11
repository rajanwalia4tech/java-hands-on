package multithreading.create_threads;

class StoppableThread extends Thread {

    /*  we use a volatile boolean flag to control the execution of the thread.
        This ensures that changes to the flag are visible across all threads,
        avoiding some of the pitfalls associated with multi-threading.
    */
    private volatile boolean running = true;

    public void run() {
        while (running) {
            // Do some work here
            System.out.println("Thread is working...");
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
        System.out.println("Thread is stopping.");
    }

    public void stopRunning() {
        running = false; // Set the flag to false
    }
}

public class ThreadStopExample {
    public static void main(String[] args) throws InterruptedException {
        StoppableThread thread = new StoppableThread();
        thread.start();
        Thread.sleep(3000); // Let it run for a while
        thread.stopRunning(); // Signal to stop
        thread.join(); // Wait for the thread to finish
    }
}