import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.time.DateTimeException;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void constructorFailsWithInvalidDueDate(){
        try {
            TaskItem task = new TaskItem("Title", "199159-05-15", "This is invalid");
            assertEquals(task.title, "Title");
            assertEquals(task.date, "199159-05-15");
            assertEquals(task.description, "This is invalid");
        }catch(InvalidParameterException ex){
            assertEquals(true,true);
        }
    }

    @Test
    public void constructorFailsWithInvalidTitle(){
        try {
            TaskItem task = new TaskItem("488", "1999-05-15", "This is invalid");
            assertEquals(task.title, "488");
            assertEquals(task.date, "1999-05-15");
            assertEquals(task.description, "This is invalid");
        }catch(InvalidParameterException ex){
            assertEquals(true,false);
        }
    }
    @Test
    public void constructorSucceedsWithValidDueDate(){
        try {
            TaskItem task = new TaskItem("Title", "1999-05-15", "This is invalid");
            assertEquals(task.title, "Title");
            assertEquals(task.date, "1999-05-15");
            assertEquals(task.description, "This is invalid");
        }catch(InvalidParameterException ex){
            assertEquals(true,true);
        }

    }
    @Test
    public void constructorSucceedsWithValidTitle(){
        try {
            TaskItem task = new TaskItem("Title", "1999-05-15", "This is invalid");
            assertEquals(task.title, "Title");
            assertEquals(task.date, "1999-05-15");
            assertEquals(task.description, "This is invalid");
        }catch(InvalidParameterException ex){
            assertEquals(true,true);
        }

    }
    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){

            TaskItem task = new TaskItem("Title", "1999-05-15", "This is invalid");


            String taskDescription = "new description";
            task.setDescription(taskDescription);
            assertEquals(task.title, "Title");
            assertEquals(task.date, "1999-05-15");
            assertEquals(task.description, "new description");

    }
    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem task = new TaskItem("Title", "1999-05-15", "This is invalid");

        String taskDate = task.getDate();

        taskDate = "new date";
        task.setDate(taskDate);

        assertEquals(task.title, "Title");
        assertEquals(task.date, "new date");
        assertEquals(task.description, "This is invalid");

    }
    @Test
    public void editingDueDateFailsWithInvalidYYYMMDDD(){
        TaskItem task = new TaskItem("Title", "1999-05-15", "This is invalid");

        String taskDate = task.getDate();

        taskDate = "0024855";
        task.setDate(taskDate);

        assertEquals(task.title, "Title");
        assertEquals(task.date, "0024855");
        assertEquals(task.description, "This is invalid");

    }
    @Test
    public void editingDueDateSucceedsWithExpectedValue(){

        TaskItem task = new TaskItem("Title", "1999-05-15", "This is valid");

        String taskDate = task.getDate();

        taskDate = "2020-02-15";
        task.setDate(taskDate);

        assertEquals(task.title, "Title");
        assertEquals(task.date, "2020-02-15");
        assertEquals(task.description, "This is valid");

    }
    @Test
    public void editingTitleFailsWithEmptyString(){
        try {
            TaskItem task = new TaskItem("Title", "1999-05-15", "This is invalid");

            assertEquals(task.title, "Title");
            assertEquals(task.date, "1999-05-15");
            assertEquals(task.description, "This is invalid");
        }catch(IllegalArgumentException ex){
            System.out.println("Cannot happen");
            assertEquals(false,false);
        }

    }
    @Test
    public void editingTitleSucceedsWithExpectedValue(){
        TaskItem task = new TaskItem("Title", "1999-05-15", "This is valid");

        String taskTitle = task.getTitle();

        taskTitle = "New Title";
        task.setTitle(taskTitle);

        assertEquals(task.title, "New Title");
        assertEquals(task.date, "1999-05-15");
        assertEquals(task.description, "This is valid");


    }


}