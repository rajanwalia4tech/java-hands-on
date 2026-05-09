package multithreading.create_threads;


// Creating via thread class
public class MyThreadUsingThreadClass extends Thread{
    String threadName;

    MyThreadUsingThreadClass(String threadName){
        this.threadName = threadName;
    }

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
        MyThreadUsingThreadClass thread1 = new MyThreadUsingThreadClass("Thread 1 : ");
        MyThreadUsingThreadClass thread2 = new MyThreadUsingThreadClass("Thread 2 : ");
        thread1.start();
        thread2.start();
    }

}
