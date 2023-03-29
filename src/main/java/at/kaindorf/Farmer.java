package at.kaindorf;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Threads<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 29. März 2023<br>
 * <b>Time:</b> 08:39<br>
 */

// Producer
public class Farmer implements Runnable {

    private static final List<String> AVAILABLE_FRUITS =
            Arrays.asList("Dragon fruit", "Grape", "Banana", "Apple", "Strawberry", "Peach");

    private final FarmerMarket farmerMarket;
    private final String name;

    public Farmer(FarmerMarket farmerMarket, String name) {
        this.farmerMarket = farmerMarket;
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (;;) {
            String fruit = AVAILABLE_FRUITS.get(random.nextInt(AVAILABLE_FRUITS.size()));
            System.out.println(name + " produced " + fruit);
            try {
                farmerMarket.add(fruit);
                // random.nextInt(500, 2001)
                Thread.sleep(random.nextInt(2000 - 500 + 1) + 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
