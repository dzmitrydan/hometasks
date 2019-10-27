package fundamentals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OptionalTask1 {
    public static void main(String[] args) {
        int numberOfNumbers = 5;

        String[] arrayNumbers = new String[numberOfNumbers];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input " + numberOfNumbers + " numbers");

        for (int i=0; i<numberOfNumbers; i++){
            System.out.println("Input " + (i+1) + " number:");
            arrayNumbers[i] = scanner.nextLine();
        }

        System.out.println("Entered numbers: " + Arrays.deepToString(arrayNumbers));

        minLengtOfhNumber(arrayNumbers);
        maxLengtOfhNumber(arrayNumbers);
        sortingNumbersByLength(arrayNumbers);
    }

    private static void sortingNumbersByLength(String[] array) {
        Arrays.sort(array, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println("Sorting numbers in descending order by length: " + Arrays.deepToString(array));
    }

    private static void maxLengtOfhNumber(String[] array) {
        String number = array[0];
        int maxLength = array[0].length();

        for (int i=0; i<array.length ; i++) {
            if (array[i].length()  > maxLength){
                number = array[i];
                maxLength = array[i].length();
            }
        }
        System.out.println("Max number: " + number + " his length: " + maxLength);
    }

    private static void minLengtOfhNumber(String[] array) {
        String number = array[0];
        int minLength = array[0].length();

        for (int i=0; i<array.length ; i++) {
            if (array[i].length()  < minLength){
                number = array[i];
                minLength = array[i].length();
            }
        }
        System.out.println("Min number: " + number + " his length: " + minLength);
    }
}
