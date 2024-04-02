
package View;

import Common.Library;
import Controller.Controller;
import Model.InputData;

public class ProgramView extends Menu<String> {

    private Controller controller;
    private Library library;

    public ProgramView() {
        super(new String[] { "Enter data", "Exit" }, "Check Data Program");
        library = new Library();
        controller = new Controller(this);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                checkDataView();
                break;
            case 2:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void checkDataView() {
        InputData inputData = new InputData();
        String number = "";
        String status = "";
        do {
            number = library.getString("Enter number");
            status = inputData.setNumber(number);
            if (status != "") {
                library.printErr(status);
            }
        } while (status != "");

        String email = "";
        status = "";
        do {
            email = library.getString("Enter email");
            status = inputData.setEmail(email);
            if (status != "") {
                library.printErr(status);
            }
        } while (status != "");

        String date = "";
        status = "";
        do {
            date = library.getString("Enter date");
            status = inputData.setDate(date);
            if (status != "") {
                library.printErr(status);
            }
        } while (status != "");
        System.out.println(inputData);
    }

}