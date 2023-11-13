package homework.task_20_design_and_architecture.strategy;

public class RectangleAreaCalculationStrategy implements AreaCalculationStrategy {
    private final double length;
    private final double width;

    public RectangleAreaCalculationStrategy(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
