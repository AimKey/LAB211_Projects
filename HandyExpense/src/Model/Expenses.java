package Model;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Expenses extends ArrayList<Expense> {
    private int size = 0;

    public ArrayList<Expense> search(Predicate<Expense> p) {
        ArrayList<Expense> es = new ArrayList<>();
        for (Expense e : this) {
            if (p.test(e))
                es.add(e);
        }
        return es;
    }

    public int getCurId() {
        size += 1;
        return size;
    }
}
