package day05.thread;

import java.util.concurrent.Callable;

public class CallableFibonacci implements Callable<Integer> {
    private int n;
    public CallableFibonacci(int n) {
        this.n = n;
    }
    @Override
    public Integer call() throws Exception {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 3;
        int pre1 = 2, pre2 = 1;
        int result = 2;
        for (int i = 3; i <= n; i++) {
            int temp = pre1;
            pre1 = pre2 + pre1;
            pre2 = temp;
            result += pre1;
            Thread.yield();
        }
        return result;
    }
}
