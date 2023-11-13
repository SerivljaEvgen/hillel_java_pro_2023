package homework.task_20_design_and_architecture.fabric.furnitureFactory;


import homework.task_20_design_and_architecture.fabric.furniture.Armchair;
import homework.task_20_design_and_architecture.fabric.furniture.Furniture;

public class ArmchairFactory implements FurnitureFactory {

    @Override
    public Furniture createFurniture() {
        return new Armchair();
    }
}
