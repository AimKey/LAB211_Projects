package Controller;

import java.util.ArrayList;

import Model.Circle;
import Model.Rectangle;
import Model.Shape;
import Model.Triangle;
import View.CalculatorView;

public class Controller {
    private CalculatorView view;

    public Controller(CalculatorView view) {
        this.view = view;
    }

    public boolean calShapes(Rectangle rectangle, Circle circle, Triangle triangle) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(triangle);
        shapes.add(circle);
        shapes.add(rectangle);
        for (Shape shape : shapes) {
            shape.setPerimeter(shape.getPerimeter());
            shape.setArea(shape.getArea());
        }
        view.displayResult(rectangle, circle, triangle);
        return true;
    }

}
