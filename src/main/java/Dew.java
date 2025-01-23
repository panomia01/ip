import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String input = scanner.next();
//        String[] userInput = input.split(" ");
        Task[] items = new Task[100];
        int counter = 0;
        while (!input.equals("bye")) {

            if (input.equals("list")) {
                System.out.println("____________________________________________________________\n"
                    + "Here are the tasks in your list:");
                int itemSize = items.length;
                for (int i = 0; i < itemSize; i++) {
                    int itemIndex = i + 1;
                    if (items[i] == null) {
                        break;
                    }
                    System.out.println(itemIndex + "." + items[i]);
                }
                System.out.println(line);
            } else if (input.equals("unmark")) {
                String num = scanner.next();
                int itemIndex = Integer.parseInt(num) - 1;
                items[itemIndex].unMarkStatusIcon();

                System.out.println("____________________________________________________________\n"
                        + "OK, I've marked this task as not done yet:\n"
                        + "   " + items[itemIndex] + "\n"
                        + line);
            } else if (input.equals("mark")) {
                String num = scanner.next();
                int itemIndex = Integer.parseInt(num) - 1;
                items[itemIndex].markStatusIcon();

                System.out.println("____________________________________________________________\n"
                        + "Nice! I've marked this task as done:\n"
                        + "   " + items[itemIndex] + "\n"
                        + line);
            } else if (input.equals("todo")) {
                String desc = scanner.nextLine();
                items[counter] = new Todo(desc);

                System.out.println("____________________________________________________________\n"
                        + "Got it. I've added this task:\n"
                        + "   " + items[counter] + "\n"
                        + "Now you have " + ++counter +" tasks in the list." + "\n"
                        + line);
            } else if (input.equals("deadline")) {
                String nextInput = scanner.nextLine();
                String[] userInput = nextInput.split(" /by ");
                items[counter] = new Deadline(userInput[0], userInput[1]);

                System.out.println("____________________________________________________________\n"
                        + "Got it. I've added this task:\n"
                        + "   " + items[counter] + "\n"
                        + "Now you have " + ++counter +" tasks in the list." + "\n"
                        + line);
            } else if (input.equals("event")) {
                String nextInput = scanner.nextLine();
                String[] userInput = nextInput.split(" /");
                userInput[1] = userInput[1].substring(5);
                userInput[2] = userInput[2].substring(3);
                items[counter] = new Event(userInput[0], userInput[1], userInput[2]);

                System.out.println("____________________________________________________________\n"
                        + "Got it. I've added this task:\n"
                        + "   " + items[counter] + "\n"
                        + "Now you have " + ++counter +" tasks in the list." + "\n"
                        + line);
            }
//            else {
//                System.out.println(line
//                        + "added: " + input + "\n"
//                        + line);
//                items[counter] = new Task(input);
//                counter++;
//            }
            input = scanner.next();
//            userInput = input.split(" ");
        }
        System.out.println(end_dialogue);
    }

//
}
