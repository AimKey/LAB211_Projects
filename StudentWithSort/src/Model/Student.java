package Model;

public class Student implements Comparable<Student> {
    private String name, classes;
    private double mark;

    public Student(String name, String classes, double mark) {
        this.name = name;
        this.classes = classes;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        String s = String.format("Name: %-10s, mark: %.2f, classes: %-10s", name, mark, classes);
        return s;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }

}
