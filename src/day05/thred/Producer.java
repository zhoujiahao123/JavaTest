package day05.thred;

public class Producer implements Runnable {
    Q q;
    int count = 10;
    public Producer(Q q){
        this.q = q;
        new Thread(this).start();
    }
    @Override
    public void run() {
        while (count-->0){
            q.put();
        }
    }
}
