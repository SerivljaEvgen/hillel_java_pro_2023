package homework.task_5_polymorphism.figures;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circle implements Figure {

    private double radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getCalculateArea() {
        return PI * pow(radius, 2);
    }
}
