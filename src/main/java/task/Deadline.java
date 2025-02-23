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
     * Updates a specific component of a Deadline task.
     * The user can update the task description or the deadline date.
     *
     * @param component The component to update ("description" or "by").
     * @param newValue  The new value for the specified component.
     * @throws IllegalArgumentException If an invalid component is provided or if the date format is incorrect.
     */
    @Override
    public void updateComponent(String component, String newValue) {
        if (component.equalsIgnoreCase("description")) {
            updateDescription(newValue);
        } else if (component.equalsIgnoreCase("date")) {
            try {
                this.date = LocalDate.parse(newValue);
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid date format for 'by'. Use YYYY-MM-DD.");
            }
        } else {
            throw new IllegalArgumentException("Invalid component '" + component
                    + "' for Deadline tasks. Available: description, date");
        }
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
