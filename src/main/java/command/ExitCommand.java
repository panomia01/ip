package command;

import storage.Storage;

import task.TaskList;

import ui.Ui;

public class ExitCommand extends Command {
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showLine();
        System.out.println("Goodbye!");
    }
    public boolean isExit() { return true; }
}
