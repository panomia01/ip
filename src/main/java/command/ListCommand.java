package command;

import storage.Storage;

import task.TaskList;

import ui.Ui;

public class ListCommand extends Command {
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.listTasks();
    }
    public boolean isExit() { return false; }
}
