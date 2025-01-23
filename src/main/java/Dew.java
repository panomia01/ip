public class Dew {
    public static void main(String[] args) {
        String logo = " ____           \n"
                    + "|  _ \\  _____     __     __\n"
                    + "| | | |/ _ \\  \\  /   \\  / /\n"
                    + "| |_| |  __/ \\ v  / \\ \\/ /\n"
                    + "|____/ \\___|  \\__/   \\__/\n";
        System.out.println("Hello from\n" + logo);

        String start_dialogue = "____________________________________________________________\n" +
                " Hello! I'm [YOUR CHATBOT NAME]\n" +
                " What can I do for you?\n" +
                "____________________________________________________________\n";

        String end_dialogue = " Bye. Hope to see you again soon!\n" +
                "____________________________________________________________\n";

        System.out.println(start_dialogue);
        System.out.println(end_dialogue);
    }
}
