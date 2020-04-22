package day05.fanxing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.add("jacob");
        box.print();
        new Main().print(box.getT());
        System.out.println(getMax(10,20));
    }

    public <T> void print(T t) {
        System.out.println(t);
    }

    public static <T extends Comparable<T>> T getMax(T x, T y) {
        T max = x;
        if(y.compareTo(max)>0){
            max = y;
        }
        return max;
    }
}
