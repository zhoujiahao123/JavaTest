package day05.thread.produceEven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private IntGenerator intGenerator;

    public EvenChecker(IntGenerator generator) {
        this.intGenerator = generator;
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();
            if (val % 2 != 0) {
                System.out.println(val + "not even");
                intGenerator.cancel();
            }
        }
    }

    public static void main(String[] args) {
        EvenGenerator generator = new EvenGenerator();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new EvenChecker(generator));
        }
        exec.shutdown();
    }
}
