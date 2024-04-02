
package View;

import java.util.ArrayList;

import Common.Library;
import Common.Validate;
import Controller.Controller;
import Model.Person;

public class ProgramView extends Menu<String> {

    private Controller controller;
    private Library library;
    private Validate validate;

    public ProgramView() {
        super(new String[] { "Enter person info", "Display after sort", "Exit" }, "Human management");
        library = new Library();
        validate = new Validate();
        controller = new Controller(this);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                displayInputPerson();
                break;
            case 2:
                displayPersons();
                break;
            case 3:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void displayInputPerson() {
        boolean status = false;
        try {
            String name = library.getString("Enter name", "Characters only");
            String address = library.getString("Enter address");
            Double salary = library.getDouble("Enter salary", "Digit only");
            controller.enterPerson(new Person(name, address, salary));
            validate.validate("You must input salary", salary, p -> p != -1);
            validate.validate("Salary should be > 0", salary, p -> p > 0);
            status = true;
        } catch (Exception e) {
            library.printErr(e.getMessage());
            status = false;
        }
        if (status)
            library.printSuc("Success");
        else
            library.printErr("Failed!");
    }

    public void displayPersons() {
        ArrayList<Person> persons = new ArrayList<>();
        persons = controller.sortPerson();
        for (Person person : persons) {
            System.out.println(person);
        }
    }

}