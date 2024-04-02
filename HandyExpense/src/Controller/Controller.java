package Controller;

import java.util.ArrayList;

import Model.Expense;
import Model.Expenses;
import View.ProgramView;

public class Controller {
    private ProgramView view;
    private Expenses expenses = new Expenses();

    public Controller(ProgramView view) {
        this.view = view;
        expenses.add(new Expense(expenses, "15/01/2024", 50, "Groceries"));
        expenses.add(new Expense(expenses, "02/02/2024", 30, "Dinner"));
        expenses.add(new Expense(expenses, "20/01/2024", 100, "Utilities"));
        expenses.add(new Expense(expenses, "10/02/2024", 20, "Transportation"));
        expenses.add(new Expense(expenses, "25/01/2024", 70, "Entertainment"));
        expenses.add(new Expense(expenses, "15/02/2024", 40, "Groceries"));
        expenses.add(new Expense(expenses, "30/01/2024", 60, "Dinner"));
        expenses.add(new Expense(expenses, "20/02/2024", 80, "Utilities"));
        expenses.add(new Expense(expenses, "05/02/2024", 25, "Transportation"));
        expenses.add(new Expense(expenses, "25/02/2024", 90, "Entertainment"));

    }

    public boolean add(String date, double money, String content) {
        expenses.add(new Expense(expenses, date, money, content));
        return true;
    }

    public boolean delete(int id) {
        ArrayList<Expense> r = expenses.search(p -> p.getId() == id);
        if (r.isEmpty())
            return false;
        for (Expense expense : r) {
            expenses.remove(expense);
        }
        return true;
    }

    public Expenses getExpenses() {
        return expenses;
    }

}
