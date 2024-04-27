package corejava.multithreading.executorservice.tryout;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class SampleRunnable implements Runnable {
    public static final AtomicLong taskCounter = new AtomicLong(0);
    private final long id;
    private final Map<Long, Long> partitionMap;
    private Random random;

    public SampleRunnable(long id, Map<Long, Long> partitionMap) {
        this.id = id;
        this.partitionMap = partitionMap;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("Hi I am runnable " + id + " executing on " + Thread.currentThread().getName());
        while(!Thread.currentThread().isInterrupted()) {
            try {
                long num = task();
                partitionMap.put(id, num);
                taskCounter.incrementAndGet();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Finished loop");
    }

    /**
     * Simulating a task
     */
    private long task() {
        System.out.println("Executing task for runnable: " + id);
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(5));
        } catch (InterruptedException e) {
            // Interrupting the current thread if sleep is interrupted
            Thread.currentThread().interrupt();
        }
        return random.nextLong();
    }

//    /**
//     * API Call to localhost server which responds with a random number after 5 seconds
//     */
//    private long task() throws IOException {
//        System.out.println("Executing task for runnable: " + id);
//        URL uri = new URL("http://localhost:8080/myapp/temp");
//        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.openConnection();
//        String num = new String(httpURLConnection.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
//        return Long.parseLong(num);
//    }
}
