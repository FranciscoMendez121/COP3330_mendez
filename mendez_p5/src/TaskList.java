import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList extends TaskItem {


    public TaskList(String title, String date, String description) {
        super(title, date, description);
    }

    static ArrayList<TaskItem> userTasks = new ArrayList<>();

    public static void enterTaskListMenu() throws IOException {
        System.out.println("Welcome to the Task List Menu");
        System.out.println("-------------------------------");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) un-mark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");

        while(true) {
            System.out.println("> ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String argsString = reader.readLine();
            String[] args = argsString.split(" ");

            if (args.length < 1) {
                System.out.println("Please provide at least one argument");
                return;
            }

            String firstArg = args[0];

            if ("1".equals(firstArg)) {
                System.out.println(Tree.printTree());
            } else if ("2".equals(firstArg)) {
                System.out.println("Please Enter a Title, Date, and Description separated by spaces: ");
                System.out.println("> ");

                if (args.length < 4) {
                    System.out.println("Add an item requires a Title, Date, and Description separated by spaces: ");
                    continue;
                }

                String title = args[1];
                String date = args[2];
                String description = args[3];


                TaskItem newTask = new TaskItem(title, date, description);

                userTasks.add(newTask);
                break;

            } else if ("3".equals(firstArg)) {
                System.out.println("Please enter the id of the Item you wish to edit: ");
                Scanner scn = new Scanner(System.in);

                int id = scn.nextInt();

                System.out.printf("Enter a new First name for contact %d", id);
                String newTitle = scn.nextLine();

                System.out.printf("Enter a new Last Name for contact %d", id);
                String newDate = scn.nextLine();

                System.out.printf("Enter a new phone number for contact %d", id);
                String newDescription = scn.nextLine();

                TaskItem editedTask = new TaskList(newTitle, newDate, newDescription);

                userTasks.add(id, editedTask);
                break;
            } else if ("4".equals(firstArg)) {
                System.out.println("Please enter the id of the task you wish to remove: ");
                System.out.println("> ");

                Scanner scn = new Scanner(System.in);
                int id = scn.nextInt();

                userTasks.remove(id);
                break;

            } else if ("5".equals(firstArg)) {
                System.out.println("Please enter the id of the task you wish to mark");
                System.out.println("> ");

                Scanner scn = new Scanner(System.in);
                int id = scn.nextInt();

                TaskItem marker = new TaskItem("*", "*", "*");

                userTasks.add(id, marker);

                break;

            } else if ("6".equals(firstArg)) {
                System.out.println("Please enter the id of the task you wish to un-mark");
                System.out.println("> ");

                Scanner scn = new Scanner(System.in);
                int id = scn.nextInt();

                TaskItem unMarker = new TaskItem(" ", " ", " ");

                userTasks.add(id, unMarker);

                break;

            } else if("7".equals(firstArg)) {
                Tree tree = new Tree("out.txt");
                tree.save();

                break;
            } else if("8".equals(firstArg)){
                System.out.println("Exiting to the Main menu...");
                System.exit(1);
            }

        }
    }

}
