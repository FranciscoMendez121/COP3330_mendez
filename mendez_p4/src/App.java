import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class App extends TaskList{

    public App(String title, String description, String date) {
        super(title, description, date);
    }

    //main method will display the start menu and will also go through the main menu choice.
    public static void main(String[] args) throws IOException {
        System.out.println("Hello and welcome to the program");
        startMenu();
        userMainMenuChoice();
    }
    //This method displays the start menu
    public static void startMenu(){
        System.out.println("Main Menu");
        System.out.println("---------------------");
        System.out.println(" ");
        System.out.println("1) create a new list \n2) load an existing list \n3) exit\n");
        System.out.println("Please enter a choice: ");
    }

    //This is the menu choice which will scan user input and determine what methods to call based on the user input
    public static void userMainMenuChoice() throws IOException {
        Scanner choiceScn = new Scanner(System.in);

        boolean isChoice = true;
        int userChoice = 4;

        //This loop will iterate while the user continues to input incorrect choices to the console
        while(userChoice > 3 || userChoice < 0) {
            do {
                try {
                    userChoice = choiceScn.nextInt();
                    isChoice = false;
                //Catching if the user scans a non-integer value
                } catch (InputMismatchException ex) {
                    System.out.println("This is not a valid choice, please try again");
                }
                finally {
                    //discards the scan to start again once they enter an invalid choice
                    choiceScn.nextLine();
                }
            } while (isChoice);
            //This only displays if the user enters an integer that is not 1,2,or 3
            if(userChoice > 3 || userChoice < 0){
                System.out.println("Please enter a valid option: 1\t2 or\t3");
            }
        }

        //if the user does want to create a new list, they will go through the operation menu.
        if(userChoice == 1)
            displayListOperationMenu();
        else if(userChoice == 2) {
            System.out.println("Please enter a file you wish to load: ");
            Scanner fileScanner = new Scanner(System.in);
            //This try block will see if the file exists or not
            try{
                String file = fileScanner.nextLine();
            }catch(FileNotFoundException ex){
                System.out.println("Sorry the file was not found, Please try again: ");
            }
            //If it exists, it will load the file by calling the loadToFile method
            loadToFile(file);
        }
    }

    //This method displays the list operation menu and will call upon the userListOperationMenuChoice
    public static void displayListOperationMenu() throws IOException {
        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println(" ");
        System.out.println("1) view the list\n2) add an item\n3)edit an item\n4) remove an item\n5)mark an item as complete");
        System.out.println("6)un-mark item as completed\n7)save the current list\n8)quit to the main menu\n");

        userListOperationMenuChoice();
    }

    //This method ensures that the user enters a valid choice within the range of options
    public static void userListOperationMenuChoice() throws IOException {
        Scanner userListScn = new Scanner(System.in);
        int userListChoice = 9;
        boolean isValidChoice = true;

        while(userListChoice > 8 || userListChoice < 0){
            do{
                try{
                    userListChoice = userListScn.nextInt();
                    isValidChoice = false;
                } catch(InputMismatchException ex){
                    System.out.println("This is not a valid choice. Please try again");
                }
                finally {
                    userListScn.nextLine();
                }

            } while (isValidChoice);

            //This loop will only terminate when the user wants to exit to the main menu
            //It allows the user to use the operation menu as much as they would need to
            while(userListChoice!= 8) {
                //These if/else if statements will perform different tasks based on the user's choice.
                if (userListChoice > 8 || userListChoice < 0) {
                    System.out.println("Please enter a valid option: 1\t2\t3\t4\t5\t6\t7\t8");
                }
                //This calls upon the displayList method
                else if (userListChoice == 1) {
                    displayList();
                }
                //This option will add an item to the list
                else if (userListChoice == 2) {
                    addToList();
                }
                //This option allows the user to edit an item
                else if (userListChoice == 3) {
                    editItem();
                }
                //This option allows the user to delete an item
                else if (userListChoice == 4) {
                    deleteItem();
                }
                //This option allows the user to mark an item
                else if (userListChoice == 5) {
                    markAnItem();
                }
                //This option allows the user to unmark an item
                else if (userListChoice == 6) {
                    unmarkAnItem();
                }
                //This option will allow the user to save their created list to a file
                else if (userListChoice == 7) {
                    saveToFile();
                }
                //This option will allow the user to exit the operation menu and return to the main menu
                else if (userListChoice == 8) {
                    userMainMenuChoice();
                }
            }

        }
    }
}
