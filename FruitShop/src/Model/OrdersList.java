package Model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author phamm
 */
public class OrdersList {
    private Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();

    public Hashtable<String, ArrayList<Fruit>> getOrders() {
        return orders;
    }

    public void setOrders(Hashtable<String, ArrayList<Fruit>> orders) {
        this.orders = orders;
    }


}
