package day05.thred;

public class Main {
    public static void main(String[] args) {
     System.out.println(Thread.currentThread());
     Q q = new Q();
     Producer producer = new Producer(q);
     Consumer consumer = new Consumer(q);
    }
}
