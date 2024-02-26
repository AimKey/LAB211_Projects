package Model;

/**
 *
 * @author phamm
 */
public class Experience extends Candidate {
    private int ExpInYear;
    private String ProSkill;

    public Experience(String id, int ExpInYear, String ProSkill, Info info, Contact contact, int candidateType){
        super(id, info, contact, candidateType);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }
    
    public Experience(int ExpInYear, String ProSkill, Info info, Contact contact, int candidateType) {
        super(null, info, contact, candidateType);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }
    
}
