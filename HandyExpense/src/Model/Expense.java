package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expense {
    private int id;
    LocalDate date;
    private double number;
    private String content;

    public Expense(Expenses exps, String date, double number, String content) {
        this.id = exps.getCurId();
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.number = number;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        String s = String.format("%-5s %-15s %-20.0f %-15s", this.id, getDate(), number, content);
        return s;
    }

}
