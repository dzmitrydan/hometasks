package fundamentals;

import java.util.Scanner;

public class MainTask4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int digit;
        int sumDigit = 0;

        boolean end = true;

        while (end) {
            System.out.println("\n" + "Input integer number:");

            try {
                digit = in.nextInt();
                sumDigit = sumDigit + digit;

                System.out.print("(If you want to finish, type not a number)");
            } catch (Exception e) {
                end = false;
            }
        }

        System.out.print("Sum of numbers is: " + sumDigit);
    }
}
