
package View;

import Common.Library;
import Common.Validate;
import Controller.Controller;
import Model.Task;
import Model.Tasks;

public class TaskManagementView extends Menu<String> {

    private Controller controller;
    private Library library;
    private Validate validate;

    public TaskManagementView() {
        super(new String[] { "Add task", "Delete task", "Show task", "Exit" }, "Task management");
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
                delView();
                break;
            case 3:
                showView();
                break;
            case 4:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void addView() {
        boolean status;
        try {
            int taskTypeId = library.getInt("Enter task typeId");
            String require = library.getString("Enter requirements");
            String date = library.getString("Enter date");
            Double from = library.getDouble("Plan from", "Digits only");
            Double to = library.getDouble("Plan to", "Digits only");
            validate.validate("From/to must in range: 8.0 -> 17.5", new Double[] { from, to },
                    p -> p >= 8 && p <= 17.5);
            if (from >= to)
                throw new Exception("Plan from should not greater than plan to");
            String assignee = library.getString("Enter assignee");
            String expert = library.getString("Enter expert");
            controller.addTask(taskTypeId, require, date, from, to, assignee, expert);
            status = true;
        } catch (Exception e) {
            library.printErr(e.getMessage());
            status = false;
        }
        if (status)
            library.printSuc("Success");
        else
            library.printErr("Failed");
    }

    public void delView() {
        boolean status;
        try {
            int id = library.getInt("Enter ID", "Number only");
            controller.deleteTask(id);
            status = true;
        } catch (Exception e) {
            library.printErr(e.getMessage());
            status = false;
        }
        if (status)
            library.printSuc("Success");
        else
            library.printErr("Failed");

    }

    // TaskTypeID, Requirement Name, Date, PLan from, plan to, Assignee, Expert
    public void showView() {
        Tasks tasks = controller.getTasks();
        System.out.printf("%-5s|%-10s|%-15s|%-15s|%-15s|%-10s|%-10s|%-10s\n", "ID", "TypeID", "Requirements",
                "Assignee", "Expert", "PlanFrom", "PlanTo", "Date");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

}