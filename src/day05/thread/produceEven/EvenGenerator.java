package day05.thread.produceEven;

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        synchronized(this){
            ++currentEvenValue;
            ++currentEvenValue;
            return currentEvenValue;
        }
    }
}
