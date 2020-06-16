package day05.thread.atomicityTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i = 0;

    public int getValue() {
        synchronized (this){
            return i;
        }
    }

    private void evenIncrement() {
        synchronized (this){
            i++;
            i++;
        }
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int value = at.getValue();
            if ((value & 1) == 1) {
                System.out.println(value);
                System.exit(0);
            }
        }
    }
}
