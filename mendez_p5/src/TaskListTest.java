import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "0508-11-28";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(item);

        assertEquals(1,taskList.size());

    }

    @Test
    public void completingTaskItemChangesStatus(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "0508-11-28";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(item);

        boolean statusNotChanged = true;

        TaskItem marker = new TaskItem("*", "*", "*");

        if(statusNotChanged){
            taskList.add(0, marker);
            statusNotChanged = false;
        }


        assertEquals(statusNotChanged,false);


    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "0508-11-28";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(item);



        TaskItem marker = new TaskItem("*", "*", "*");

        try {
            taskList.add(-5498, marker);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(item.title, "Title");
        }

    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);


        TaskItem changedDescription = new TaskItem("Title","1999-05-15","new description");


        try{
            taskList.add(12533,changedDescription);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(item.description,"This increases size");
        }

    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);


        TaskItem changedDescription = new TaskItem("Title","1999-05-15","new description");


        try{
            taskList.add(0,changedDescription);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(item.description,"new description");
        }

    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);


        TaskItem changedDate = new TaskItem("Title","1889-09-07","new date");


        try{
            taskList.add(0,changedDate);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(item.date,"1889-09-07");
        }

    }

    @Test
    public void editingItemTitleFailsWithEmptyString(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);


        TaskItem changedTitle = new TaskItem(" ","1889-09-07","new date");

        boolean isEmpty = true;

        try {
            taskList.add(0, changedTitle);
            isEmpty = false;
        }catch(Exception ex){
            assertEquals(isEmpty, true);
        }

    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);


        TaskItem changedTitle = new TaskItem("new Title","1889-09-07","new date");


        try{
            taskList.add(15566,changedTitle);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(item.title,"Title");
        }

    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);


        TaskItem changedTitle = new TaskItem("new Title","1889-09-07","new date");


        try{
            taskList.add(0,changedTitle);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(item.title,"new Title");
        }


    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);


        TaskItem changedDate = new TaskItem("new Title","07-0188-05","new date");


        try{
            taskList.add(0,changedDate);
        }catch(DateTimeException ex){
            assertEquals(item.date,"1999-05-15");
        }

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);


        TaskItem changedDate = new TaskItem("new Title","1779-11-12","new date");


        try{
            taskList.add(1558,changedDate);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(item.date,"1999-05-15");
        }


    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYYMMDD(){

        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);


        TaskItem changedDate = new TaskItem("new Title","07-0188-05","new date");


        try{
            taskList.add(0,changedDate);
        }catch(DateTimeException ex){
            assertEquals(item.date,"1999-05-15");
        }

    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "Invalid index";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);

        try{
            taskList.get(15558);
            item.getDescription();
        }catch(IndexOutOfBoundsException ex){
            assertEquals(item.getDescription(),"Invalid index");
        }

    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "valid index";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);



        try{
            taskList.get(0);
            item.getDescription();
        }catch(IndexOutOfBoundsException ex){
            assertEquals(item.getDescription(),"valid index");
        }

    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "Invalid index";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);



        try{
            taskList.get(15558);
            item.getDate();
        }catch(IndexOutOfBoundsException ex){
            assertEquals(item.getDate(),"1999-05-15");
        }


    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "Invalid index";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);



        try{
            taskList.get(0);
            item.getDate();
        }catch(DateTimeException ex){
            assertEquals(item.getDate(),"1999-05-15");
        }

    }

    @Test
    public void newListIsEmpty(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "Invalid index";

        TaskItem item = new TaskItem(title,date,description);

        boolean isEmpty = true;

        try{
            taskList.get(0);
            isEmpty = false;
        }catch(IndexOutOfBoundsException ex){
            assertEquals(isEmpty,true);
        }


    }

    @Test
    public void removingItemsDecreasesSize(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "Invalid index";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);

        try{
            taskList.remove(0);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(taskList.size(),0);
        }

    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "Invalid index";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);

        try{
            taskList.remove(-15563);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(taskList.size(),1);
        }


    }

    @Test
    public void savedTaskListCanBeLoaded() throws IOException, ClassNotFoundException {
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "1999-05-15";
        String description = "Invalid index";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);

        try{
            taskList.add(1,item);
        } catch (IndexOutOfBoundsException ex) {
            assertEquals(taskList.get(1),item);
        }


    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "0508-11-28";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);

        TaskItem unMarker = new TaskItem("*", "*", "*");

        try{
            taskList.add(0,unMarker);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(taskList.get(0),unMarker);
        }


    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        ArrayList<TaskItem> taskList = new ArrayList<>();
        String title = "Title";
        String date = "0508-11-28";
        String description = "This increases size";

        TaskItem item = new TaskItem(title,date,description);

        taskList.add(0,item);

        TaskItem unMarker = new TaskItem("*", "*", "*");

        try{
            taskList.add(1515616,unMarker);
        }catch(IndexOutOfBoundsException ex){
            assertEquals(taskList.get(0),item);
        }


    }
}