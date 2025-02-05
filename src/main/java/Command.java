abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);
    public abstract boolean isExit();
}

class ListCommand extends Command {
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.listTasks();
    }
    public boolean isExit() { return false; }
}

class MarkCommand extends Command {
    private int index;
    public MarkCommand(int index) { this.index = index; }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.markTask(index);
        storage.saveTasks(tasks.getTasks());
    }
    public boolean isExit() { return false; }
}

class UnmarkCommand extends Command {
    private int index;
    public UnmarkCommand(int index) { this.index = index; }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.unmarkTask(index);
        storage.saveTasks(tasks.getTasks());
    }
    public boolean isExit() { return false; }
}

class AddCommand extends Command {
    private Task task;
    public AddCommand(Task task) { this.task = task; }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
        storage.saveTasks(tasks.getTasks());
    }
    public boolean isExit() { return false; }
}

class DeleteCommand extends Command {
    private int index;
    public DeleteCommand(int index) { this.index = index; }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.deleteTask(index);
        storage.saveTasks(tasks.getTasks());
    }
    public boolean isExit() { return false; }
}

class ExitCommand extends Command {
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showLine();
        System.out.println("Goodbye!");
    }
    public boolean isExit() { return true; }
}
