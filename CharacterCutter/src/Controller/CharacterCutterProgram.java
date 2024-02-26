package Controller;

import Common.Algorithm;
import Common.Library;
import Model.Words;
import View.Menu;

public class CharacterCutterProgram extends Menu {

    private Words words;
    private Library lb;
    private Algorithm algo;
    private String str;

    public CharacterCutterProgram(String s) {
        super(new String[]{"Count words", "Count characters", "Exit"}, "Character cutter");
        lb = new Library();
        algo = new Algorithm();
        str = s;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                doCut();
                break;
            }
            case 2: {
                doCount();
                break;
            }
            case 3: {
                System.out.println("See you next time!");
                System.exit(0);
            }
        }
    }

    public void doCut() {
        words = new Words();
        String[] test = algo.getWordsInString(str);
        words.addAllStrings(test);
        Words result = algo.countWordsPlus(words);
        System.out.println("Result: " + result);
    }

    public void doCount() {
        words = new Words();
        String[] test = algo.getCharInString(str);
        words.addAllStrings(test);
        Words result = algo.countWordsPlus(words);
        System.out.println("Result: " + result);
    }
}
