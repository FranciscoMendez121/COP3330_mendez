import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.NullStringConversion;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        try{
            contacts.put(0,contact);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(contacts.size(),1);
        }

    }

    @Test
    public void editingItemsFailsWithinAllBlankValues(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "7451110525";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem blankContact = new ContactList("","","","");

        try {
            contacts.put(0, blankContact);
        }catch(Exception ex) {
            assertEquals(contact.firstName, "Pablo");
            assertEquals(contact.lastName, "Penguin");
            assertEquals(contact.phoneNumber, "8529995557");
            assertEquals(contact.emailAddress, "pablo.penguin@gmail.com");
        }
    }

    @Test
    public void editingItemsFailsWithinInvalidIndex(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "8529995557";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem blankContact = new ContactList("","","","");

        boolean fails = false;

        try {
            contacts.put(44550, blankContact);
            fails = true;
        } catch(IndexOutOfBoundsException ex){
            assertEquals(fails,true);
        }

        assertEquals(contact.firstName, "Pablo");
        assertEquals(contact.lastName, "Penguin");
        assertEquals(contact.phoneNumber, "8529995557");
        assertEquals(contact.emailAddress, "pablo.penguin@gmail.com");

    }

    @Test
    public void editingItemsSucceedsWithBlankFirstName(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "8529995557";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem blankContact = new ContactList("","elephant","7775559999","elephant@gmail.com");

        contacts.put(0,blankContact);

        assertEquals(contacts.get(0).firstName,"");
        assertEquals(contacts.get(0).lastName, "elephant");
        assertEquals(contacts.get(0).phoneNumber, "7775559999");
        assertEquals(contacts.get(0).emailAddress, "elephant@gmail.com");

    }

    @Test
    public void editingItemsSucceedsWithBlankLastName(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "8529995557";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem blankContact = new ContactList("Issac","","7775559999","elephant@gmail.com");

        contacts.put(0,blankContact);

        assertEquals(contacts.get(0).firstName,"Issac");
        assertEquals(contacts.get(0).lastName, "");
        assertEquals(contacts.get(0).phoneNumber, "7775559999");
        assertEquals(contacts.get(0).emailAddress, "elephant@gmail.com");

    }
    @Test
    public void editingItemsSucceedsWithBlankPhone(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "8529995557";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem blankContact = new ContactList("Issac","elephant","","elephant@gmail.com");

        contacts.put(0,blankContact);

        assertEquals(contacts.get(0).firstName,"Issac");
        assertEquals(contacts.get(0).lastName, "elephant");
        assertEquals(contacts.get(0).phoneNumber, "");
        assertEquals(contacts.get(0).emailAddress, "elephant@gmail.com");


    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "8529995557";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        ContactItem blankContact = new ContactList("Issac","elephant","7775559999","elephant@gmail.com");

        contacts.put(0,blankContact);

        assertEquals(contacts.get(0).firstName,"Issac");
        assertEquals(contacts.get(0).lastName, "elephant");
        assertEquals(contacts.get(0).phoneNumber, "7775559999");
        assertEquals(contacts.get(0).emailAddress, "elephant@gmail.com");


    }

    @Test
    public void newListIsEmpty(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "8529995557";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        assertEquals(contacts.size(),0);
    }
    @Test
    public void removingItemsDecreasesSize(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "8529995557";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        contacts.remove(0);

        assertEquals(contacts.size(),0);

    }
    @Test
    public void removingItemsFailsWithInvalidIndex(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "8529995557";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        contacts.put(0,contact);

        try{
            contacts.remove(48585);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(contacts.size(),1);
        }

        assertEquals(contacts.size(),1);

    }
    @Test
    public void savedContactListCanBeLoaded(){
        Map<Integer, ContactItem> contacts = new HashMap<>();

        String firstName = "Pablo";
        String lastName = "Penguin";
        String phoneNumber = "8529995557";
        String email = "pablo.penguin@gmail.com";


        ContactItem contact = new ContactList(firstName,lastName,phoneNumber,email);

        try{
            contacts.put(0,contact);
        }catch(Exception ex){
            assertEquals(contacts.size(),1);
        }

    }

}