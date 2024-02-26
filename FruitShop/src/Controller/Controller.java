package Controller;

import Common.Library;
import Model.Fruit;
import Model.OrdersList;
import Model.ShopList;
import Model.ShoppingCart;
import View.FruitView;
import View.Menu;

public class Controller extends Menu {

    Library lib = new Library();
    ShoppingCart cart;
    OrdersList orders;
    FruitView view = new FruitView();
    ShopList store;

    public Controller() {
        super(new String[]{"Create fruits", "View orders", "Shopping", "Exit"},
                "FRUIT SHOP SYSTEM");
        cart = new ShoppingCart();
        orders = new OrdersList();
        store = new ShopList();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                doAdd();
                break;
            case 2:
                doView();
                break;
            case 3:
                doShop();
                break;
            case 4:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void doAdd() {
        do {
            int id = lib.getInt("Enter fruit id", "Wrong input");
            if (id == -1) {
                id = store.size() + 1;
            }
            String name = lib.getString("Enter fruit name", "Wrong input");
            double price = lib.getDouble("Enter fruit price", "Wrong input");
            int quantity = lib.getInt("Enter fruit quantity", "Wrong input");
            String origin = lib.getString("Enter fruit origin", "Wrong input");
            store.add(new Fruit(name, id, quantity, price, origin));
        } while (lib.getString("Do you want to continue (Y/N)?", "Please input character!").equalsIgnoreCase("Y"));
        Menu m = new Menu(store, "Current fruits") {
            @Override
            public void execute(int n) {
            }
        };
        m.display();
    }

    public void doView() {
        if (orders.getOrders().isEmpty()) {
            System.out.println("Order is empty!, go buy something <3");
        } else {
            view.displayOrders(orders.getOrders());
        }
    }

    public void doShop() {
        if (!store.isEmpty()) {
            do {
                view.shoppingView(store);
                int select = lib.getInt("Enter item to get", "Please enter number");
                Fruit curFruit;
                try {
                    curFruit = store.get(select - 1);
                    System.out.println("You selected: " + curFruit.getName());
                    int buyQuantity = lib.getInt("Please input quantity", "Numbers only");
                    Fruit product = store.buyStuff(curFruit, buyQuantity);
                    if (product == null) {
                        System.out.println("Current stock is not enough, stock: " + curFruit.getQuanity());
                    } else {
                        cart.add(product);
                    }
                } catch (Exception e) {
                    System.out.println("No fruits found!");
                }
            } while (lib.getString("Do you want to order now (Y/N)?", "Please input character!").equalsIgnoreCase("N"));
            if (cart.isEmpty()) {
                System.out.println("Cart is empty, please try again");
            } else {
                String name = lib.getString("Tell us your name");
                view.displayOrder(cart);
                orders.getOrders().put(name, cart);
                cart = new ShoppingCart();
            }
        }
    }
}
