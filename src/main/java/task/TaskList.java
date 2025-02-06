package task;

import java.util.ArrayList;

/**
 * The TaskList class manages a collection of tasks, allowing addition, deletion,
 * marking, unmarking, and listing of tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with a predefined list of tasks.
     *
     * @param tasks The list of tasks to initialize with.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list and prints a confirmation message.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Got it. I've added this task:\n   " + task);
    }

    /**
     * Deletes a task from the list by index and prints a confirmation message.
     *
     * @param index The index of the task to be removed.
     */
    public void deleteTask(int index) {
        Task removedTask = tasks.remove(index);
        System.out.println("Noted. I've removed this task:\n   " + removedTask);
    }

    /**
     * Marks a task as completed by index and prints a confirmation message.
     *
     * @param index The index of the task to be marked.
     */
    public void markTask(int index) {
        tasks.get(index).markStatusIcon();
        System.out.println("Nice! I've marked this task as done:\n   " + tasks.get(index));
    }

    /**
     * Unmarks a task, setting it as incomplete, and prints a confirmation message.
     *
     * @param index The index of the task to be unmarked.
     */
    public void unmarkTask(int index) {
        tasks.get(index).unMarkStatusIcon();
        System.out.println("OK, I've marked this task as not done yet:\n   " + tasks.get(index));
    }

    /**
     * Returns the list of tasks.
     *
     * @return The list of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Lists all tasks in the task list, displaying them with their index.
     */
    public void listTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
    }
}