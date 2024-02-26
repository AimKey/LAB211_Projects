package Controller;

import Common.Library;
import Common.Validator;
import Model.Candidate;
import Model.Company;
import Model.Contact;
import Model.Experience;
import Model.Fresher;
import Model.Info;
import Model.Internship;
import View.Menu;
import java.util.ArrayList;

public class Controller extends Menu {

    Library lib = new Library();
    Validator validate = new Validator();
    Company company;
    public Controller() {
        super(new String[]{"Experience", "Fresher", "Internship", "Searching", "Exit"}, "Candidate Manager");
        company = new Company();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addExperience();
                break;
            case 2:
                addFresher();
                break;
            case 3:
                addIntern();
                break;
            case 4:
                doSearch();
                break;
            case 5:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void addExperience() {
        try {
            String fName = lib.getString("First name");
            String lName = lib.getString("Last name");
            int bDay = lib.getInt("Birth year");
            String address = lib.getString("Address");
            String phone = lib.getString("Phone");
            String email = lib.getString("Email");
            int expInYear = lib.getInt("Year of exp");
            String proSkill = lib.getString("Pro skill");

            boolean check1 = validate.checkCommon(bDay, phone, email);
            boolean check2 = validate.checkExpYear(expInYear);
            if (check1 == true && check2 == true) {
                Info i = new Info(fName, lName, bDay);
                Contact c = new Contact(address, phone, email);

                Experience e = new Experience("C"+company.getCandidates().size(), expInYear, proSkill, i, c, 0);
                company.getCandidates().add(e);
            }
        } catch (Exception e) {
            System.out.println("Invalid information!");
        }

    }

    public void addFresher() {
        try {
            String fName = lib.getString("First name");
            String lName = lib.getString("Last name");
            int bDay = lib.getInt("Birth year");
            String address = lib.getString("Address");
            String phone = lib.getString("Phone");
            String email = lib.getString("Email");
            String major = lib.getString("Major");
            int semester = lib.getInt("Semester");
            String uniName = lib.getString("University Name");
            boolean check1 = validate.checkCommon(bDay, phone, email);
            if (check1 == true) {
                Info i = new Info(fName, lName, bDay);
                Contact c = new Contact(address, phone, email);

                Fresher f = new Fresher("C"+company.getCandidates().size(), major, semester, uniName, i, c, 1);
                company.getCandidates().add(f);
            }

        } catch (Exception e) {
            System.out.println("Invalid information!");
        }

    }

    public void addIntern() {
        try {
            String fName = lib.getString("First name");
            String lName = lib.getString("Last name");
            int bDay = lib.getInt("Birth year");
            String address = lib.getString("Address");
            String phone = lib.getString("Phone");
            String email = lib.getString("Email");
            String date = lib.getString("Date of graduation (dd/MM/yyyy)");
            String graduationRank = lib.getString("Graduation Rank (Excellence, Good, Fair, Poor)");
            String education = lib.getString("Education");

            boolean check1 = validate.checkCommon(bDay, phone, email);
            boolean check2 = validate.checkGraduationRank(graduationRank);

            if (check1 == true && check2 == true) {
                Info i = new Info(fName, lName, bDay);
                Contact c = new Contact(address, phone, email);

                Internship intern = new Internship("C"+company.getCandidates().size(), date, graduationRank, education, i, c, 2);
                company.getCandidates().add(intern);
            }

        } catch (Exception e) {
            System.out.println("Invalid information!");
        }
    }

    public void doSearch() {
        company.display();
        String name = lib.getString("Input candidate name (first name or last name)");
        int type = lib.getInt("Input type of candidate");
        ArrayList<Candidate> result = company.search(name, type);
        System.out.println("Found candidates: ");
        for (Candidate object : result) {
            System.out.println(object);
        }
    }   

}
