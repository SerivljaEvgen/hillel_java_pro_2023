package homework.task_5_polymorphism.participants;

public class Human implements Participant {

    public static final int HUMAN_MAX_RUN_DISTANCE = 50000;
    public static final int HUMAN_MAX_JUMP_HEIGHT = 3;

    private String name;

    public Human(String name) {
        this.name = name;
    }


    @Override
    public boolean run(int distance) {
        if (distance <= HUMAN_MAX_RUN_DISTANCE) {
            System.out.println("Human " + name + " runs " + distance + "m");
            return true;
        } else {
            System.out.println("Human " + name + " can't run more than " + HUMAN_MAX_RUN_DISTANCE + "m");
            return false;
        }

    }

    @Override
    public boolean jump(int height) {
        if (height <= HUMAN_MAX_JUMP_HEIGHT) {
            System.out.println("Human " + name + " jumps " + height + "m");
            return true;
        } else {
            System.out.println("Human " + name + " can't jump higher than " + HUMAN_MAX_JUMP_HEIGHT + "m");
            return false;
        }
    }
}

