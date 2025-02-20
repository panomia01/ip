package parser;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import command.AddCommand;
import command.Command;
import command.DeleteCommand;
import command.EditCommand;
import command.ExitCommand;
import command.FindCommand;
import command.ListCommand;
import command.MarkCommand;
import command.UnmarkCommand;
import dew.DewException;
import task.Deadline;
import task.Event;
import task.Todo;

/**
 * The Parser class processes user input and returns the corresponding command.
 */
public class Parser {
    /**
     * Parses user input and returns the appropriate Command object.
     *
     * @param userInput The raw user input string.
     * @return The corresponding Command object.
     * @throws DewException If the command is invalid or incorrectly formatted.
     */
    public static Command parse(String userInput) throws DewException {
        assert userInput != null : "User input should not be null";
        assert !userInput.trim().isEmpty() : "User input should not be empty";
        String[] inputParts = userInput.split(" ", 2);
        String command = inputParts[0];
        switch (command) {
        case "list":
            return new ListCommand();
        case "mark":
            if (inputParts.length < 2) {
                throw new DewException("Mark command must include a task description.");
            }
            return new MarkCommand(Integer.parseInt(inputParts[1]) - 1);
        case "unmark":
            if (inputParts.length < 2) {
                throw new DewException("Unmark command must include a task description.");
            }
            return new UnmarkCommand(Integer.parseInt(inputParts[1]) - 1);
        case "todo":
            boolean isInputLengthInvalidForTodo = inputParts.length < 2;
            boolean isDescriptionEmptyForTodo = Arrays.stream(inputParts)
                    .skip(1)
                    .map(String::trim)
                    .allMatch(String::isEmpty);
            if (isInputLengthInvalidForTodo || isDescriptionEmptyForTodo) {
                throw new DewException("The description of a todo cannot be empty.");
            }
            return new AddCommand(new Todo(inputParts[1]));
        case "deadline":
            if (inputParts.length < 2) {
                throw new DewException("Deadline command must include a task description and a deadline.");
            }
            if (!inputParts[1].contains(" /by ")) {
                throw new DewException("task.Deadline format: deadline <task> /by <YYYY-MM-DD>");
            }
            String[] deadlineParts = inputParts[1].split(" /by ", 2);
            try {
                LocalDate by = LocalDate.parse(deadlineParts[1].trim());
                return new AddCommand(new Deadline(deadlineParts[0].trim(), by));
            } catch (DateTimeParseException e) {
                throw new DewException("Invalid date format! Use YYYY-MM-DD.");
            }
        case "event":
            if (inputParts.length < 2) {
                throw new DewException("Event command must include a task description and time range.");
            }
            if (!inputParts[1].contains(" /from ") || !inputParts[1].contains(" /to ")) {
                throw new DewException("task.Event format: event <task> /from <start> /to <end>");
            }
            String[] eventParts = inputParts[1].split(" /from ", 2);
            String[] timeParts = eventParts[1].split(" /to ", 2);
            return new AddCommand(new Event(eventParts[0].trim(), timeParts[0].trim(), timeParts[1].trim()));
        case "edit":
            assert inputParts.length >= 4 : "Edit command requires a task number, component, and new value";

            try {
                String[] editParts = inputParts[1].split("\\s+", 3);
                int taskIndex = Integer.parseInt(editParts[0]) - 1;
                if (editParts.length < 3 || editParts[2].trim().isEmpty()) {
                    throw new DewException("Invalid edit format! Use: edit <task_index> <component> <new_value>");
                }

                String component = editParts[1].trim();
                String newValue = editParts[2].trim();

                return new EditCommand(taskIndex, component, newValue);

            } catch (NumberFormatException e) {
                throw new DewException("Invalid task number! Task index must be a valid number.");
            }
        case "delete":
            if (inputParts.length < 2) {
                throw new DewException("Delete command must include a task number.");
            }
            return new DeleteCommand(Integer.parseInt(inputParts[1]) - 1);
        case "find":
            boolean isInputLengthInvalidForFind = inputParts.length < 2;
            boolean isDescriptionEmptyForFind = Arrays.stream(inputParts)
                    .skip(1)
                    .map(String::trim)
                    .allMatch(String::isEmpty);
            if (isInputLengthInvalidForFind || isDescriptionEmptyForFind) {
                throw new DewException("The keyword for find cannot be empty.");
            }
            return new FindCommand(inputParts[1]);
        case "bye":
            return new ExitCommand();
        default:
            throw new DewException("Unknown command.");
        }
    }
}
