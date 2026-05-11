package multithreading.create_threads;

class RequestHandler implements Runnable {
    private final String request;

    public RequestHandler(String request) {
        this.request = request;
    }

    @Override
    public void run() {
        System.out.println("Handling request: " + request);
        try {
            Thread.sleep(200); // Simulate time-consuming request processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Completed request: " + request);
    }
}

/*
    In a web server, each request can be handled by a separate thread.
    This allows the server to process multiple requests simultaneously, improving performance.
 */
public class WebServerExample {
    public static void main(String[] args) {
        String[] requests = {"Request1", "Request2", "Request3"};

        for (String request : requests) {
            Thread thread = new Thread(new RequestHandler(request));
            thread.start();
        }
    }
}