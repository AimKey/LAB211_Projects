
package View;

import Common.Library;
import Common.Validate;
import Controller.Controller;
import Model.Circle;
import Model.Rectangle;
import Model.Triangle;

public class CalculatorView extends Menu<String> {

    private Controller controller;
    private Library library;
    private Validate validate;

    public CalculatorView() {
        super(new String[] { "Enter program", "Exit" }, "Calculator Shape Program");
        library = new Library();
        validate = new Validate();
        controller = new Controller(this);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                calShapesView();
                break;
            case 2:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void calShapesView() {
        boolean status = false;
        try {
            double width = library.getDouble("Please input side width of Rectangle", "Number only");
            double height = library.getDouble("Please input side height of Rectangle", "Number only");
            double radius = library.getDouble("Please input side radius of Circle", "Number only");
            double sideA = library.getDouble("Please input side A of Triangle", "Number only");
            double sideB = library.getDouble("Please input side B of Triangle", "Number only");
            double sideC = library.getDouble("Please input side side C of Triangle", "Number only");
            validate.validate("Shapes should not have length <= 0",
                    new Double[] { width, height, radius, sideA, sideB, sideC }, p -> p > 0);
            status = controller.calShapes(new Rectangle(width, height), new Circle(radius),
                    new Triangle(sideA, sideB, sideC));
        } catch (Exception e) {
            library.printErr(e.getMessage());
            status = false;
        }
        if (status)
            library.printSuc("Success!");
        else
            library.printErr("Failed...");
    }

    public void displayResult(Rectangle rectangle, Circle circle, Triangle triangle) {
        System.out.println(rectangle);
        System.out.println(circle);
        System.out.println(triangle);
    }

}