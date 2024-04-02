
package View;

import Common.Library;
import Controller.Controller;

public class ProgramView extends Menu<String> {

    private Controller controller;
    private Library library;

    public ProgramView() {
        super(new String[] { "Enter program", "Exit" }, "Garbage Truck Manager");
        library = new Library();
        controller = new Controller(this);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                displayFunc1();
                break;
            case 2:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void displayFunc1() {
        boolean status = false;
        try {
            String[] inputs = library.getString("Enter ammount of garbage").split(" ");
            int result = controller.startProgram(inputs);
            library.printSuc("After run: " + result);
            status = true;
        } catch (Exception e) {
            library.printErr(e.getMessage());
        }
        if (status)
            library.printSuc("Success!");
        else
            library.printErr("Failed!");
    }

}