package homework.task_20_design_and_architecture.fabric;

import homework.task_20_design_and_architecture.fabric.furniture.Furniture;
import homework.task_20_design_and_architecture.fabric.furnitureFactory.ArmchairFactory;
import homework.task_20_design_and_architecture.fabric.furnitureFactory.BedFactory;
import homework.task_20_design_and_architecture.fabric.furnitureFactory.FurnitureFactory;

public class FurnitureClient {
    public static void main(String[] args) {
        //Factory for armchairs
        FurnitureFactory armchairFactory = new ArmchairFactory();
        Furniture armchair = armchairFactory.createFurniture();
        armchair.assemble();

        //Factory for beds
        FurnitureFactory bedFactory = new BedFactory();
        Furniture bed = bedFactory.createFurniture();
        bed.assemble();

    }
}
