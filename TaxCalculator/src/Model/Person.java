package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {
    private int age;
    private Person[] parents;
    private int numOfSiblings;
    private Child[] children;
    private int income;

    public Person() {

    }

    public Person(Person[] parents, Child[] children, int sib, int income) {
        this.parents = parents;
        this.children = children;
        this.income = income;
        this.numOfSiblings = sib;
    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person[] getParents() {
        return parents;
    }

    private String getParentsString() {
        String s = "";
        for (Person p : parents) {
            s = s.concat(p.getAge() + ", ");
        }
        return s;
    }

    public void setParents(Person[] parents) {
        this.parents = parents;
    }

    public Child[] getChildren() {
        return children;
    }

    public void setChildren(Child[] children) {
        this.children = children;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getNumOfSiblings() {
        return numOfSiblings;
    }

    public void setNumOfSiblings(int siblings) {
        this.numOfSiblings = siblings;
    }

    @Override
    public String toString() {
        String s = String.format("Income: %-10d\nParents: %s\nChildrens: %s\nSiblings: %d", income,
                getParentsString(), Arrays.toString(children), numOfSiblings);
        return s;
    }

}
