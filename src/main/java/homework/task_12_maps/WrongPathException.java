package homework.task_12_maps;

public class WrongPathException extends Throwable {
    String path;

    public WrongPathException(String path) {
        super("The path to the file " + path + " incorrect");
        this.path = path;
    }
}
