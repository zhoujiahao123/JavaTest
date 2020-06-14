package day05.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
//        for (int i = 0; i <= 10; i++) {
//            RunnableFibonacciTest runnableFibonacciTest = new RunnableFibonacciTest(i);
//            runnableFibonacciTest.run();
//        }
//        for (int i = 0; i <= 10; i++) {
//            Thread thread = new Thread(new RunnableFibonacciTest(i));
//            thread.start();
//        }
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 0; i <= 10; i++) {
//            cachedThreadPool.execute(new RunnableFibonacciTest(i));
//        }
//        cachedThreadPool.shutdown();

//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
//        for (int i = 0; i <= 10; i++) {
//            fixedThreadPool.execute(new RunnableFibonacciTest(i));
//        }
//        fixedThreadPool.shutdown();
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        for (int i = 0; i <= 10; i++) {
//            singleThreadExecutor.execute(new RunnableFibonacciTest(i));
//        }
//        singleThreadExecutor.shutdown();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(executorService.submit(new CallableFibonacci(i)));
        }

        for (Future<Integer> fs : list) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
