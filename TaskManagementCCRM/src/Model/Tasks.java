package Model;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Tasks extends ArrayList<Task> {
    private int size = 0;

    public ArrayList<Task> search(Predicate<Task> p) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : this) {
            if (p.test(task))
                tasks.add(task);
        }
        return tasks;
    }

    public int getCurId() {
        size += 1;
        return size;
    }
}
