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
     * Updates a specific component of an Event task.
     * The user can update the task description, start date, or end date.
     *
     * @param component The component to update ("description", "start", or "end").
     * @param newValue  The new value for the specified component.
     * @throws IllegalArgumentException If an invalid component is provided or if the date format is incorrect.
     */
    @Override
    public void updateComponent(String component, String newValue) {
        if (component.equalsIgnoreCase("description")) {
            updateDescription(newValue);
        } else if (component.equalsIgnoreCase("start")) {
            try {
                this.timeStart = newValue;
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid date format for 'start'. Use YYYY-MM-DD.");
            }
        } else if (component.equalsIgnoreCase("end")) {
            try {
                this.timeEnd = newValue;
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid date format for 'end'. Use YYYY-MM-DD.");
            }
        } else {
            throw new IllegalArgumentException("Invalid component '" + component
                    + "' for Event tasks. Available: description, start, end");
        }
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
