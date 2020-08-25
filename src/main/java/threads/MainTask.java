package threads;

import java.util.Arrays;
import java.util.Random;

public class MainTask {
    public static void main(String[] args) {
        int numberOfParkingSpaces = 5;
        Parking parking = new Parking(numberOfParkingSpaces);
        int numberOfCar = numberOfParkingSpaces + 2;

        for (int i = 1; i < numberOfCar + 1; i++) {
            Thread thread = new Thread(new Car(parking));
            thread.setName("Car_" + i);
            thread.start();
        }
    }
}


class Parking {
    private final String[] spaces;

    public Parking(int number) {
        spaces = new String[number];
    }

    synchronized void getParkingSpace() {

        if (Arrays.asList(spaces).contains(null)) {
            int place = Arrays.asList(spaces).indexOf(null);
            spaces[place] = Thread.currentThread().getName();
            System.out.println(Thread.currentThread().getName() + " took a Parking space " + place);
        } else {
            System.out.println("There are no free Parking spaces: " + Arrays.toString(spaces) + "\n" +
                    Thread.currentThread().getName() + " goes to another Parking");
        }
    }
}


class Car implements Runnable {
    private final Parking parking;

    public Car(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            int time = random.nextInt(1000 * 10);
            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName() + " came to the Parking");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parking.getParkingSpace();
    }
}