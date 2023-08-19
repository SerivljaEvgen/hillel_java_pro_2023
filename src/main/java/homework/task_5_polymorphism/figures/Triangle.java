package homework.task_5_polymorphism.figures;

public class Triangle implements Figure {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getCalculateArea() {
        return (base * height) / 2;
    }
}
