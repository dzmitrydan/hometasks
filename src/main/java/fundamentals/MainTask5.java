package fundamentals;


import java.time.Month;
import java.util.Scanner;

public class MainTask5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number from 1 to 12: ");

        String str = in.nextLine();

        if (str != null && str.matches("^-?\\d+$")) {
            int number = Integer.parseInt(str);
            if (number >= 1 && number <= 12) {

                Month month = Month.of(number);
                System.out.println("Month № " + number + " is " + month);

            } else {
                System.out.println("You must input a number between 1 and 12!");

            }
        } else {
            System.out.print("You have input not a number!");
        }

    }
}
