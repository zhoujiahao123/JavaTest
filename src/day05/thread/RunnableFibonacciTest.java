package day05.thread;

public class RunnableFibonacciTest implements Runnable {
    private int n;
    public RunnableFibonacciTest(int n) {
        this.n = n;
    }
    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        if (n <= 0) System.out.println("参数错误!");
        if (n == 1) System.out.println("1");
        if (n == 2) System.out.println("1-2");
        if (n <= 2) return;
        sb.append("1-2");
        int pre1 = 2, pre2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = pre1;
            pre1 = pre2 + pre1;
            pre2 = temp;
            sb.append("-" + pre1);
            Thread.yield();
        }

    }
}
