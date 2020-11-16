import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskItem {

    protected String taskTitle;
    protected String taskDescription;
    protected String taskDate;

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public static void setTaskTitle(String title) {
        this.taskTitle = title;
    }

    public static void setTaskDescription(String description) {
        this.taskDescription = description;
    }

    public static void setTaskDate(String date) {
        this.taskDate = date;
    }

    public TaskItem(String title, String description, String date) {
        this.taskTitle = title;
        this.taskDescription = description;
        this.taskDate = date;
    }

    public String isValidTitle(String title) {

        try {
            Scanner scn = new Scanner(System.in);
            title = scn.nextLine();
            setTaskTitle(title);
        } catch (InputMismatchException ex) {
            System.out.println("please enter a valid title");
        }

        return getTaskTitle();
    }

    public String isValidDescription(String description) {

        try {

            Scanner scn = new Scanner(System.in);
            description = scn.nextLine();
            setTaskDescription(description);
        } catch (InputMismatchException ex) {
            System.out.println("This is not a valid Description, please enter a valid description");
        }

        return getTaskDescription();
    }

    public String isValidDate(String date) {

        try {
            Scanner scn = new Scanner(System.in);
            date = scn.nextLine();
            setTaskDate(date);
        } catch (InputMismatchException ex) {
            System.out.println("please enter a valid date (YYYY-MM-DD): ");
        } catch (Exception exception) {
            System.out.println("please enter a valid date (YYYY-MM-DD): ");
        }

        return getTaskDate();
    }

    public static TaskItem createTaskItem(String title, String description, String date) {

        setTaskTitle(title);
        setTaskDescription(description);
        setTaskDate(date);

        TaskItem item = new TaskItem(title, description, date);
        return item;
    }
}
