package homework.task_5_polymorphism.participants;

public class RunningTrack implements Obstacle {

    private final int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.run(length);
    }

    @Override
    public String toString() {
        return "RunningTrack{" +
                "length=" + length +
                '}';
    }
}
