package fundamentals;

import java.util.Scanner;

public class MainTask3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Input the number of random numbers: ");
        int number = in.nextInt();

        for (int i = 0; i < number; i++) {
            System.out.print(Math.random() + "\n");
        }

        for (int i = 0; i < number; i++) {
            System.out.print(Math.random() + " ");
        }
    }
}
