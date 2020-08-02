package fundamentals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OptionalTask2 {
    public static void main(String[] args) {

        int[][] matrix;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the dimension of the matrix a[n][n]");
        int dimensionMatrix = scanner.nextInt();

        System.out.println("Input a range values of M (- M to M)");
        int rangeValuesMatrix = scanner.nextInt();

        matrix = matrixCreator(dimensionMatrix, rangeValuesMatrix);
        printMatrix(matrix, dimensionMatrix);

        System.out.println("Input the number of the column k (0 to " + (dimensionMatrix - 1)  + ")");
        int numberColumn = scanner.nextInt();

        if (numberColumn >= 0 && numberColumn < dimensionMatrix){
            orderMatrixByRow(matrix, numberColumn);
            printMatrix(matrix, dimensionMatrix);
        } else System.out.print("The number must be between 0 and " + (dimensionMatrix - 1));


    }

    private static int[][] matrixCreator(int dimension, int value) {
        int[][] matrixNew = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrixNew[i][j] = (int) (Math.random()*(value - (-value))) + (-value);
            }
        }
        return matrixNew;
    }

    private static void orderMatrixByRow(int[][] matrixOrder, int column) {

        Arrays.sort(matrixOrder, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[column] > o2[column])
                    return 1;
                else
                    return -1;
            }

        });
    }

    private static void printMatrix(int[][] matrixForPrint, int dimension) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrixForPrint[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
