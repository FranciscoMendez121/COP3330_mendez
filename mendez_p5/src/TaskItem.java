
import java.io.Serializable;
import java.util.InputMismatchException;


    public class TaskItem implements Serializable{
    protected String title;
    protected String date;
    protected String description;

    public TaskItem(String title, String date, String description){
        try{
            this.title = title;
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid title");
        }
        try{
            this.date = date;
        }catch(InputMismatchException ex){
            System.out.println("Please enter a valid date: ");
        }
        try{
            this.description = description;
        }catch(InputMismatchException ex){
            System.out.println("please enter a valid description");
        }
    }

    public String getTitle(){
        return title;
    }

    public String getDate(){
        return date;
    }

    public String getDescription(){
        return description;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setDescription(String description){
        this.description = description;
    }



}
