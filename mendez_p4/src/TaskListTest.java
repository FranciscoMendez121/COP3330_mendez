import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize(){
        int size = 0;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        if(list.add(task))
            size++;
        assertEquals(size,1);
    }
    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        boolean itWorks = false;
        list.add(task);
        if(list.setMark(task))
            itWorks = true;
        assertEquals(itWorks,true);

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        boolean itWorks = true;
        list.add(task);

        try{
            list.setMark(task);
        }catch(IndexOutOfBoundsException ex){
            itWorks = false;
        }
        assertEquals(itWorks,false);
    }

    @Test
    public void editingTaskItemChangesValues(){
        boolean doesItChangeValue = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        if(list.editItem(task))
            doesItChangeValue = true;

        assertEquals(doesItChangeValue,true);

    }
    @Test
    public void editingTaskItemDescriptionChangesValue(){
        boolean doesItChangeValue = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        if(list.editItem(task))
            doesItChangeValue = true;

        assertEquals(doesItChangeValue,true);

    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        boolean doesItChangeValue = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        if(list.editItem(task))
            doesItChangeValue = true;

        assertEquals(doesItChangeValue,true);

    }
    @Test
    public void editingTaskItemDueDateChangesValue(){
        boolean doesItChangeValue = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        if(list.editItem(task))
            doesItChangeValue = true;

        assertEquals(doesItChangeValue,true);

    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        boolean doesItChangeValue = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        if(list.editItem(task))
            doesItChangeValue = true;

        assertEquals(doesItChangeValue,true);

    }
    @Test
    public void editingTaskItemTitleChangesValue(){
        boolean doesItChangeValue = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        if(list.editItem(task))
            doesItChangeValue = true;

        assertEquals(doesItChangeValue,true);

    }
    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        boolean doesItChangeValue = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        if(list.editItem(task))
            doesItChangeValue = true;

        assertEquals(doesItChangeValue,true);

    }
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        boolean itDoesNotWork = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        try{
            task.getTaskDescription();
        }catch(IndexOutOfBoundsException ex){
            itDoesNotWork = true;
        }

        assertEquals(itDoesNotWork,true);
    }
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        boolean itWorks = true;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        try{
            task.getTaskDescription();
        }catch(IndexOutOfBoundsException ex){
            itWorks = false;
        }

        assertEquals(itWorks,true);
    }
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        boolean itDoesNotWork = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        try{
            task.getTaskDate();
        }catch(IndexOutOfBoundsException ex){
            itDoesNotWork = true;
        }

        assertEquals(itDoesNotWork,true);
    }
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        boolean itWorks = true;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        try{
            task.getTaskDate();
        }catch(IndexOutOfBoundsException ex){
            itWorks = false;
        }

        assertEquals(itWorks,true);
    }
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        boolean itDoesNotWork = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        try{
            task.getTaskTitle();
        }catch(IndexOutOfBoundsException ex){
            itDoesNotWork = true;
        }

        assertEquals(itDoesNotWork,true);
    }
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        boolean itWorks = true;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        try{
            task.getTaskTitle();
        }catch(IndexOutOfBoundsException ex){
            itWorks = false;
        }

        assertEquals(itWorks,true);
    }
    @Test
    public void newTaskListIsEmpty(){
        boolean isEmpty = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        list.add(task);

        try{
            list.get(0);
        }catch(IndexOutOfBoundsException ex){
            isEmpty = true;
        }

        assertEquals(isEmpty,true);
    }
    @Test
    public void removingTaskItemsDecreasesSize(){
        int size = 1;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();

        if(list.remove(task))
            size--;
        assertEquals(size,0);
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        boolean itFails = false;
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();

        list.add(task);

        try{
            list.remove(task);
        }catch(IndexOutOfBoundsException ex){
            itFails = true;
        }

        assertEquals(itFails,true);
    }
    @Test
    public void savedTaskListCanBeLoaded(){
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();

        list.add(task);
        task.saveToFile();

        task.loadToFile();

    }
    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        boolean itWorks = true;
        list.add(task);

        list.unmarkAnItem();

        assertEquals(itWorks,true);
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("this","test","2020-02-07");
        ArrayList<TaskItem> list = new ArrayList<>();
        boolean itWorks = true;
        list.add(task);

        try{
            list.unmarkAnItem();
        }catch(IndexOutOfBoundsException ex){
            itWorks = false;
        }

        assertEquals(itWorks,false);
    }

}