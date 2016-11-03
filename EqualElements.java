package FirstJob;

public class EqualElements {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static boolean haveEqualElementsInArray(String[] array) {
        for (int comparedNumber = 0; comparedNumber < array.length - 1; comparedNumber++) {
            for (int currentNumber = comparedNumber + 1; currentNumber < array.length; currentNumber++) {
                if (array[comparedNumber].equals(array[currentNumber])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean test() {
        return haveEqualElementsInArray(new String[]{"kot", "dom", "sova", "arbus"}) == false
                && haveEqualElementsInArray(new String[]{"kot", " ", " ", "arbus"}) == true
                && haveEqualElementsInArray(new String[]{"", "dom", "", "arbus"}) == true;
    }
}
