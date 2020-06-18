package day05.thread.producerAndComstomer;

public class Waiter implements Runnable {
    private Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                synchronized (restaurant.chef) {
                    System.out.println("waiter get " + restaurant.meal);
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("waiter InterruptedException");
        }
    }
}
