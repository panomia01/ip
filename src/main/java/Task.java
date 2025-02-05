import java.time.LocalDate;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markStatusIcon() {
        this.isDone = true;
    }

    public void unMarkStatusIcon() {
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public static Task fromString(String data) throws DewException{
        String[] parts = data.split(" \\| ");

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        Task task;
        switch (type) {
            case "T":
                task = new Todo(description);
                break;
            case "D":
                LocalDate by = LocalDate.parse(parts[3]);
                task = new Deadline(description, by);
                break;
            case "E":
                String timeStart = parts[3];
                String timeEnd = parts[4];
                task = new Event(description, timeStart, timeEnd);
                break;
            default:
                throw new IllegalArgumentException("Invalid task format.");
        }

        if (isDone) {
            task.markStatusIcon();
        }

        return task;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + description;
    }

    public String toFileFormat() {
        return description;
    };
}
