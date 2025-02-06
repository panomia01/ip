package task;

import java.time.LocalDate;

/**
 * The Deadline class represents a task with a specific due date.
 */
public class Deadline extends Task {

    protected LocalDate by;

    /**
     * Constructs a Deadline task with a description and due date.
     *
     * @param description The description of the deadline task.
     * @param by          The due date of the task.
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the string format of the deadline task for file storage.
     *
     * @return A formatted string representing the deadline task.
     */
    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }

    /**
     * Returns a string representation of the deadline task.
     *
     * @return The formatted string representation of the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.getMonth() + " " + by.getDayOfMonth() + " " + by.getYear() + ")";
    }
}
