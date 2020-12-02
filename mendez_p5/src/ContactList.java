import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ContactList extends ContactItem implements Serializable {

    private String saveLocation = "out.txt";

    public ContactList(String fName, String lName, String phNumber, String eAddress) {
        super(fName, lName, phNumber, eAddress);
    }

    public static Map<Integer, ContactItem> contacts = new HashMap<>();


    public static void contactListMenu() throws IOException {

        System.out.println("List Operation Menu");
        System.out.println("--------------------");
        System.out.println(" ");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu");

        while (true) {
            System.out.printf("> ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String argsString = reader.readLine();
            String[] args = argsString.split(" ");

            if (args.length < 1) {
                System.out.printf("Please provide at least one argument");
                return;
            }

            String firstArg = args[0];

            if ("1".equals(firstArg)) {
                System.out.println(Tree.printTree());
            } else if ("2".equals(firstArg)) {
                System.out.println("Please Enter a First Name, Last Name, Phone Number, and Email Address separated by spaces: ");
                System.out.println("> ");

                if (args.length < 5) {
                    System.out.printf("Add an item requires a First Name, Last Name, Phone Number, and Email Address");
                    continue;
                }
                System.out.println("First Name: ");

                String firstName = args[1];
                String lastName = args[2];
                String phoneNumber = args[3];
                String emailAddress = args[4];

                ContactItem contact = new ContactList(firstName, lastName, phoneNumber, emailAddress);

                ContactList.addContact(contact);



            } else if ("3".equals(firstArg)){
                System.out.println("Please enter the id of the Item you wish to edit: ");
                Scanner scn = new Scanner(System.in);

                int id = scn.nextInt();
                findContact(id);

                System.out.printf("Enter a new First name for contact %d\n",id);
                String newFirstName = scn.nextLine();

                System.out.printf("Enter a new Last Name for contact %d\n",id);
                String newLastName = scn.nextLine();

                System.out.printf("Enter a new phone number for contact %d\n",id);
                String newPhoneNumber = scn.nextLine();

                System.out.printf("Enter a new email Address for contact %d\n",id);
                String newEmailAddress = scn.nextLine();

                ContactItem editedContact = new ContactList(newFirstName, newLastName, newPhoneNumber, newEmailAddress);

                contacts.put(id, editedContact);

            } else if ("4".equals(firstArg)){
                System.out.println("Please Enter the id of the contact you wish to delete: ");
                Scanner scn = new Scanner(System.in);

                try{
                    int id = scn.nextInt();

                } catch(InputMismatchException ex){
                    System.out.println("Please enter a valid id");
                }finally{
                    int id = scn.nextInt();
                    contacts.remove(id);
                }

            } else if ("5".equals(firstArg)){
                Tree tree = new Tree("out.txt");
                tree.save();
            } else if("6".equals(firstArg)){
                System.out.println("quitting to the Main menu");
                System.exit(1);
            }

        }


    }
    public static ContactItem addContact(ContactItem contact){

        return contacts.put(contact.id, contact);
    }

    public static ContactList findContact(int id){

        try {
            for (Map.Entry<Integer, ContactItem> n : contacts.entrySet()) {
                if (n.getValue().getClass() == ContactItem.class) {
                    System.out.println("Contact Item found");
                }
            }
            } catch (Exception ex) {
                System.out.println("Item not found");
            }
        return null;
    }

}
