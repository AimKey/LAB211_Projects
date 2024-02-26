package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author phamm
 */
public class Internship extends Candidate {

    protected LocalDate graduateTime;
    protected String graduationRank;
    protected String education;

    public Internship(String id, String graduateTime, String graduationRank, String education, Info info, Contact contact, int candidateType) {
        super(id, info, contact, candidateType);
        this.graduateTime = LocalDate.parse(graduateTime, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Internship(String graduateTime, String graduationRank, String education, Info info, Contact contact, int candidateType) {
        super(info, contact, candidateType);
        this.graduateTime = LocalDate.parse(graduateTime, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduateTime() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(graduateTime);
    }
}
