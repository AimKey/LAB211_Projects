
import View.DisplayMenu;


/**
 *
 * @author phamm
 */
public class Main {
    public static void main(String[] args) {
        DisplayMenu m = new DisplayMenu(new String[]{"Option 1", "Option 2"}, "Title");
        m.display();
    }
}
