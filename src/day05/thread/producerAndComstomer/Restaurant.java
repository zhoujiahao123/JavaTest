package day05.thread.producerAndComstomer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    ExecutorService exec = Executors.newCachedThreadPool();
    Meal meal;
    Waiter waiter = new Waiter(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waiter);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
