
package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Common.Library;
import Controller.Controller;
import Model.AnalysisString;

/**
 * Change this to your program name
 */
public class ProgramView extends Menu<String> {

    private Controller controller;
    private Library library;

    public ProgramView() {
        super(new String[] { "Enter string", "Exit" }, "Analyze User Input String");
        library = new Library();
        controller = new Controller(this);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                getInputView();
                break;
            case 2:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void getInputView() {
        try {
            String userInputs = library.getString("Enter your inputs");
            AnalysisString analysisString = new AnalysisString(userInputs);
            displayResult(analysisString);
        } catch (Exception e) {
            library.printErr(e.getMessage());
        }
    }

    public void displayResult(AnalysisString analysisString) {
        System.out.println("------------------Numbers-----------------");
        HashMap<String, ArrayList<Integer>> numbers = analysisString.getNumber();
        for (Map.Entry<String, ArrayList<Integer>> set : numbers.entrySet()) {
            System.out.printf("%-10s: %s\n", set.getKey(), set.getValue());
        }
        System.out.println("------------------Character-----------------");
        HashMap<String, ArrayList<Character>> chars = analysisString.getCharacter();
        for (Map.Entry<String, ArrayList<Character>> set : chars.entrySet()) {
            System.out.printf("%-10s: %s\n", set.getKey(), set.getValue());
        }
    }

}