public class Event extends  Task{

    protected String timeStart;
    protected String timeEnd;

    public Event(String description, String timeStart, String timeEnd) {
        super(description);
        this.timeEnd = timeEnd;
        this.timeStart = timeStart;
    }

    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + timeStart + " | " + timeEnd    ;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + timeStart + " to: " + timeEnd + ")";
    }
}
