package Common;

public class Validator {
    private String phoneRegex = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";

    // TODO: FIx this
    public boolean validatePhone(String num) {
        return num.matches(phoneRegex);
    }
}
