import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskList extends TaskItem {

    private static String taskTitle;
    private static String taskDescription;
    private static String taskDate;


    public TaskList(String title, String description, String date) {
        super(title, description, date);
    }

    //This is the list which will hold Task Items
    static ArrayList<TaskItem> list = new ArrayList<>();

    //This method displays the current tasks when called upon
    public static void displayList(){
        for(int i = 0; i <= list.size(); i++){
            System.out.println("Current Tasks");
            System.out.println("--------------");
            System.out.println(list);
        }
    }

    //This method will add a task to the list
    public static void addToList(){
        list.add(createTaskItem(taskTitle,taskDescription,taskDate));
    }

    //This method will display the list and delete an item that the user wishes to delete.
    public static void deleteItem(){

        System.out.println("Please Choose a Task to delete: ");
        Scanner userDeleteScn = new Scanner(System.in);

        displayList();
        try{
            int choice = userDeleteScn.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid integer: ");
        }catch(IndexOutOfBoundsException ex){
            System.out.println("Please enter one of the choices shown: ");
        }finally {
            int choice = userDeleteScn.nextInt();
            list.remove(choice);
        }

    }

    //This method will add a marker to the task that the user wishes to mark
    public static void setMark(int place){
        TaskItem marker = new TaskItem("*","*","*");
        list.set(place,marker);
    }

    //This method will un-mark the task the user wishes to un-mark
    public static void unMark(int place){
        TaskItem unMarker = new TaskItem("","","");
        list.set(place,unMarker);
    }

    //This method calls upon displayUnmarkedItems() and checks to see if the user selects a correct item from
    //The displayed list. It then calls upon the setMark method to mark the item.
    public static void markAnItem(){
        displayUnmarkedItems();
        System.out.println("Please choose which item will be marked with an '(***)': ");

        Scanner userMarkerScn = new Scanner(System.in);
        try{
            int choice = userMarkerScn.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid integer: ");
        }catch(IndexOutOfBoundsException ex){
            System.out.println("Please enter one of the choices shown: ");
        }finally {
            int choice = userMarkerScn.nextInt();
            setMark(choice);
        }
    }

    //This method calls upon displayMarkedItems() and checks to see if the user selects a correct item from
    //The displayed list. It then calls upon the unMark method to un-mark the item.
    public static void unmarkAnItem(){
        displayMarkedItems();
        System.out.println("Please choose which marked items will be unmarked: ");
        Scanner userUnmarkedScn = new Scanner(System.in);
        try{
            int choice = userUnmarkedScn.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid integer: ");
        }catch(IndexOutOfBoundsException ex){
            System.out.println("Please enter one of the choices shown: ");
        }finally {
            int choice = userUnmarkedScn.nextInt();
            unMark(choice);
        }
    }

    //This method loops through the list to find the marked items and display them appropriately
    public static void displayMarkedItems(){
        for(int i = 0; i <= list.size(); i++){
            System.out.println("Unmarked Tasks");
            System.out.println("--------------");
            displayList();
        }
    }
    //This method loops through the list to find the un-marked items and display them appropriately
    public static void displayUnmarkedItems(){
        for(int i = 0; i <= list.size(); i++){
            System.out.println("Unmarked Tasks");
            System.out.println("--------------");
            displayList();
        }
    }

    //This method allows the user to edit the item by changing the title, description, and date
    public static void editItem(){

        System.out.println("Choose a task from the list to edit: ");
        System.out.println("--------------------------------------");
        displayList();
        Scanner userChoiceScn = new Scanner(System.in);

        //This try catch block will see if the user enters a correct choice from the list of tasks provided
        try{
            int choice = userChoiceScn.nextInt();
        }catch(InputMismatchException ex){
            System.out.println("Please enter an integer");
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("please enter one of the choices provided");
        }finally{
            int choice = userChoiceScn.nextInt();
        }
        int choice = userChoiceScn.nextInt();

        //The task is retrieved
        list.get(choice);

        //This try catch block will ensure the user enters a valid title
        System.out.println("Enter a new title for the task: ");
        Scanner userNewTitle = new Scanner(System.in);
        try{
            String newTitle = userNewTitle.nextLine();
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid title: ");
        }finally{
            String newTitle = userNewTitle.nextLine();
            setTaskTitle(newTitle);
        }

        //This try catch block will ensure the user enters a valid description
        System.out.println("Enter a new description for the task: ");
        Scanner userNewDescription = new Scanner(System.in);
        try{
            String newDescription = userNewDescription.nextLine();
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid description: ");
        }finally{
            String newDescription = userNewDescription.nextLine();
            setTaskDescription(newDescription);
        }

        //This try catch block will ensure the user enters a valid date
        System.out.println("Enter a new date for the task: ");
        Scanner userNewDate = new Scanner(System.in);
        try{
            String newDate = userNewDate.nextLine();
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid date: ");
        }finally{
            String newDate = userNewDate.nextLine();
            setTaskDate(newDate);
        }
    }

    //This method allows the user to save their list to any file they wish
    public static void saveToFile() throws IOException {
        Scanner userFileName = new Scanner(System.in);
        System.out.println("Please enter a name for the file you wish to save your work as: ");
        try{
            String name = userFileName.nextLine();
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid name: ");
        }finally{
            String name = userFileName.nextLine();
            FileWriter writer = new FileWriter(name);
            for(TaskItem fileList: list){
                writer.write(fileList + System.lineSeparator());
            }
            System.out.println("Task List saved successfully!");
            writer.close();
        }

    }

    //This method allows the user to load any file they input so long as it exists.
    public void loadToFile(File file) throws IOException{
        try{
            FileReader reader = new FileReader(file);
        }catch(FileNotFoundException ex){
            System.out.println("The file was not found");
        }finally{
            FileReader reader = new FileReader(file);
        }
    }






}
