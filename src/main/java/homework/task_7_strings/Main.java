package homework.task_7_strings;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //1
        System.out.println("Character appears " + findSymbolOccurence("Java", 'a') + " times\n");

        //2
        System.out.println("Positions index of the first element: " + findWordPosition("Apollo", "pollo"));
        System.out.println("Positions index of the first element: " + findWordPosition("Apple", "Plant"));

        //3
        System.out.print("\nReversed output: ");
        System.out.println(stringReverse("Hello"));

        //4
        System.out.println("\nIs palindrome: " + isPalindrome("ERE"));
        System.out.println("Is palindrome? - " + isPalindrome("Allo"));

    }

    private static boolean isPalindrome(String str) {
        char[] charArrayOriginal = str.toCharArray();
        char[] charArrayReversed = stringReverse(str);
        return Arrays.equals(charArrayOriginal, charArrayReversed);
    }

    private static char[] stringReverse(String str) {
        char[] charArray = str.toCharArray();
        for (int l = 0, r = charArray.length - 1; l < r; l++, r--) {
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;
        }
        return charArray;
    }

    private static int findWordPosition(String source, String target) {
        if (source.contains(target)) {
            return source.indexOf(target);
        }
        return -1;
    }

    private static int findSymbolOccurence(String str, char character) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }
}
