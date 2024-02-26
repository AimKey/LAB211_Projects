package View;

import java.util.ArrayList;

/**
 * Will display like this:
 *  Title
    -----------------------------
    1. Option 1
    2. Option 2
    -----------------------------
 * @author phamm
 */
public class DisplayMenu extends Menu {

    public DisplayMenu(ArrayList mc, String td) {
        super(mc, td);
    }
    
    public DisplayMenu(Object[] mc, String td) {
        super(mc, td);
    }

    @Override
    public void execute(int n) {
        display();
    }
    
    
}
