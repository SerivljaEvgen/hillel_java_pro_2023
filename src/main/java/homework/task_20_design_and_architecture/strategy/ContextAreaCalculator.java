package homework.task_20_design_and_architecture.strategy;

public class ContextAreaCalculator {
    private AreaCalculationStrategy areaCalculationStrategy;

    public void setAreaCalculationStrategy(AreaCalculationStrategy areaCalculationStrategy) {
        this.areaCalculationStrategy = areaCalculationStrategy;
    }

    public double calculateArea() {
        if (areaCalculationStrategy == null) {
            throw new IllegalStateException("Area calculation strategy is not set.");
        }
        return areaCalculationStrategy.calculateArea();
    }
}
