import com.sun.jdi.VoidValue;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues(){
        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";

        boolean failed = false;
        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        try{
            contact.setFirstName("");
            contact.setLastName("");
            contact.setPhoneNumber("");
            contact.setEmailAddress("");

            failed = true;
        }catch(Exception ex){
            assertEquals(failed,true);
        }
    }
    @Test
    public void creationSucceedsWithBlankEmail(){
        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        try{
            contact.setEmailAddress("");
        }catch(Exception ex){
            assertEquals(contact.emailAddress,"");
        }

    }
    @Test
    public void creationSucceedsWithBlankFirstName(){
        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        try{
            contact.setEmailAddress("");
        }catch(Exception ex){
            assertEquals(contact.emailAddress,"");
        }

    }
    @Test
    public void creationSucceedsWithBlankLastName(){
        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        try{
            contact.setLastName("");
        }catch(Exception ex){
            assertEquals(contact.lastName,"");
        }

    }
    @Test
    public void creationSucceedsWithBlankPhone(){
        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        try{
            contact.setPhoneNumber("");
        }catch(Exception ex){
            assertEquals(contact.phoneNumber,"");
        }

    }
    @Test
    public void creationSucceedsWithNonBlankValues(){
        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        try{
            contact.setFirstName("joseph");
            contact.setLastName("penguino");
            contact.setPhoneNumber("8529995557");
            contact.setEmailAddress("penguino.joseph@gmail.com");
        }catch(Exception ex){
            assertEquals(contact.firstName,"joseph");
            assertEquals(contact.lastName,"penguino");
            assertEquals(contact.phoneNumber,"8529995557");
            assertEquals(contact.emailAddress,"penguino.joseph@gmail.com");

        }


    }
    @Test
    public void editingFailsWithAllBlankValues(){

        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem blankContact = new ContactList("","","","");

        contacts.put(0,blankContact);

        try{
            contact.setFirstName(blankContact.firstName);
            contact.setLastName(blankContact.lastName);
            contact.setPhoneNumber(blankContact.phoneNumber);
            contact.setEmailAddress(blankContact.emailAddress);
        }catch(Exception ex){
            assertEquals(contact.firstName,"joseph");
            assertEquals(contact.lastName,"penguino");
            assertEquals(contact.phoneNumber,"8529995557");
            assertEquals(contact.emailAddress,"penguino.joseph@gmail.com");

        }


    }
    @Test
    public void editingSucceedsWithBlankEmail(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem newContact = new ContactList("isabella","Lion","48822221474","");



        try{
            contacts.put(0,newContact);

            contact.setFirstName(newContact.firstName);
            contact.setLastName(newContact.lastName);
            contact.setPhoneNumber(newContact.phoneNumber);
            contact.setEmailAddress(newContact.emailAddress);
        }catch(Exception ex){
            assertEquals(contacts.get(0).firstName,"isabella");
            assertEquals(contacts.get(0).lastName,"Lion");
            assertEquals(contacts.get(0).phoneNumber,"48822221474");
            assertEquals(contacts.get(0).emailAddress,"");

        }

    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem newContact = new ContactList("","Lion","48822221474","Lion@gmail.com");



        try{
            contacts.put(0,newContact);

            contact.setFirstName(newContact.firstName);
            contact.setLastName(newContact.lastName);
            contact.setPhoneNumber(newContact.phoneNumber);
            contact.setEmailAddress(newContact.emailAddress);
        }catch(Exception ex){
            assertEquals(contacts.get(0).firstName,"");
            assertEquals(contacts.get(0).lastName,"Lion");
            assertEquals(contacts.get(0).phoneNumber,"48822221474");
            assertEquals(contacts.get(0).emailAddress,"Lion@gmail.com");

        }

    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem newContact = new ContactList("isabella","","48822221474","isabella@gmail.com");



        try{
            contacts.put(0,newContact);

            contact.setFirstName(newContact.firstName);
            contact.setLastName(newContact.lastName);
            contact.setPhoneNumber(newContact.phoneNumber);
            contact.setEmailAddress(newContact.emailAddress);
        }catch(Exception ex){
            assertEquals(contacts.get(0).firstName,"isabella");
            assertEquals(contacts.get(0).lastName,"");
            assertEquals(contacts.get(0).phoneNumber,"48822221474");
            assertEquals(contacts.get(0).emailAddress,"isabella@gmail.com");

        }


    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem newContact = new ContactList("isabella","Lion","","isabella.Lion@gmail.com");



        try{
            contacts.put(0,newContact);

            contact.setFirstName(newContact.firstName);
            contact.setLastName(newContact.lastName);
            contact.setPhoneNumber(newContact.phoneNumber);
            contact.setEmailAddress(newContact.emailAddress);
        }catch(Exception ex){
            assertEquals(contacts.get(0).firstName,"isabella");
            assertEquals(contacts.get(0).lastName,"");
            assertEquals(contacts.get(0).phoneNumber,"48822221474");
            assertEquals(contacts.get(0).emailAddress,"isabella.Lion@gmail.com");

        }


    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem newContact = new ContactList("isabella","Lion","48822221474","isabella.Lion@gmail.com");



        try{
            contacts.put(0,newContact);

            contact.setFirstName(newContact.firstName);
            contact.setLastName(newContact.lastName);
            contact.setPhoneNumber(newContact.phoneNumber);
            contact.setEmailAddress(newContact.emailAddress);
        }catch(Exception ex){
            assertEquals(contacts.get(0).firstName,"isabella");
            assertEquals(contacts.get(0).lastName,"Lion");
            assertEquals(contacts.get(0).phoneNumber,"48822221474");
            assertEquals(contacts.get(0).emailAddress,"isabella.Lion@gmail.com");

        }


    }
    @Test
    public void testToString(){

        String firstName = "Pablo";
        String lastName = "Penguin";
        Integer phoneNumber = 7444;
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,Integer.toString(phoneNumber),email);

        assertEquals(contact.phoneNumber,"7444");

    }

}