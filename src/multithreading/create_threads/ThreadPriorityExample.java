package multithreading.create_threads;

/*
    Considerations for Thread Priorities
    Not all JVM implementations respect thread priority. The behavior can vary between different platforms.
    Relying on thread priorities can lead to unpredictable behavior, so it's often better to design your
    application to work well regardless of thread priority.


    keep in mind that thread priority is more of a suggestion to the thread scheduler than a guarantee.
 */

public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread lowPriorityThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Low Priority Thread: " + i);
            }
        });

        Thread mediumPriorityThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Medium Priority Thread: " + i);
            }
        });


        Thread highPriorityThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("High Priority Thread: " + i);
            }
        });

        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
        mediumPriorityThread.setPriority(8);
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        lowPriorityThread.start();
        highPriorityThread.start();
        mediumPriorityThread.start();
    }
}