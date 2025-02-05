import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        String logo = " ____\n"
                + "|  _ \\  _____     __     __\n"
                + "| | | |/ _ \\  \\  /   \\  / /\n"
                + "| |_| |  __/ \\ v  / \\ \\/ /\n"
                + "|____/ \\___|  \\__/   \\__/\n";

        String start_dialogue = "____________________________________________________________\n" +
                " Hello! I'm Dew\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";

        System.out.println("Hello from\n" + logo + start_dialogue);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void showLoadingError() {
        System.out.println("Error loading tasks.");
    }
}

