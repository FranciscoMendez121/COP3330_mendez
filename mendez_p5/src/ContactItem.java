import java.io.Serializable;
import java.util.InputMismatchException;

public abstract class ContactItem implements Serializable {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String emailAddress;

    public ContactItem(String fName, String lName, String phNumber, String eAddress){
        try {
            this.firstName = fName;
        }catch(InputMismatchException ex){
            System.out.println("Please enter a String first name");
        }
        try {
            this.lastName = lName;
        }catch(InputMismatchException ex){
            System.out.println("Please enter a String last name");
        }
        try{
            this.phoneNumber = phNumber;
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid phone number");
        }
        try{
            this.emailAddress = eAddress;
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid email address");
        }

    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmailAddress(){
        return emailAddress;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

}
