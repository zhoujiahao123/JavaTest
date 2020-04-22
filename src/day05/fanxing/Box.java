package day05.fanxing;

public class Box<T> {
    private T t;
    public void add(T t){
        this.t = t;
    }
    public void print(){
        System.out.println(t);
    }
    public T getT(){
        return t;
    }
}
