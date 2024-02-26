package View;

import Model.Fruit;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author phamm
 */
public class FruitView {
    public void displayOrder(ArrayList<Fruit> arr) {
        double total = 0;
        System.out.println("Product | Quantity | Price | Amount");
        for (int i = 0; i < arr.size(); i++) {
            Fruit f = arr.get(i);
            double fruitPrice = f.getQuanity() * f.getPrice();
            total += fruitPrice;
            System.out.printf("%d.%-10s %-7d %.1f$   %.1f$\n", i + 1, f.getName(), f.getQuanity(), f.getPrice(), fruitPrice);
        }
        System.out.println("Total: " + total + "$");
    }

    public void displayOrders(Hashtable<String, ArrayList<Fruit>> OrdersList) {
        OrdersList.forEach((key, value) -> {
            System.out.println("Customer name: " + key);
            displayOrder(value);
            System.out.println("-----------------------------");
        });
    }

    public void shoppingView(ArrayList<Fruit> store) {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (Fruit fruit : store) {
            if (fruit.getQuanity() == 0) continue;
            System.out.printf("%7d %18s %18s %10.1f$\n", fruit.getId(), fruit.getName(), fruit.getOrigin(), fruit.getPrice());
        }
    }
}
