package command;

import storage.Storage;

import task.TaskList;

import ui.Ui;

public class MarkCommand extends Command {
    private int index;
    public MarkCommand(int index) { this.index = index; }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.markTask(index);
        storage.saveTasks(tasks.getTasks());
    }
    public boolean isExit() { return false; }
}
