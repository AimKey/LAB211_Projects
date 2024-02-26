package Model;

/**
 *
 * @author phamm
 */
public class Candidate  {
    protected String id;
    protected Info info;
    protected Contact contact;
    protected int candidateType;

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }
    
    public Candidate(String id, Info info, Contact contact, int candidateType) {
        this.id = id;
        this.info = info;
        this.contact = contact;
        this.candidateType = candidateType;
    }
    public Candidate(Info info, Contact contact, int candidateType) {
        this.id = null;
        this.info = info;
        this.contact = contact;
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        String res = info.fName + " " + info.lName + " | " + info.bDay + " | " + contact.address + " | " + contact.phone + " | " + contact.email + " | " + candidateType;
        return res;
    }

    public String getFullName() {
        return info.fName + " " + info.lName;
    }
    
}
