package Model;

public class Person implements Comparable<Person> {
    private String name, address;
    private Double salary;

    public Person(String name, String address, Double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, address: %s, salary: %.2f", name, address, salary);
    }

    @Override
    public int compareTo(Person o) {
        return (int) (this.salary - o.salary);
    }

}
