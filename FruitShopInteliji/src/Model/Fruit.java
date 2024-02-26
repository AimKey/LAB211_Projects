package Model;

/**
 * @author phamm
 */
public class Fruit {
    protected String name, origin;
    protected int id, quanity;
    protected double price;

    public Fruit(String name, int quanity, double price, String origin) {
        this.name = name;
        this.origin = origin;
        this.quanity = quanity;
        this.price = price;
    }

    public Fruit(String name, int id, int quanity, double price, String origin) {
        this.name = name;
        this.origin = origin;
        this.id = id;
        this.quanity = quanity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String r = String.format("%-10s  %-10s  %-10.1f", name, origin, price);
        return r;
    }

}
