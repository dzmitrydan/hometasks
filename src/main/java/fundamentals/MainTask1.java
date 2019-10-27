package fundamentals;

import java.util.Scanner;

public class MainTask1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Input your name: ");
        String name = in.nextLine();

        System.out.println("Hello, "+ name + "!");
    }
}
