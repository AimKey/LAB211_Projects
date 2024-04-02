package View;

import Common.Library;
import Controller.Controller;
import java.util.ArrayList;

/**
 * Change this to your program name
 */
public class ProgramView extends Menu<String> {

    private Controller controller;
    private Library library;

    public ProgramView() {
        super(new String[] { "Enter information", "Exit" }, "Tax calculator");
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
            // Income, parents, children, siblings
            int income = library.getInt("Enter total income", "Digits only");
            ArrayList<Integer> parents = new ArrayList<>();
            int pCount = library.getInt("How many parents do you have", "Digits only");
            for (int i = 0; i < pCount; i++) {
                parents.add(library.getInt("Enter parent age", "Digits only"));
            }
            ArrayList<String> children = new ArrayList<>();
            pCount = library.getInt("How many child do you have", "Digits only");
            for (int i = 0; i < pCount; i++) {
                int childAge = library.getInt("Enter child age", "Digits only");
                boolean isStudy = false;
                if ("y".equals(library.getString("Is your child studying ?(y/n)"))) {
                    isStudy = true;
                }
                children.add(String.format("%s:%b", childAge, isStudy));
            }

            int sibs = library.getInt("Enter the number of siblings", "Digits only");
            int result = controller.enterPersonAndCalcTax(income, parents, children, sibs);
            library.printSuc("Tax money: " + result);
            status = true;
        } catch (Exception e) {
            library.printErr(e.getMessage());
        }
        if (status) {
            library.printSuc("Success");
        } else {
            library.printErr("Failed");
        }
    }

}
