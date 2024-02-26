
package Model;

import java.util.ArrayList;

public class Words extends ArrayList<Word> {
    public void add(String s) {
        this.add(new Word(s));
    }
    public void add(String s, int count) {
        this.add(new Word(s, count));
    }
    
    public void addAllStrings (String[] s) {
        for (String string : s) {
            this.add(string);
        }
    }

    public void display() {
        for (Word thi : this) {
            System.out.println(thi);
        }
        System.out.println("");
    }
    
    public boolean isExist(Word index) {
        for (Word word : this) {
            if (word.getWord().equals(index.getWord())) {
                return true;
            }
        }
        return false;
    }
}
