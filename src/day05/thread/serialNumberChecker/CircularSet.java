package day05.thread.serialNumberChecker;

import java.util.Arrays;

public class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        len = size;
        Arrays.fill(array, -1);
    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int val) {
        for (int i : array) {
            if(i == val){
                return true;
            }
        }
        return false;
    }
}
