import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Dew {
    public static void main(String[] args) {
        String logo = " ____\n"
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
//        Task[] items = new Task[100];
        ArrayList<Task> items = new ArrayList<>();
        int counter = 0;
        while (!input.equals("bye")) {
            try {
                if (input.equals("list")) {
                    System.out.println("____________________________________________________________\n"
                            + "Here are the tasks in your list:");
                    int itemSize = items.size();
                    for (int i = 0; i < itemSize; i++) {
                        int itemIndex = i + 1;
                        if (items.get(i) == null) {
                            break;
                        }
                        System.out.println(itemIndex + "." + items.get(i));
                    }
                    System.out.println(line);
                } else if (input.equals("unmark")) {
                    String num = scanner.next();
                    int itemIndex = Integer.parseInt(num) - 1;
                    items.get(itemIndex).unMarkStatusIcon();

                    System.out.println("____________________________________________________________\n"
                            + "OK, I've marked this task as not done yet:\n"
                            + "   " + items.get(itemIndex) + "\n"
                            + line);
                } else if (input.equals("mark")) {
                    String num = scanner.next();
                    int itemIndex = Integer.parseInt(num) - 1;
                    items.get(itemIndex).markStatusIcon();

                    System.out.println("____________________________________________________________\n"
                            + "Nice! I've marked this task as done:\n"
                            + "   " + items.get(itemIndex) + "\n"
                            + line);
                } else if (input.equals("todo")) {
                    String desc = scanner.nextLine();
                    if (desc.isEmpty()) {
                        throw new DewException("OOPS!!! The description of a todo cannot be empty.");
                    }
//                    items.get(counter) = new Todo(desc);
                    items.add(new Todo(desc));

                    System.out.println("____________________________________________________________\n"
                            + "Got it. I've added this task:\n"
                            + "   " + items.get(counter) + "\n"
                            + "Now you have " + ++counter +" tasks in the list." + "\n"
                            + line);
                } else if (input.equals("deadline")) {
                    String nextInput = scanner.nextLine();
                    String[] userInput = nextInput.split(" /by ");
                    if (userInput.length != 2) {
                        throw new DewException("OOPS!!! The description of a Deadline is not fully filled");
                    }
//                    items[counter] = new Deadline(userInput[0], userInput[1]);
                    items.add(new Deadline(userInput[0], userInput[1]));

                    System.out.println("____________________________________________________________\n"
                            + "Got it. I've added this task:\n"
                            + "   " + items.get(counter) + "\n"
                            + "Now you have " + ++counter +" tasks in the list." + "\n"
                            + line);
                } else if (input.equals("event")) {
                    String nextInput = scanner.nextLine();
                    String[] userInput = nextInput.split(" /");
                    if (userInput.length != 3) {
                        throw new DewException("OOPS!!! The description of a Event is not fully filled");
                    }
                    userInput[1] = userInput[1].substring(5);
                    userInput[2] = userInput[2].substring(3);
//                    items[counter] = new Event(userInput[0], userInput[1], userInput[2]);
                    items.add(new Event(userInput[0], userInput[1], userInput[2]));

                    System.out.println("____________________________________________________________\n"
                            + "Got it. I've added this task:\n"
                            + "   " + items.get(counter) + "\n"
                            + "Now you have " + ++counter +" tasks in the list." + "\n"
                            + line);
                } else if (input.equals("delete")) {
                    String nextInput = scanner.next();
                    int itemIndex = Integer.parseInt(nextInput) - 1;
//                    String[] userInput = nextInput.split(" /");
                    if (items.get(itemIndex) == null) {
                        throw new DewException("OOPS!!! The item in delete is not valid");
                    }

                    System.out.println("____________________________________________________________\n"
                            + "Noted. I've removed this task:\n"
                            + "   " + items.get(itemIndex) + "\n"
                            + "Now you have " + --counter +" tasks in the list." + "\n"
                            + line);
                    items.remove(itemIndex);
                } else {
                    throw new DewException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DewException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.next();
//            userInput = input.split(" ");
        }
        System.out.println(end_dialogue);
    }

//
}
