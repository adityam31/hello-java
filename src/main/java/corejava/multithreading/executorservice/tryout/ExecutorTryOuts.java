package corejava.multithreading.executorservice.tryout;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorTryOuts {
    public static final int PARTITION_COUNT = 2;
    public static final long TIMEOUT_IN_SECONDS = 15;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(PARTITION_COUNT);
        Map<Long, Long> paritionMap = new ConcurrentHashMap<>();


        for(int i = 0; i < PARTITION_COUNT; i++) {
            paritionMap.put((long) i, -1L);
            service.execute(new SampleRunnable(i, paritionMap));
        };

        // Waiting for TIMEOUT seconds. This allows service threads to continue in background.
        TimeUnit.SECONDS.sleep(TIMEOUT_IN_SECONDS);

        // Interrupting all threads in the service
        service.shutdownNow();

        // Blocking the current thread until all threads in the service finish their execution
        service.awaitTermination(5, TimeUnit.SECONDS);

        // Further validations or processing
        System.out.println("Tasks executed: " + SampleRunnable.taskCounter.get());
        System.out.println(paritionMap);
    }
}
