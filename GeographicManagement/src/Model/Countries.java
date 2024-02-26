package Model;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Countries extends ArrayList<EastAsiaCountry> {

    public ArrayList<EastAsiaCountry> getRecentlyEnteredInformation() {
        return this;
    }

    public ArrayList<EastAsiaCountry> search(Predicate<EastAsiaCountry> p) {
        ArrayList<EastAsiaCountry> result = new ArrayList<>();
        for (EastAsiaCountry country : this) {
            if (p.test(country)) {
                result.add(country);
            }
        }
        return result;
    }
}
