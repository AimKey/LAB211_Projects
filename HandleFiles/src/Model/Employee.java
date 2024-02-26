package Model;

public class Employee {
    private String name, address;
    private Double money;

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
        this.money = 0.0;
    }

    public Employee(String name, String address, Double money) {
        this.name = name;
        this.address = address;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", Money: " + money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

}
