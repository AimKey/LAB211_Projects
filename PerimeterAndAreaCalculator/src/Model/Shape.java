package Model;

public abstract class Shape {
    protected double perimeter, area;

    public abstract double getPerimeter();

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public abstract double getArea();

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public abstract String toString();

}
