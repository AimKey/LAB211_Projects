package Controller;

import java.util.ArrayList;

import Common.Library;
import Common.Validator;
import Model.Contact;
import Model.Contacts;
import View.Menu;
import View.View;

public class Controller extends Menu {

    static String[] mc = { "Add a contact", "Display all contact", "Delete a contact", "Exit" };
    Library lib = new Library();
    Contacts contacts;
    View view;
    Validator validator;

    public Controller() {
        super(mc, "Contact Manager");
        contacts = new Contacts();
        view = new View();
        validator = new Validator();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                doAdd();
                break;
            case 2:
                doDisplay();
                break;
            case 3:
                doDelete();
                break;
            case 4:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void doAdd() {
        String fullName = lib.getString("Full Name", "Characters only");
        String group = lib.getString("Group", "Characters only");
        String address = lib.getString("Address");
        String phone;
        while (true) {
            phone = lib.getString("Enter phone");
            if (validator.validatePhone(phone) == false) {
                lib.printErr("Wrong phone format");
            } else
                break;
        }
        String lastName = lib.getString("Last Name", "Characters only");
        String firstName = lib.getString("First Name", "Characters only");
        contacts.add(new Contact(fullName, group, address, phone, lastName, firstName));
    }

    public void doDisplay() {
        view.display(contacts);
    }

    public void doDelete() {
        int delId = lib.getInt("Enter ID", "Number only");
        ArrayList<Contact> result = contacts.search(p -> p.getId() == delId);
        if (result.isEmpty())
            lib.printErr("No contact found");
        else {
            for (Contact contact : result) {
                contacts.remove(contact);
            }
            System.out.println("Delete successfully");
        }
    }
}
