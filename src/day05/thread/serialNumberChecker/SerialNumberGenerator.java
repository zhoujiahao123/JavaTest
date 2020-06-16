package day05.thread.serialNumberChecker;

public class SerialNumberGenerator{
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber(){
        synchronized (SerialNumberGenerator.class){
            return serialNumber++;
        }
    }
}
