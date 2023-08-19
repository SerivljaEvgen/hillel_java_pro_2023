package homework.task_5_polymorphism.participants;

public class Robot implements Participant {

    public static final int ROBOT_MAX_RUN_DISTANCE = 100000;
    public static final int ROBOT_MAX_JUMP_HEIGHT = 20;

    private String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= ROBOT_MAX_RUN_DISTANCE) {
            System.out.println("Robot " + name + " runs " + distance + "m");
            return true;
        } else {
            System.out.println("Robot " + name + " can't run more than " + ROBOT_MAX_RUN_DISTANCE + "m");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= ROBOT_MAX_JUMP_HEIGHT) {
            System.out.println("Robot " + name + " jumps " + height + "m");
            return true;
        } else {
            System.out.println("Robot " + name + " can't jump higher than " + ROBOT_MAX_JUMP_HEIGHT + "m");
            return false;
        }
    }
}
