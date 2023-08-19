package homework.task_5_polymorphism.participants;

public class Cat implements Participant {

    public static final int CAT_MAX_RUN_DISTANCE = 1000;
    public static final int CAT_MAX_JUMP_HEIGHT = 5;

    private String name;

    public Cat(String name) {
        this.name = name;
    }


    @Override
    public boolean run(int distance) {
        if (distance <= CAT_MAX_RUN_DISTANCE) {
            System.out.println("Cat " + name + " runs " + distance + "m");
            return true;
        } else {
            System.out.println("Cat " + name + " can't run more than " + CAT_MAX_RUN_DISTANCE + "m");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= CAT_MAX_JUMP_HEIGHT) {
            System.out.println("Cat " + name + " jumps " + height + "m");
            return true;
        } else {
            System.out.println("Cat " + name + " can't jump higher than " + CAT_MAX_JUMP_HEIGHT + "m");
            return false;
        }
    }
}
