package View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import Model.Contact;

public class View {
    public void display(ArrayList<Contact> arr) {
        // TODO: Fix display
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s %-15s\n", "ID", "Name", "Last name", "First name",
                "Group", "Address", "Phone");
        Collections.sort(arr);
        for (Contact contact : arr) {
            System.out.println(contact);
        }
        System.out.println("Total: " + arr.size());
    }
}
