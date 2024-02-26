package Controller;

import Common.Library;
import Model.Dictionary;
import View.DictionaryView;

public class Controller {

    // Change these name into whatever you like
    private DictionaryView view;
    private Library library;

    public Controller() {
        library = new Library();
        view = new DictionaryView(new String[] { "Add word", "Delete Word", "Translate Word", "Exit" },
                "Dictionary Manager", this);
        view.run();
    }

    public boolean addWord(String eng, String vn, Dictionary dictionary) {
        if (dictionary.containsKey(eng)) {
            System.out.println(eng + " has already exist, do you want to update it? (y/n)");
            if (library.getString("Your choice").toLowerCase().equals("y")) {
                dictionary.remove(eng);
                dictionary.put(eng, vn);
                return true;
            } else {
                return false;
            }
        } else
            dictionary.put(eng, vn);
        return true;
    }

    public String deleteWord(String word, Dictionary dictionary) {
        return dictionary.remove(word);
    }

    public String translateWord(String search, Dictionary dictionary) {
        return dictionary.get(search);
    }

}
