import java.util.Scanner;

public class Dew {
    public static void main(String[] args) {
        String logo = " ____           \n"
                    + "|  _ \\  _____     __     __\n"
                    + "| | | |/ _ \\  \\  /   \\  / /\n"
                    + "| |_| |  __/ \\ v  / \\ \\/ /\n"
                    + "|____/ \\___|  \\__/   \\__/\n";
        System.out.println("Hello from\n" + logo);

        String start_dialogue = "____________________________________________________________\n" +
                " Hello! I'm Dew\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";

        String end_dialogue = "____________________________________________________________\n" +
                " Bye. Hope to see you again soon!\n" +
                "____________________________________________________________\n";

        String line = "____________________________________________________________\n";
        System.out.println(start_dialogue);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] items = new String[100];
        int counter = 0;
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                System.out.println("____________________________________________________________");
                int itemSize = items.length;
                for (int i = 0; i < itemSize; i++) {
                    int itemIndex = i + 1;
                    if (items[i] == null) {
                        break;
                    }
                    System.out.println(itemIndex + ". " + items[i]);
                }
                System.out.println(line);
            } else {
                System.out.println(line
                        + "added: " + input + "\n"
                        + line);
                items[counter] = input;
                counter++;
            }
            input = scanner.nextLine();
        }
        System.out.println(end_dialogue);
    }
}
