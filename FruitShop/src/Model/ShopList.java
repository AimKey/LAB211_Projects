package Model;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author phamm
 */

public class ShopList extends ArrayList<Fruit> {
    public Fruit buyStuff(Fruit f, int buyQuantity) {
        int curQuantity = f.getQuanity() - buyQuantity;
        if (curQuantity >= 0) {
            f.setQuanity(f.getQuanity() - buyQuantity);
            return new Fruit(f.name, buyQuantity, f.price, f.origin);
        } else {
            return null;
        }
    }


    public ArrayList<Fruit> search(Predicate<Fruit> p) {
        ArrayList<Fruit> fruits = new ArrayList<>();
        for (Fruit f : this) {
            if (p.test(f)) fruits.add(f);
        }
        return fruits;
    }

}
