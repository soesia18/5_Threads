package at.kaindorf;

import java.util.Random;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Threads<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 29. März 2023<br>
 * <b>Time:</b> 09:01<br>
 */

public class Consumer implements Runnable {

    private final FarmerMarket farmerMarket;
    private final String name;

    public Consumer(FarmerMarket farmerMarket, String name) {
        this.farmerMarket = farmerMarket;
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                String fruit = farmerMarket.remove();
                System.out.println(name + " consumed " + fruit);
                Thread.sleep(random.nextInt(100, 401));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
