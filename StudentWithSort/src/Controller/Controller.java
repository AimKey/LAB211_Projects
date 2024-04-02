package Controller;

import java.util.Collections;

import Model.Student;
import Model.Students;
import View.StudentManagement;

public class Controller {
    private StudentManagement view;

    private Students students = new Students();

    public Controller(StudentManagement view) {
        this.view = view;
    }

    public boolean addStudent(Student student) {
        students.add(student);
        Collections.sort(students);
        return true;
    }

    public Students displayStudents() {
        return students;
    }

}
