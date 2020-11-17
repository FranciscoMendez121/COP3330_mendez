import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskItem {

    //Task items have a title, description, and date
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

    //This method checks to see if the title is valid through a try and catch block
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

    //This method checks to see if the description is valid through a try and catch block
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
    //This method checks to see if the date is valid through a try and catch block
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

    //This method will create a task item when called upon and will return the created item
    public static TaskItem createTaskItem(String title, String description, String date) {

        setTaskTitle(title);
        setTaskDescription(description);
        setTaskDate(date);

        TaskItem item = new TaskItem(title, description, date);
        return item;
    }
}
