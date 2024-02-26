package Model;

public class Contact implements Comparable<Contact> {
    private int id;
    private String fullName, group, address, phone, lastName, firstName;

    public Contact(String fullName, String group, String address, String phone, String lastName,
            String firstName) {
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String result = String.format("%-5d %-15s %-15s %-15s %-15s %-15s %-15s", id, fullName, lastName,
                firstName, group, address, phone);
        return result;
    }

    @Override
    public int compareTo(Contact o) {
        return this.id - o.id;
    }

}
