import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Tree implements Serializable {

    /**
     * The data is serialized and stored in this file.
     */
    private String saveLocation = "out.txt";

    /**
     * The tree always has a root
     */
    private static TaskApp.Tree.Container root = new TaskApp.Tree.Container("");

    public Tree(String saveLocation) {
        this.saveLocation = saveLocation;
    }

    public Tree findAndAddTodo(TaskApp.Tree.TodoAbstract todo, int id) {
        if (id == 0) {
            root.add(todo);
        } else {
            root.findAndAddContainer(todo, id);
        }

        return this;
    }

    public Tree findAndDeleteTodo(int id) {
        if (id == 0) {
            System.out.printf("Can't delete the root");
            return this;
        } else {
            root.findAndDeleteTodo(id);
        }

        return this;
    }

    public String toString() {
        return root.toString();
    }

    public static String printTree() {
        return recursivePrint(root, 0);
    }

    private static String recursivePrint(TaskApp.Tree.TodoAbstract node, int level) {
        String result = "";
        String indent = "";
        for (int i = 0; i < level; i++) {
            indent += " ";
        }

        result += indent + "-" + node.getClass().getSimpleName() + "[id]=" + node.id + "\n";
        result += indent + "(todo): " + node.title + "\n";

        if (node.getClass() == TaskApp.Tree.Container.class) {
            for (Map.Entry<Integer, TaskApp.Tree.TodoAbstract> n : ((TaskApp.Tree.Container) node).todos.entrySet()) {
                result += recursivePrint(n.getValue(), level + 1);
            }
        }

        return result;
    }

    public TaskApp.Tree load() throws IOException, ClassNotFoundException {
        Path path = Paths.get(saveLocation);
        byte[] array = Files.readAllBytes(path);
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        ObjectInput in = null;

        try {
            in = new ObjectInputStream(bis);
            return (TaskApp.Tree) in.readObject();
        } finally {
            try {
                bis.close();
            } catch (IOException ex) {
// ignore close exception
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
// ignore close exception
            }
        }
    }

    public void save() throws IOException {
        OutputStream file = new FileOutputStream(saveLocation);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(this);
            file.write(bos.toByteArray());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
// ignore close exception
            }
            try {
                bos.close();
            } catch (IOException ex) {
// ignore close exception
            }
        }
        file.close();
    }
}
