package homework.task_20_design_and_architecture.strategy;

public class TriangleAreaCalculationStrategy implements AreaCalculationStrategy{
    private final double base;
    private final double height;

    public TriangleAreaCalculationStrategy(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
