package FirstJob;

import java.util.Arrays;

public class Main4 {

    static double final EPS = 0.00001;

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static double[] crossArrays(double[] first, double[] second) {
        double[] result = {};
        for (int comparedNumber = 0; comparedNumber < first.length; comparedNumber++) {
            double value = first[comparedNumber];
            if (contains(second, value) && !contains(result, value)) {
                result = add(result, value);
            }
        }
        return result;
    }

    public static boolean contains(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            if (compare(array[i], value)) {
                return true;
            }
        }
        return false;
    }

    public static boolean compare(double first, double second) {
        return Math.abs(first - second) < EPS;
    }

    public static double[] add(double[] array, double value) {
        double[] newArray = new double[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = value;
        return newArray;
    }

    public static boolean test() {
        return Arrays.equals(crossArrays(new double[]{123.123, 2, 122.1, 43.12},
                                         new double[]{2, 43.12, 123.123, 43.12}),
                                         new double[]{123.123, 2, 43.12});
    }


}

