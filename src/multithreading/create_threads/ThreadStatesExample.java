package multithreading.create_threads;

/*
Following are the states of thread...

New: The thread is created but not yet started.
Runnable: The thread is ready to run and waiting for CPU time.
Blocked: The thread is blocked, waiting to acquire a lock or a resource.
Waiting: The thread is waiting indefinitely for another thread to perform a particular action.
Timed Waiting: The thread is waiting for a specified period.
Terminated: The thread has completed execution.

 */


public class ThreadStatesExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            // RUNNABLE: Thread started running here
            System.out.println("Thread started and running");

            try {
                // TIMED_WAITING: Sleeping for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // BLOCKED: Trying to enter synchronized block but main thread holds lock
            synchronized (lock) {
                System.out.println("Thread acquired lock, running inside synchronized block");

                try {
                    // WAITING: Will wait indefinitely until notified
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Thread resumed after wait, finishing execution");
        });

        System.out.println("State after thread creation: " + thread.getState()); // NEW
        thread.start();
        System.out.println("State just after start(): " + thread.getState()); // RUNNABLE

        try {
            // Give thread time to enter sleep (TIMED_WAITING)
            Thread.sleep(200);
            System.out.println("State after 200ms (sleeping): " + thread.getState()); // TIMED_WAITING

            // Main thread acquires lock to cause BLOCKED state in thread
            synchronized (lock) {
                System.out.println("Main thread acquired lock");

                // Wait a bit to let thread try to enter synchronized block and get blocked
                Thread.sleep(200);
                System.out.println("State when thread is blocked waiting for lock: " + thread.getState()); // BLOCKED

                // Notify the waiting thread later after releasing lock
                // But first, main thread releases lock after this block
            }

            // After releasing lock, wait a bit for thread to enter wait() (WAITING)
            Thread.sleep(200);
            System.out.println("State when thread is waiting indefinitely: " + thread.getState()); // WAITING

            // Inside the thread after wait() is over
            synchronized (lock) {
                lock.notify();
            }

            // Wait for thread to finish
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Now print the final state after thread has completed and printed its messages
            System.out.println("State after thread completion: " + thread.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
