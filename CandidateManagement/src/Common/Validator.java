package Common;

public class Validator {

    public boolean checkCommon(int bDay, String phone, String email) {
        if (bDay < 1900 || String.valueOf(bDay).length() > 4) {
            System.out.println("Invalid birth year");
            return false;
        }
        if (phone.length() < 10 && phone.matches("[a-zA-Z]+")) {
            System.out.println("Phone number invalid!");
            return false;
        }
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            System.out.println("Invalid email!");
            return false;
        }
        return true;
    }
    
    public boolean checkExpYear(int yearOfExp) {
        if (yearOfExp < 0 || yearOfExp > 100) {
            System.out.println("Invalid year of experience");
            return false;
        }
        return true;
    }
    
    public boolean checkGraduationRank(String rank) {
        String ref = rank.toLowerCase();
        return "excellence".equals(ref) || "good".equals(ref) || "fair".equals(ref) || "poor".equals(ref);
    }

}
