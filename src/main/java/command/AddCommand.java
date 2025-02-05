package command;

import storage.Storage;

import task.Task;

import task.TaskList;

import ui.Ui;

public class AddCommand extends Command {
    private Task task;
    public AddCommand(Task task) { this.task = task; }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
        storage.saveTasks(tasks.getTasks());
    }
    public boolean isExit() { return false; }
}
