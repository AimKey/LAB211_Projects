package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phamm
 */
public class QuadraticEquation extends Equation {

    private double delta;

    public QuadraticEquation(Double a, Double b, Double c) {
        super(a, b, c);
        delta = b * b - 4 * a * c;
    }

    public List<Double> getSolutions() {
        List<Double> res = new ArrayList<>();
        if (a == 0) {
            if (b != 0) {
                res.add(-c / b);
                x1 = -c/b;
            }
            return res;
        }
        if (delta > 0) {
            x1 = ((-b + Math.sqrt(delta)) / (2 * a));
            x2 = ((-b - Math.sqrt(delta)) / (2 * a));
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            x2 = x1;
        } else {
            return null;
        }
        res.add(x1);
        res.add(x2);
        return res;
    }
}
