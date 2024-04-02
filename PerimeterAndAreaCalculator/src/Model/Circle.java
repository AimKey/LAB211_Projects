package Model;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        String t = String.format("====================Circle====================\n");
        String r = String.format("Radius: %.2f\n", radius);
        String s = String.format("Area: %.2f\nPerimeter: %.2f", area, perimeter);
        return t + r + s;
    }

}
