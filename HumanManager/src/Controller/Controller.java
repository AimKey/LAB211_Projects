package Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import Model.Person;
import View.ProgramView;

public class Controller {
    private ProgramView view;
    private ArrayList<Person> persons = new ArrayList<>();

    public Controller(ProgramView view) {
        this.view = view;
    }

    public void enterPerson(Person person) {
        persons.add(person);
    }

    public ArrayList<Person> sortPerson() {
        int n = persons.size();
        int i, j;
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - i - 1; j++) {
                Person pre = persons.get(j);
                Person next = persons.get(j + 1);
                if (pre.compareTo(next) > 0) {
                    persons.set(j, next);
                    persons.set(j + 1, pre);
                }
            }
        }
        return this.persons;
    }

}
