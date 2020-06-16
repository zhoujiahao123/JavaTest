package day05.thread.serialNumberChecker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet circularSet = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {

        @Override
        public void run() {
            while (true) {
                int serialNum = SerialNumberGenerator.nextSerialNumber();
                if (circularSet.contains(serialNum)) {
                    System.out.println("Duplicate:" + serialNum);
                    System.exit(0);
                }
                circularSet.add(serialNum);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0;i<SIZE;i++){
            exec.execute(new SerialChecker());
        }
        TimeUnit.MILLISECONDS.sleep(10000);
        System.out.println("no duplicate");
    }
}
