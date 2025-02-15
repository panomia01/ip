package task;

/**
 * The Event class represents a task with a specific start and end time.
 */
public class Event extends Task {

    protected String timeStart;
    protected String timeEnd;

    /**
     * Constructs an Event task with a description, start time, and end time.
     *
     * @param description The description of the event.
     * @param timeStart   The start time of the event.
     * @param timeEnd     The end time of the event.
     */
    public Event(String description, String timeStart, String timeEnd) {
        super(description);
        this.timeEnd = timeEnd;
        this.timeStart = timeStart;
    }

    /**
     * Returns the string format of the event for file storage.
     *
     * @return A formatted string representing the event.
     */
    @Override
    public String toFileFormat() {
        String isTaskMarkedAsDone = isDone ? "1" : "0";
        return "E | " + isTaskMarkedAsDone + " | " + description + " | " + timeStart + " | " + timeEnd;
    }

    /**
     * Returns a string representation of the event.
     *
     * @return The formatted string representation of the event.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + timeStart + " to: " + timeEnd + ")";
    }
}
