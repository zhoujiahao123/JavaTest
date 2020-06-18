package day05.thread.ThreadLocalVariableHolder;

import java.util.Random;

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);
        protected synchronized Integer initialValue() {
            return rand.nextInt(10000);
        }
    };
    public void setValue(){
        value.set(value.get() + 1);
    }
    public int getValue(){
        return value.get();
    }
}
