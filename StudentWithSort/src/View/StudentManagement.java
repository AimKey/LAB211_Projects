
package View;

import Common.Library;
import Common.Validate;
import Controller.Controller;
import Model.Student;
import Model.Students;

public class StudentManagement extends Menu<String> {

    private Controller controller;
    private Library library;
    private Validate validate;

    public StudentManagement() {
        super(new String[] { "Sort students", "Display students", "Exit" }, "Student management");
        library = new Library();
        validate = new Validate();
        controller = new Controller(this);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                EnterStudentView();
                break;
            case 2:
                DisplayStudent();
                break;
            case 3:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void EnterStudentView() {
        boolean status = false;
        try {
            do {
                String name = library.getString("Enter name", "Characters only");
                double mark = library.getDouble("Enter mark", "Numbers only");
                String classes = library.getString("Enter classes");
                validate.validate("Mark should not < 0", mark, p -> p >= 0);
                status = controller.addStudent(new Student(name, classes, mark));
            } while (library.getString("Again (y/n)").equals("y"));
        } catch (Exception e) {
            library.printErr(e.getMessage());
            status = false;
        }
        if (status)
            library.printSuc("Success!");
        else
            library.printErr("Failed");
    }

    public void DisplayStudent() {
        Students students = controller.displayStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

}