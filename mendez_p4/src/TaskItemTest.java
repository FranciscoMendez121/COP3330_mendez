import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        String date = "8888444000";

        TaskItem actual = new TaskItem("incorrect","This is invalid",date);
        assertEquals(actual.createTaskItem("incorrect","this is invalid",date), actual);

    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        String title = "Assignment 4";
        String description = "this is due soon";
        String date = "2020-02-22";

        TaskItem actual = new TaskItem(title, description, date);

        TaskItem expected = new TaskItem("Assignment 4", "this is due soon","2020-02-22");

        assertEquals(actual,expected);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){

        String title = "Assignment 4";
        String description = "this is due soon";
        String date = "2020-02-22";

        TaskItem actual = new TaskItem(title, description, date);

        TaskItem expected = new TaskItem("Assignment 4", "this is due soon","2020-02-22");

        assertEquals(actual,expected);
    }


    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        String title = "Assignment 4";
        String description = "this is due soon";
        String date = "2020-02-22";

        TaskItem actual = new TaskItem(title, description, date);

        TaskItem expected = new TaskItem("Assignment 4", "this is due soon","2020-02-22");

        assertEquals(actual,expected);

    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        String date = "1865-04-08";
        TaskItem item = new TaskItem("This is a random date","this is past due",date);
        item.setTaskDate(date);
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        String date = "1865-04-08";
        TaskItem item = new TaskItem("This is a random date","this is past due",date);
        item.setTaskDate(date);
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        String invalidTitle = "14";
        TaskItem item = new TaskItem(invalidTitle,"this is an incorrect title","1888-10-19");
        item.setTaskTitle(invalidTitle);

    }


    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        String title = "This is the title";
        TaskItem task = new TaskItem(title,"due tomorrow","2020-02-03");
        task.setTaskTitle(title);
    }


}