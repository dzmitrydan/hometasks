package collections;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class OptionalTask2 {
    public static void main(String[] args) {

        Stack stack = new Stack();
        int number = 0;
        char[] numbers;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number:");

        try {
            number = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.print("You didn't enter a number!");
        }

        numbers = String.valueOf(number).toCharArray();

        for (char num : numbers) {
            stack.push(num);
        }

        while (!stack.empty()) {
            char stackNumber = (Character) stack.pop();
            System.out.print(stackNumber);
        }
    }
}
