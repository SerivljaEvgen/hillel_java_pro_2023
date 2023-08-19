package homework.task_5_polymorphism.figures;

public class Square implements Figure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getCalculateArea() {
        return side * side;
    }
}
