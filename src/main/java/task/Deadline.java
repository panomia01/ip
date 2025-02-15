package task;

import java.time.LocalDate;

/**
 * The Deadline class represents a task with a specific due date.
 */
public class Deadline extends Task {

    protected LocalDate date;

    /**
     * Constructs a Deadline task with a description and due date.
     *
     * @param description The description of the deadline task.
     * @param date          The due date of the task.
     */
    public Deadline(String description, LocalDate date) {
        super(description);
        this.date = date;
    }

    /**
     * Returns the string format of the deadline task for file storage.
     *
     * @return A formatted string representing the deadline task.
     */
    @Override
    public String toFileFormat() {
        String isTaskMarkedAsDone = isDone ? "1" : "0";
        return "D | " + isTaskMarkedAsDone + " | " + description + " | " + date;
    }

    /**
     * Returns a string representation of the deadline task.
     *
     * @return The formatted string representation of the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + date.getMonth() + " "
                + date.getDayOfMonth() + " " + date.getYear() + ")";
    }
}
