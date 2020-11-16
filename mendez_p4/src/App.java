import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class App extends TaskList{

    public App(String title, String description, String date) {
        super(title, description, date);
    }
    

    public static void main(String[] args) throws IOException {
        System.out.println("Hello and welcome to the program");
        startMenu();
        userMainMenuChoice();
    }

    public static void startMenu(){
        System.out.println("Main Menu");
        System.out.println("---------------------");
        System.out.println(" ");
        System.out.println("1) create a new list \n2) load an existing list \n3) exit\n");
        System.out.println("Please enter a choice: ");
    }

    public static void userMainMenuChoice() throws IOException {
        Scanner choiceScn = new Scanner(System.in);

        boolean isChoice = true;
        int userChoice = 4;

        while(userChoice > 3 || userChoice < 0) {
            do {
                try {
                    userChoice = choiceScn.nextInt();
                    isChoice = false;
                } catch (InputMismatchException ex) {
                    System.out.println("This is not a valid choice, please try again");
                }
                finally {
                    //discards the scan to start again once they enter an invalid choice
                    choiceScn.nextLine();
                }
            } while (isChoice);

            if(userChoice > 3 || userChoice < 0){
                System.out.println("Please enter a valid option: 1\t2 or\t3");
            }
        }

        if(userChoice == 1)
            displayListOperationMenu();
    }

    public static void displayListOperationMenu() throws IOException {
        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println(" ");
        System.out.println("1) view the list\n2) add an item\n3)edit an item\n4) remove an item\n5)mark an item as complete");
        System.out.println("6)un-mark item as completed\n7)save the current list\n8)quit to the main menu\n");

        userListOperationMenuChoice();
    }

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

            if(userListChoice > 8 || userListChoice < 0){
                System.out.println("Please enter a valid option: 1\t2\t3\t4\t5\t6\t7\t8");
            }
            else if(userListChoice == 1){
                displayList();
            }
            else if(userListChoice == 2){
                addToList();
            }
            else if(userListChoice == 3){
                editItem();
            }
            else if(userListChoice == 4){
                deleteItem();
            }
            else if(userListChoice == 5){
                markAnItem();
            }
            else if(userListChoice == 6){
                unmarkAnItem();
            }
            else if(userListChoice == 7){
                saveToFile();
            }

        }

        //Here will be the if statements for whichever choice they enter.
    }



}
