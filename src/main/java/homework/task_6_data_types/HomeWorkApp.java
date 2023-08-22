package homework.task_6_data_types;

//1
public class HomeWorkApp {
    public static void main(String[] args) {

        //2
        printThreeWords();

        //3
        checkSumSign(2, -5);
        System.out.println();

        //4
        printColor(0);
        System.out.println();

        //5
        compareNumbers(10, 20);
        System.out.println();

        //6
        System.out.println(getRangeSum(14, 7));
        System.out.println();

        //7
        printPositiveNegativeNumber(-10);
        System.out.println();

        //8
        System.out.println(checkNegativePositiveNumber(-5));
        System.out.println();

        //9
        printNumberOfTimes("This is the test string", 3);
        System.out.println();

        //10*
        System.out.println("Is the given year a leap year? - " + determineLeapYear(1900));

    }

    private static boolean determineLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    private static void printNumberOfTimes(String string, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(string);
        }

    }

    private static boolean checkNegativePositiveNumber(int number) {
        return number < 0;
    }

    private static void printPositiveNegativeNumber(int number) {
        if (number >= 0) {
            System.out.println("The number " + number + " is positive");
        } else {
            System.out.println("The number " + number + " is negative");
        }
    }

    private static boolean getRangeSum(int a, int b) {
        int sum = a + b;
        return sum > 9 && sum < 21;
    }

    private static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    private static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Red");
        } else if (value <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }

    private static void checkSumSign(int a, int b) {
        int sum = a + b;
        System.out.println("Sum of values: " + sum);
        if (sum >= 0) {
            System.out.println("The amount is positive");
        } else {
            System.out.println("The amount is negative");
        }
    }

    private static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple\n");
    }
}
