package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phamm
 */
public class Equation {

    protected Double a, b, c = null;
    protected Double x1, x2 = null;

    public Equation(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Equation(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public List<Double> getEvenNumbers() {
//        TODO: Check for X1 and X2
        List<Double> res = new ArrayList<>();
        if (a % 2 == 0) {
            res.add(a);
        }
        if (b % 2 == 0) {
            res.add(b);
        }
        if (c != null) {
            if (c % 2 == 0) {
                res.add(c);
            }
        }
        if (x1 != null) {
            if (x1 % 2 == 0) {
                res.add(x1);
            }
        }
        if (x2 != null) {
            if (x2 % 2 == 0) {
                res.add(x2);
            }
        }

        return res;
    }

    public List<Double> getOddNumbers() {
        //        TODO: Check for X1 and X2

        List<Double> res = new ArrayList<>();
        if (a % 2 != 0) {
            res.add(a);
        }
        if (b % 2 != 0) {
            res.add(b);
        }
        if (c != null) {
            if (c % 2 != 0) {
                res.add(c);
            }
        }
        if (x1 != null) {
            if (x1 % 2 != 0) {
                res.add(x1);
            }
        }
        if (x2 != null) {
            if (x2 % 2 != 0) {
                res.add(x2);
            }
        }
        return res;
    }

    public List<Double> getPerfectSquare() {
        //        TODO: Check for X1 and X2
        List<Double> res = new ArrayList<>();
        if (isPerfectSquare(a)) {
            res.add(a);
        }
        if (isPerfectSquare(b)) {
            res.add(b);
        }
        if (c != null) {
            if (isPerfectSquare(c)) {
                res.add(c);
            }
        }
        if (x1 != null) {
            if (isPerfectSquare(x1)) {
                res.add(x1);
            }
        }
        if (x2 != null) {
            if (isPerfectSquare(x2)) {
                res.add(x2);
            }
        }
        return res;
    }

    private boolean isPerfectSquare(Double num) {
        Double temp = Math.sqrt(num);
        return temp * temp == num;
    }

}
