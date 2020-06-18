package day05.thread.producerAndComstomer;

public class Meal {
    private int orderNum = 0;

    public Meal(int id) {
        orderNum = id;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}
