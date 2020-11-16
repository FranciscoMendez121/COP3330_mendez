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

    static ArrayList<TaskItem> list = new ArrayList<>();

    public static void displayList(){
        for(int i = 0; i <= list.size(); i++){
            System.out.println("Current Tasks");
            System.out.println("--------------");
            System.out.println(list);
        }
    }

    public static void addToList(){
        list.add(createTaskItem(taskTitle,taskDescription,taskDate));
    }

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

    public static void setMark(int place){
        TaskItem marker = new TaskItem("*","*","*");
        list.set(place,marker);
    }

    public static void unMark(int place){
        TaskItem unMarker = new TaskItem("","","");
        list.set(place,unMarker);
    }
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

    public static void displayMarkedItems(){
        for(int i = 0; i <= list.size(); i++){
            System.out.println("Unmarked Tasks");
            System.out.println("--------------");
            displayList();
        }
    }
    public static void displayUnmarkedItems(){
        for(int i = 0; i <= list.size(); i++){
            System.out.println("Unmarked Tasks");
            System.out.println("--------------");
            displayList();
        }
    }

    public static void editItem(){

        System.out.println("Choose a task from the list to edit: ");
        System.out.println("--------------------------------------");
        displayList();
        Scanner userChoiceScn = new Scanner(System.in);

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

        list.get(choice);

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
