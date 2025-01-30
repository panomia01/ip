import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class Dew {
    private static final String FILE_PATH = "src/main/tasks.txt";

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
        loadTasks(items);
        int counter = items.size();
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
        saveTasks(items);
        System.out.println(end_dialogue);
    }

    private static void loadTasks(ArrayList<Task> items) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                if (type.equals("T")) {
                    Todo todo = new Todo(parts[2]);
                    if (isDone) todo.markStatusIcon();
                    items.add(todo);
                } else if (type.equals("D")) {
                    Deadline deadline = new Deadline(parts[2], parts[3]);
                    if (isDone) deadline.markStatusIcon();
                    items.add(deadline);
                } else if (type.equals("E")) {
                    Event event = new Event(parts[2], parts[3], parts[4]);
                    if (isDone) event.markStatusIcon();
                    items.add(event);
                }
            }
        } catch (IOException e) {
            System.out.println("No previous tasks found, starting fresh.");
        }
    }

    private static void saveTasks(ArrayList<Task> items) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task task : items) {
                writer.write(task.toFileFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

//
}
