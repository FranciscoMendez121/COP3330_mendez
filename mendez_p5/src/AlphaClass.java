import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public abstract class AlphaClass {
    public static void main(String [] ignorable) throws IOException, ClassNotFoundException {

        System.out.println("Welcome!\n please choose an application to run: ");
        System.out.println("-------------------------------------------------");
        System.out.println("1) task list\n2) contact list\n3) exit");

        while(true) {
            System.out.println("> ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String argsString = reader.readLine();
            String[] args = argsString.split(" ");

            if (args.length < 1){
                System.out.println("Please provide at least one argument");
                return;
            }
            String userInput = args[0];

            if("1".equals(userInput)){
                System.out.println("entering the task list");
                TaskApp.enterTaskApp();
            } else if("2".equals(userInput)){
                System.out.println("entering the contact list");
                ContactApp.enterContactApp();

            } else if("3".equals(userInput)){
                System.out.println("Have a good day!");
                System.exit(1);
            }else {
                System.out.println("Unknown argument: " + userInput);
                System.out.println("Please try again\n");
            }


        }
    }
}
