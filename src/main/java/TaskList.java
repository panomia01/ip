import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Got it. I've added this task:\n   " + task);
    }

    public void deleteTask(int index) {
        Task removedTask = tasks.remove(index);
        System.out.println("Noted. I've removed this task:\n   " + removedTask);
    }

    public void markTask(int index) {
        tasks.get(index).markStatusIcon();
        System.out.println("Nice! I've marked this task as done:\n   " + tasks.get(index));
    }

    public void unmarkTask(int index) {
        tasks.get(index).unMarkStatusIcon();
        System.out.println("OK, I've marked this task as not done yet:\n   " + tasks.get(index));
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void listTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
    }
}
