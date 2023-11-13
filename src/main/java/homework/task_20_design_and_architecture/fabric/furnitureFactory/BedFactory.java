package homework.task_20_design_and_architecture.fabric.furnitureFactory;


import homework.task_20_design_and_architecture.fabric.furniture.Bed;
import homework.task_20_design_and_architecture.fabric.furniture.Furniture;

public class BedFactory implements FurnitureFactory{

    @Override
    public Furniture createFurniture() {
        return new Bed();
    }
}
