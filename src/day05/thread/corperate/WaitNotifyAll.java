package day05.thread.corperate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitNotifyAll {
    boolean taken = true;

    public synchronized void take1() {
        try {
            System.out.println("want to take1");
            while (taken){
                wait();
                System.out.println("get to take");
            }
            TimeUnit.MILLISECONDS.sleep(3000);
            taken = true;
        } catch (InterruptedException e) {
            System.out.println("take Interrupted");
        } finally {
            System.out.println("take1 shutdown");
        }
    }

    public synchronized void take() {
        try {
            System.out.println("want to take");
            while (taken){
                wait();
                System.out.println("get to take");
            }
            TimeUnit.MILLISECONDS.sleep(3000);
            taken = true;
        } catch (InterruptedException e) {
            System.out.println("take Interrupted");
        } finally {
            System.out.println("take shutdown");
        }
    }
    public synchronized void drop() {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
            taken = false;
            System.out.println("notifyAll");
            notifyAll();
            TimeUnit.MILLISECONDS.sleep(3000);
            System.out.println("release the lock");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        WaitNotifyAll waitNotifyAll = new WaitNotifyAll();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(()->waitNotifyAll.take1());
        exec.execute(()->waitNotifyAll.take());
        exec.execute(()->waitNotifyAll.drop());
        exec.shutdown();
    }
}
