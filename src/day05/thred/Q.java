package day05.thred;

/**
 * 负责处理生产和消费
 */
public class Q {
    int n;
    boolean valueSet = false;
    synchronized void get(){
        if(!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        n--;
        System.out.println("拿走一个苹果,当前还剩下："+n);
        valueSet = false;
        notify();
    }
    synchronized void put(){
        if(valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        n++;
        System.out.println("放入一个苹果,当前还剩下："+n);
        valueSet = true;
        notify();
    }
}
