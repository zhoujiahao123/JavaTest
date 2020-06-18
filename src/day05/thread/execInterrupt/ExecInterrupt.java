package day05.thread.execInterrupt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecInterrupt {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(exec.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    while (!Thread.interrupted()) {

                    }
                    System.out.println("over");
                    return null;
                }
            }));
        }
        list.get(2).cancel(true);
    }
}
