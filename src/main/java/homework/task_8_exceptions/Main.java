package homework.task_8_exceptions;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        ArrayValueCalculator arrCalc = new ArrayValueCalculator();
        int result = arrCalc.doCalc(arr);
        System.out.println(result);
    }
}
