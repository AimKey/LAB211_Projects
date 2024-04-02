
package View;

import Common.Library;
import Common.Validate;
import Controller.Controller;
import Model.Expense;
import Model.Expenses;

public class ProgramView extends Menu<String> {
    private Controller controller;
    private Library library;
    private Validate validate;

    public ProgramView() {
        super(new String[] { "Add expense", "Display expense", "Remove expense", "Exit" }, "Handy Expense");
        library = new Library();
        validate = new Validate();
        controller = new Controller(this);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addView();
                break;
            case 2:
                displayView();
                break;
            case 3:
                deleteView();
                break;
            case 4:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void addView() {
        boolean status = false;
        try {
            String date = library.getString("Enter date");
            Double money = library.getDouble("Enter money", "Digits only");
            String content = library.getString("Enter content");
            validate.validate("Money should not be negative", money, p -> p >= 0);
            status = controller.add(date, money, content);
        } catch (NumberFormatException e) {
            library.printErr("Wrong date format");
        } catch (Exception e) {
            library.printErr(e.getMessage());
        }
        if (status)
            library.printSuc("Success");
        else
            library.printErr("Failed");
    }

    public void displayView() {
        Expenses expenses = controller.getExpenses();
        System.out.printf("%-5s|%-15s|%-20s|%-15s\n", "ID", "Date", "Ammount of money", "Content");
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public void deleteView() {
        boolean status = false;
        try {
            int id = library.getInt("Enter id", "Number only");
            status = controller.delete(id);
        } catch (Exception e) {
            library.printErr(e.getMessage());
        }
        if (status)
            library.printSuc("Success");
        else
            library.printErr("Id not found");

    }

}