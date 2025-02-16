package task;

import java.time.LocalDate;

import dew.DewException;

/**
 * The Task class represents a generic task with a description and completion status.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task with the given description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as completed.
     */
    public void markStatusIcon() {
        this.isDone = true;
    }

    /**
     * Unmarks the task, setting it as incomplete.
     */
    public void unMarkStatusIcon() {
        this.isDone = false;
    }

    /**
     * Returns the status icon for the task.
     *
     * @return "X" if the task is completed, otherwise a space.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Converts a formatted string into a Task object.
     *
     * @param data The formatted string representing the task.
     * @return The corresponding Task object.
     * @throws DewException If the task format is invalid.
     */
    public static Task fromString(String data) throws DewException {
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

    public void updateDescription(String newDescription) {
        assert newDescription != null && !newDescription.trim().isEmpty() : "New description cannot be empty";
        this.description = newDescription;
    }

    /**
     * Updates a specific component of a task.
     * Each subclass (Todo, Deadline, Event) must override this method
     * to define how specific components are updated.
     *
     * @param component The component to update (e.g., "description", "by", "start", "end").
     * @param newValue  The new value to set for the specified component.
     */
    public abstract void updateComponent(String component, String newValue);

    /**
     * Returns a string representation of the task.
     *
     * @return The formatted string representation of the task.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + description;
    }

    /**
     * Returns the string format of the task for file storage.
     *
     * @return The task description.
     */
    public String toFileFormat() {
        return description;
    }
}
