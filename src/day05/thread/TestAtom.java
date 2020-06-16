package day05.thread;

public class TestAtom {
    void f() {
        int i = 0;
        i = i++;
        int j = 0;
        j = ++j;
    }
}
