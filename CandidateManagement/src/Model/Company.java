package Model;

import java.util.ArrayList;

public class Company {

    private ArrayList<Candidate> candidates = new ArrayList<>();
    
    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    public boolean checkForDup(Candidate item) {
        return !candidates.contains(item);
    }

    public void display() {
        System.out.println("=========Experience========");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFullName());
            }
        }
        System.out.println("==========Fresher==========");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFullName());
            }
        }
        System.out.println("==========Internship===========");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFullName());
            }
        }
    }

    public ArrayList<Candidate> search(String name, int type) {
        ArrayList<Candidate> res = new ArrayList<>();
        for (Candidate candidate : candidates) {
            if (candidate.getFullName().contains(name) && candidate.getCandidateType() == type) {
                res.add(candidate);
            }
        }
        return res;
    }
}
