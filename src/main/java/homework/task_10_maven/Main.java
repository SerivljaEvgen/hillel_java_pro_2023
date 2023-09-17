package homework.task_10_maven;

import org.example.utils.MyMathLibrary;

public class Main {
    public static void main(String[] args) {
        MyMathLibrary myMathLibrary = new MyMathLibrary();
        System.out.println("Sum: " + myMathLibrary.add(5, 5.3));
        System.out.println("Subtraction: " + myMathLibrary.subtract(100, 80));
        System.out.println("Multiplication: " + myMathLibrary.multiply(7, 7));
        System.out.println("Division: " + myMathLibrary.divide(25, 5));
        System.out.println("Division by 0: " + myMathLibrary.divide(25, 0));
    }

}
