package FirstJob;

public class Main1 {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int countChar(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    public static boolean test() {
       return  countChar("aaabbbababbb", 'b')==7
               && countChar("aaabbbababbb", 'a')==5
               && countChar("     ", 'b')==0;
    }
}
