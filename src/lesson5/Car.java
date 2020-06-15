package lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;
    private final CyclicBarrier cyclicBarrier;
    private final CountDownLatch cdl;
    private final Lock lock;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cyclicBarrier, CountDownLatch cdl, Lock lock) {
        this.race = race;
        this.speed = speed;
        this.cyclicBarrier = cyclicBarrier;
        this.cdl = cdl;
        this.lock = lock;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdl.countDown();
        if (lock.tryLock()) {
            System.out.println(this.name + " - WIN");
        }
    }
}
