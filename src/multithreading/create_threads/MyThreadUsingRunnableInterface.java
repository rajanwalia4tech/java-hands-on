package multithreading.create_threads;


// Using Runnable interfaces
public class MyThreadUsingRunnableInterface implements Runnable{

    String threadName;

    MyThreadUsingRunnableInterface(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run(){
        for(int i=100;i<105;i++){
            System.out.println(this.threadName + i);
            try {
                Thread.sleep(500); // Pause for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThreadUsingRunnableInterface("Thread 1 : "));
        Thread thread2 = new Thread(new MyThreadUsingRunnableInterface("Thread 2 : "));
        thread1.start();
        thread2.start();
    }

}
