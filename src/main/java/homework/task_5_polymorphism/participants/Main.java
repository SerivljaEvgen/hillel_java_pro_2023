package homework.task_5_polymorphism.participants;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = new Participant[]{
                new Cat("Barsik"),
                new Robot("Terminator"),
                new Human("Mad Max")
        };

        Obstacle[] obstacles = new Obstacle[]{
                new RunningTrack(2000),
                new Wall(9)
        };

        int count = 0;
        for (Participant participant : participants) {
            count++;
            System.out.println("=== Participant " + count + " starts ===");
            boolean completed = true;
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    System.out.println("Participant left the challenge on " + obstacle);
                    completed = false;
                    break;
                }
            }
            if (completed) {
                System.out.println("Participant completed the challenge");
            }
        }
    }
}
