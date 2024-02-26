
package View;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;

import Common.Library;
import Controller.Controller;
import Model.Employee;

public class HandleFileView extends Menu<String> {

    private Controller controller;
    private Library library;

    public HandleFileView(String[] mc, String td, Controller controller) {
        super(mc, td);
        library = new Library();
        this.controller = controller;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                findPersonView();
                break;
            case 2:
                copyTextView();
                break;
            case 3:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void findPersonView() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            String path = library.getString("Enter file path");
            double money = library.getDouble("Enter money", "Numbers only");
            list = controller.findPersonInfo(path, money);
        } catch (FileNotFoundException e) {
            library.printErr("File not found...");
        } catch (FileSystemException e) {
            library.printErr("Can't read file");
        } catch (Exception e) {
            library.printErr(e.getMessage());
        }
        if (list.isEmpty()) {
            library.printErr("Cannot find anyone");
        } else {
            displayResult(list);
        }
    }

    public void copyTextView() {
        try {
            String src = library.getString("From");
            String dest = library.getString("To");
            controller.copyTextToFile(src, dest, library);
        } catch (Exception e) {
            library.printErr(e.getMessage());
        }
    }

    public void displayResult(ArrayList<Employee> employees) {
        double max = 0;
        double min = employees.get(0).getMoney();
        String maxEmp = "";
        String minEmp = "";
        System.out.printf("---------------Result---------------\n");
        for (Employee employee : employees) {
            System.out.printf("%-10s %-10s %-10.1f\n", employee.getName(), employee.getAddress(),
                    employee.getMoney());
            if (employee.getMoney() >= max) {
                max = employee.getMoney();
                maxEmp = employee.getName();
            }
            if (employee.getMoney() <= min) {
                min = employee.getMoney();
                minEmp = employee.getName();
            }
        }
        System.out.println("Max: " + maxEmp);
        System.out.println("Min: " + minEmp);
    }
}