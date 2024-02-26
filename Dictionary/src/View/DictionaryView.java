
package View;

import Common.Library;
import Controller.Controller;
import Model.Dictionary;

/**
 * Change this to your program name
 */
public class DictionaryView extends Menu<String> {

    private Controller controller;
    private Library library;
    private Dictionary dictionary;
    private String fileName = "dictionary.txt";

    public DictionaryView(String[] mc, String td, Controller controller) {
        super(mc, td);
        library = new Library();
        this.controller = controller;
        dictionary = new Dictionary(fileName);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addView();
                break;
            case 2:
                deleteView();
                break;
            case 3:
                translateView();
                break;
            case 4:
                dictionary.doSave(fileName);
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void addView() {
        boolean status = false;
        try {
            String eng = library.getString("Enter english word", "Characters only");
            String vn = library.getString("Enter Viet Nam meaning", "Characters only");
            status = controller.addWord(eng, vn, dictionary);
        } catch (Exception e) {
            library.printErr(e.getMessage());
        }
        if (status)
            library.printSuc("Success!");
        else
            library.printErr("Word is not created/updated");
    }

    public void deleteView() {
        String s = library.getString("Enter english word to delete", "Character only");
        String status = controller.deleteWord(s, dictionary);
        if (status != null)
            library.printSuc("Success!");
        else
            library.printErr("No word found...");
    }

    public void translateView() {
        String searchWord = library.getString("Enter English word", "Character only");
        String resultWord = controller.translateWord(searchWord, dictionary);
        if (resultWord == null)
            library.printErr("No meaning found...");
        else
            System.out.println(searchWord + ": " + resultWord);
    }

}