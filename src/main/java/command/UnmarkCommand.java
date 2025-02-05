package command;

import storage.Storage;

import task.TaskList;

import ui.Ui;

public class UnmarkCommand extends Command {
    private int index;
    public UnmarkCommand(int index) { this.index = index; }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.unmarkTask(index);
        storage.saveTasks(tasks.getTasks());
    }
    public boolean isExit() { return false; }
}
