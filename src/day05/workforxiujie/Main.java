package day05.workforxiujie;

public class Main {
    public static void main(String[] args) {
        int i = 0, s = 0, n = 100;
        int count = 0;
        while ((i < n) && (s < n)) {
            count++;
            i = i + 1;
            s = s + 10 * i;
        }
        System.out.println(count);
    }
}
