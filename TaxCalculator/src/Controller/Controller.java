package Controller;

import Common.Validate;
import Model.Child;
import Model.Person;
import Model.TaxCalculator;
import View.ProgramView;
import java.util.ArrayList;

public class Controller {

    private ProgramView view;
    private Validate val;

    public Controller(ProgramView view) {
        this.view = view;
        this.val = new Validate();
    }

    public int enterPersonAndCalcTax(int income, ArrayList<Integer> parents, ArrayList<String> childString, int sibs)
            throws Exception {
        Person[] ps = new Person[parents.size()];
        for (int i = 0; i < ps.length; i++) {
            ps[i] = new Person(parents.get(i));
        }
        Child[] cs = new Child[childString.size()];

        if (!childString.isEmpty()) {
            for (int i = 0; i < childString.size(); i++) {
                String[] newInp = childString.get(i).split(":");
                cs[i] = (new Child(Integer.parseInt(newInp[0]), Boolean.parseBoolean(newInp[1])));
            }
        }

        Person p = new Person(ps, cs, sibs, income);
        System.out.println("Person created:");
        System.out.println(p);
        return calcTax(p);
    }

    public int calcTax(Person p) {
        TaxCalculator t = new TaxCalculator();
        return t.calcDeduction(p);
    }

}
