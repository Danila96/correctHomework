package FirstJob;

import java.util.Arrays;

public class Main3 {

    public static void main(String[] args) {
        try {
            System.out.println(test());
        } catch (IllegalArgumentException error) {
            System.err.println(error.getMessage());
        }
    }

    public static int[][] multiplyMatrix(int[][] left, int[][] right) {
        if (!checkMatrix(left) || !checkMatrix(right)) {
            throw new IllegalArgumentException("One of the matrices is not a matrix");
        }
        if (getRowCount(left) != getColumnCount(right)) {
            throw new IllegalArgumentException("Row of left matrix not equal column of right matrix");
        }

        int[][] result = new int[getColumnCount(left)][getRowCount(right)];
        for (int columnNumber = 0; columnNumber < getColumnCount(left); columnNumber++) {
            for (int rowNumber = 0; rowNumber < getRowCount(right); rowNumber++) {
                result[columnNumber][rowNumber] = multiplyVector(getRow(left, columnNumber),
                        getColumn(right, rowNumber));
            }
        }
        return result;
    }

    private static int multiplyVector(int[] left, int[] right) {
        int multiply = 0;
        for (int rowNumber = 0; rowNumber < left.length; rowNumber++) {
            multiply += left[rowNumber] * right[rowNumber];
        }
        return multiply;
    }

    private static int[] getColumn(int[][] matrix, int columnNumber) {
        int[] result = new int[getColumnCount(matrix)];
        for (int rowNumber = 0; rowNumber < getColumnCount(matrix); rowNumber++) {
            result[rowNumber] = matrix[rowNumber][columnNumber];
        }

        return result;
    }

    private static int[] getRow(int[][] matrix, int rowNumber) {
        return matrix[rowNumber];
    }

    private static int getColumnCount(int[][] matrix) {
        return matrix.length;
    }

    private static int getRowCount(int[][] matrix) {
        return matrix[0].length;
    }

    private static boolean checkMatrix(int[][] matrix) {
        for (int columnNumber = 0; columnNumber < getColumnCount(matrix); columnNumber++) {
            if (matrix[columnNumber].length != getRowCount(matrix)) {
                return false;
            }
        }
        return true;
    }

    private static boolean test() {
        return Arrays.deepEquals(multiplyMatrix(new int[][]{{7, 4, 88},
                        {3, 554, 58}},
                new int[][]{{17, 4},
                        {3, 54},
                        {3, 54}}),

                new int[][]{{395, 4996},
                        {1887, 33060}});
    }
}

