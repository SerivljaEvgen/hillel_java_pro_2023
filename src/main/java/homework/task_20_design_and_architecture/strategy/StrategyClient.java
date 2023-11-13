package homework.task_20_design_and_architecture.strategy;

public class StrategyClient {
    public static void main(String[] args) {
        //Create an object in context
        ContextAreaCalculator calculator = new ContextAreaCalculator();

        // Set the strategy for calculating the area of the rectangle
        calculator.setAreaCalculationStrategy(new RectangleAreaCalculationStrategy(10,20));
        // Calculate and display the area of the rectangle
        System.out.println("Rectangle Area: " + calculator.calculateArea());

        // Set the strategy for calculating the area of the triangle
        calculator.setAreaCalculationStrategy(new TriangleAreaCalculationStrategy(8,12));
        // Calculate and display the area of the triangle
        System.out.println("Triangle Area: " + calculator.calculateArea());
    }
}
