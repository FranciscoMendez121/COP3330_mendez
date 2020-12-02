import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContactApp extends AlphaClass{

    public static void enterContactApp() throws IOException, ClassNotFoundException {
        System.out.println("Main Menu");
        System.out.println("------------");
        System.out.println(" ");
        System.out.println("1) create a new list\n2) load an existing list\n3) quit");

        System.out.println("> ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String argsString = reader.readLine();
        String[] args = argsString.split(" ");

        if (args.length < 1){
            System.out.println("Please provide at least one argument or type 'help' for more detail.");
            return;
        }
        String userInput = args[0];

        if("1".equals(userInput)) {

            System.out.println("a new contact list has been created");
            ContactList.contactListMenu();
        } else if("2".equals(userInput)){
            TaskApp.Tree tree = new TaskApp.Tree("out.txt");
            try{
                tree = tree.load();
            }catch(FileNotFoundException ex){
                System.out.println("There was no file found");
            }finally{
                tree = tree.load();
                System.out.println(tree);
            }

            System.out.println("List has been loaded successfully");
        } else if("3".equals((userInput))){
            System.out.println("have a great day!");
            System.exit(1);
        } else{
            System.out.println("Unknown argument: " + userInput);
            System.out.println(". Please take a look at the supported arguments at\n");
        }


    }

}