package Model;

public class Rectangle extends Shape {
    private double width, length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return ((width + length) * 2);
    }

    @Override
    public double getArea() {
        return (width * length);
    }

    @Override
    public String toString() {
        String t = String.format("====================Rectangle====================\n");
        String r = String.format("Width: %.2f\nLength: %.2f\n", width, length);
        String s = String.format("Area: %.2f\nPerimeter: %.2f", area, perimeter);
        return t + r + s;
    }

}
