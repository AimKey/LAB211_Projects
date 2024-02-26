package Model;

/**
 *
 * @author phamm
 */
public class Fresher extends Candidate {

    protected String major;
    protected int semester;
    protected String uniName;

    public Fresher(String id, String major, int semester, String uniName, Info info, Contact contact, int candidateType) {
        super(id, info, contact, candidateType);
        this.major = major;
        this.semester = semester;
        this.uniName = uniName;
    }

    public Fresher(String major, int semester, String uniName, Info info, Contact contact, int candidateType) {
        super(info, contact, candidateType);
        this.major = major;
        this.semester = semester;
        this.uniName = uniName;
    }

}
