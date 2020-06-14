package day05.thread;

public class RunnableTest implements Runnable {
    private int id;
    public RunnableTest(int id) {
        this.id = id;
        System.out.println(id + "号火箭启动");
    }
    @Override
    public void run() {
        int count = 3;
        while (count-- > 0) {
            System.out.println(id + "号火箭准备发射  ：" + count);
        }
        System.out.println(id + "号火箭已发射");
    }
}
