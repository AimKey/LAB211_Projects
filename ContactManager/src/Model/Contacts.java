package Model;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Contacts extends ArrayList<Contact> {
    private int size = 0;

    @Override
    public boolean add(Contact e) {
        size++;
        e.setId(size);
        return super.add(e);
    }

    public ArrayList<Contact> search(Predicate<Contact> predicate) {
        ArrayList<Contact> res = new ArrayList<>();
        for (Contact contact : this) {
            if (predicate.test(contact))
                res.add(contact);
        }
        return res;
    }

}
