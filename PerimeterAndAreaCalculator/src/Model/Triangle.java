package Model;

public class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        Double p = perimeter / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }

    @Override
    public String toString() {
        String t = String.format("====================Triangle====================\n");
        String r = String.format("Side A: %.2f\nSide B: %.2f\nSide C: %.2f\n", a, b, c);
        String s = String.format("Area: %.2f\nPerimeter: %.2f", area, perimeter);
        return t + r + s;
    }

}
