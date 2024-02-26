package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import Common.Library;
import Model.Employee;
import Model.Employees;
import View.HandleFileView;

public class Controller {

    private HandleFileView view;
    private Employees employees;

    public Controller() {
        view = new HandleFileView(new String[] { "Find person info", "Copy Text", "Exit" },
                "Hande files program", this);
        view.run();
    }

    public ArrayList<Employee> findPersonInfo(String filePath, double money) throws Exception {
        employees = new Employees(filePath);
        ArrayList<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getMoney() >= money)
                result.add(employee);
        }
        return result;
    }

    public boolean copyTextToFile(String src, String dest, Library lib) throws Exception {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        boolean status = false;
        try {
            File d = new File(dest);
            if (!d.exists())
                d.createNewFile();
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            lib.printSuc("Copying complete!");
        } catch (FileNotFoundException e) {
            lib.printErr("File not found");
        } catch (Exception e) {
            lib.printErr(e.getMessage());
        } finally {
            if (fis != null)
                fis.close();
            if (fos != null)
                fos.close();
        }
        return status;
    }

}
