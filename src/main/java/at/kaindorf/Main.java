package at.kaindorf;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Threads<br>
 * <b>User:</b> Simon Schoeggler<br>
 * <b>Date:</b> 29. März 2023<br>
 * <b>Time:</b> 08:54<br>
 */

public class Main {
    public static void main(String[] args) {
        FarmerMarket farmerMarket = new FarmerMarket(5);

        Farmer farmer1 = new Farmer(farmerMarket, "Johannes");
        Farmer farmer2 = new Farmer(farmerMarket, "Weberhiasl");
        Farmer farmer3 = new Farmer(farmerMarket, "Neubergtischler");

        Thread thread1 = new Thread(farmer1);
        Thread thread2 = new Thread(farmer2);
        Thread thread3 = new Thread(farmer3);

        thread1.start();
        thread2.start();
        thread3.start();

        Consumer consumer1 = new Consumer(farmerMarket, "Martin Loidolt");
        Consumer consumer2 = new Consumer(farmerMarket, "Josef Loidolt");

        Thread thread4 = new Thread(consumer1);
        Thread thread5 = new Thread(consumer2);

        thread4.start();
        thread5.start();
    }
}
