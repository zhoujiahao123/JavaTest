package day05;

public class TestDeadLock {
    private final static String A = "A";
    private final static String B = "B";
    public static void main(String[] args) {
        new TestDeadLock().test();
    }
    private void test(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
                synchronized (A){
                    System.out.println("子线程的");
                    try {
                        System.out.println("BBB");
                        Thread.currentThread().sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    A.notify();
                }
            }
        }).start();
        synchronized(A){
            System.out.println("主线程的");
            try {
                Thread.currentThread().sleep(1000);
                System.out.println("wait");
                A.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void deadLock(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(A){
                    try{
                        System.out.println("1开始睡眠");
                        Thread.currentThread().sleep(5000);
                        System.out.println("1结束睡眠");
                        A.notify();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("BBB");
                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(B) {
                    System.out.println("2开始睡眠");
                    synchronized (A) {
                        System.out.println("AAA");
                    }
                }
            }
        }).start();
    }
}
