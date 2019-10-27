package fundamentals;

import java.util.Scanner;

public class MainTask2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Input string: ");
        String name = in.nextLine();

        System.out.println(new StringBuilder(name).reverse().toString());
    }
}
