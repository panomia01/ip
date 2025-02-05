import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Parser {
    public static Command parse(String userInput) throws DewException {
        String[] inputParts = userInput.split(" ", 2);
        String command = inputParts[0];

        switch (command) {
            case "list":
                return new ListCommand();
            case "mark":
                return new MarkCommand(Integer.parseInt(inputParts[1]) - 1);
            case "unmark":
                return new UnmarkCommand(Integer.parseInt(inputParts[1]) - 1);
            case "todo":
                if (inputParts.length < 2 || inputParts[1].trim().isEmpty()) {
                    throw new DewException("The description of a todo cannot be empty.");
                }
                return new AddCommand(new Todo(inputParts[1]));
            case "deadline":
                if (!inputParts[1].contains(" /by ")) {
                throw new DewException("Deadline format: deadline <task> /by <YYYY-MM-DD>");
            }
            String[] deadlineParts = inputParts[1].split(" /by ", 2);
            try {
                LocalDate by = LocalDate.parse(deadlineParts[1].trim()); // Convert String to LocalDate
                return new AddCommand(new Deadline(deadlineParts[0].trim(), by));
            } catch (DateTimeParseException e) {
                throw new DewException("Invalid date format! Use YYYY-MM-DD.");
            }
            case "event":
                if (!inputParts[1].contains(" /from ") || !inputParts[1].contains(" /to ")) {
                    throw new DewException("Event format: event <task> /from <start> /to <end>");
                }
                String[] eventParts = inputParts[1].split(" /from ", 2);
                String[] timeParts = eventParts[1].split(" /to ", 2);
                return new AddCommand(new Event(eventParts[0].trim(), timeParts[0].trim(), timeParts[1].trim()));
            case "delete":
                return new DeleteCommand(Integer.parseInt(inputParts[1]) - 1);
            case "bye":
                return new ExitCommand();
            default:
                throw new DewException("Unknown command.");
        }
    }
}
