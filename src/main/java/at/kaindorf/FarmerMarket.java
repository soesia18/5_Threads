package at.kaindorf;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Threads<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 29. März 2023<br>
 * <b>Time:</b> 08:13<br>
 */

public class FarmerMarket {
    private final List<String> fruitStand;
    private final int maxAmount;

    public FarmerMarket(int maxAmount) {
        this.maxAmount = maxAmount;
        fruitStand = new ArrayList<>();
    }

    public boolean isFull() {
        return fruitStand.size() >= maxAmount;
    }

    public boolean isEmpty() {
        return fruitStand.isEmpty();
    }

    public void add(String fruit) throws InterruptedException {
        synchronized (fruitStand) {
            while (isFull())
                fruitStand.wait();

            fruitStand.add(fruit);
            System.out.println("After add (" + fruitStand.size() + ") " + fruitStand);
            fruitStand.notifyAll();
        }
    }

    public String remove () throws InterruptedException {
        synchronized (fruitStand) {
            while (isEmpty())
                fruitStand.wait();

            String fruit = fruitStand.remove(fruitStand.size() - 1);
            System.out.println("After remove (" + fruitStand.size() + ") " + fruitStand);
            fruitStand.notifyAll();
            return fruit;

        }
    }
}
