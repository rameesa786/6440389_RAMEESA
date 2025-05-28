import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(() -> {
            Thread.sleep(1000);
            return 1;
        });
        Future<Integer> future2 = executor.submit(() -> {
            Thread.sleep(1000);
            return 2;
        });

        System.out.println("Result: " + (future1.get() + future2.get()));
        executor.shutdown();
    }
}
