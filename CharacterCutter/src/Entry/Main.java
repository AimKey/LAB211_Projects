
package Entry;

import Common.Library;
import Controller.CharacterCutterProgram;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        new CharacterCutterProgram(lib.getString("Enter your string")).run();
    }
}
