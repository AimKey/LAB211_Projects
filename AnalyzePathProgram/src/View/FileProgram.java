
package View;

import Common.Library;
import Controller.Controller;
import Model.UserFile;

public class FileProgram extends Menu<String> {

    private Controller controller;
    private Library library;

    public FileProgram() {
        super(new String[] { "Enter input path", "Exit" }, "Analyze File Path");
        library = new Library();
        controller = new Controller(this);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                displayFile();
                break;
            case 2:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void displayFile() {
        boolean status = false;
        try {
            String filePath = library.getString("Enter file path to analyze");
            UserFile file = new UserFile(filePath);
            controller.analyzeFile(file);
            status = true;
        } catch (Exception e) {
            library.printErr(e.getMessage());
            status = false;
        }
        if (status)
            library.printSuc("Success");
        else
            library.printErr("Failed!...");
    }

    public void displayFile(UserFile userFile) {
        System.out.println(userFile);
    }

}