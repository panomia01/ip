package command;

import storage.Storage;

import task.TaskList;

import ui.Ui;

public class DeleteCommand extends Command {
    private int index;
    public DeleteCommand(int index) { this.index = index; }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.deleteTask(index);
        storage.saveTasks(tasks.getTasks());
    }
    public boolean isExit() { return false; }
}
