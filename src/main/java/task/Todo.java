package task;

/**
 * The Todo class represents a simple task without any specific deadline or time.
 */

public class Todo extends Task {
    /**
     * Constructs a Todo task with a description.
     *
     * @param description The description of the task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns the string format of the todo task for file storage.
     *
     * @return A formatted string representing the todo task.
     */
    @Override
    public String toFileFormat() {
        String isTaskMarkedAsDone = isDone ? "1" : "0";
        return "T | " + isTaskMarkedAsDone + " | " + description;
    }

    /**
     * Returns a string representation of the todo task.
     *
     * @return The formatted string representation of the todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
