package Controller;

import Common.Library;
import Model.NormalEquation;
import Model.QuadraticEquation;
import View.Display;
import View.Menu;

public class Controller extends Menu {

    Library lib = new Library();
    Display display = new Display();

    public Controller() {
        super(new String[]{"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"}, "Equation Program");
    }
//  TODO: If it is a normal equation, skip C which might be == 0

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                calcNormalEquation();
                break;
            case 2:
                calcQuadraticEquation();
                break;
            case 3:
                System.out.println("See you next time");
                System.exit(0);
        }
    }

    public void calcNormalEquation() {
        double a = lib.getDouble("Enter A", "Please enter number");
        double b = lib.getDouble("Enter B", "Please enter number");
        NormalEquation equa = new NormalEquation(a, b);
        display.displaySolution(equa.getSolutions());
        display.displayList(equa.getOddNumbers(), "Odd numbers");
        display.displayList(equa.getEvenNumbers(), "Even numbers");
        display.displayList(equa.getPerfectSquare(), "Perfect Square numbers");
    }

    public void calcQuadraticEquation() {
        double a = lib.getDouble("Enter A", "Please enter number");
        double b = lib.getDouble("Enter B", "Please enter number");
        double c = lib.getDouble("Enter B", "Please enter number");
        QuadraticEquation equa = new QuadraticEquation(a, b, c);
        display.displaySolution(equa.getSolutions());
        display.displayList(equa.getOddNumbers(), "Odd numbers");
        display.displayList(equa.getEvenNumbers(), "Even numbers");
        display.displayList(equa.getPerfectSquare(), "Perfect Square numbers");
    }

}
