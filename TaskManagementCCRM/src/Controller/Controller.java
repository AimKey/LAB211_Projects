package Controller;

import java.util.ArrayList;

import Model.Task;
import Model.TaskType;
import Model.Tasks;
import View.TaskManagementView;

public class Controller {
    private TaskManagementView view;
    private Tasks tasks;

    public Controller(TaskManagementView view) {
        this.view = view;
        tasks = new Tasks();
    }

    public void addTask(int taskTypeId, String require, String date, Double from, Double to, String assignee,
            String expert) throws Exception {
        tasks.add(new Task(tasks, new TaskType(taskTypeId), require, from, to, assignee, expert, date));
    }

    public void deleteTask(int id) throws Exception {
        ArrayList<Task> result = tasks.search(p -> p.getId() == id);
        if (result.isEmpty())
            throw new Exception("Id does not exist");
        for (Task task : result) {
            tasks.remove(task);
        }
    }

    public Tasks getTasks() {
        return tasks;
    }
}
