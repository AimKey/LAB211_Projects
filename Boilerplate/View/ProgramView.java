
package View;

import Common.Library;
import Common.Validate;
import Controller.Controller;

/**
 * Change this to your program name
 */
public class ProgramView extends Menu<String> {

    private Controller controller;
    private Library library;
    private Validate validate;

    // TODO: Change functions names, title, and choices
    public ProgramView() {
        super(new String[] { "function 1", "function 2", "function 3", "Exit" }, "Program title");
        library = new Library();
        validate = new Validate();
        controller = new Controller(this);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                displayFunc1();
                break;
            case 2:
                displayFunc2();
                break;
            case 3:
                displayFunc3();
                break;
            case 4:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void displayFunc1() {
        controller.func1();
    }

    public void displayFunc2() {
        controller.func2();

    }

    public void displayFunc3() {
        controller.func3();

    }

}