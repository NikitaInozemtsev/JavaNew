package gh;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test  {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Runnable r = new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Something");
            }
        };
        executor.submit(r);
        Future<String> future = executor.submit(() -> "Something2");
        executor.shutdown();

        System.out.println(future.get());
        if (future.isDone() && !future.isCancelled()) {
            System.out.println("Result: " + future.get());
        }
    }

}
