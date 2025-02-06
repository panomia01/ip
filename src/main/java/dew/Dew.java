package dew;

import command.Command;
import parser.Parser;
import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * The Dew class serves as the main entry point for the application.
 * It initializes the necessary components and starts the command loop.
 */
public class Dew {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructs a Dew instance with the specified file path for storage.
     *
     * @param filePath The file path where tasks are stored.
     */
    public Dew(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (DewException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Runs the main loop of the application, processing user commands until exit.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DewException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * The main method, which serves as the entry point of the program.
     * It creates an instance of Dew and starts the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        new Dew("src/main/tasks.txt").run();
    }
}
