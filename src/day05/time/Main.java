package day05.time;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(1997,Calendar.APRIL,7);
        Date date = c.getTime();
    }
}
