package View;

import java.util.ArrayList;

/**
 *
 * @author phamm
 */
public class DisplayMenu extends Menu {
    public DisplayMenu(ArrayList mc, String td) {
        super(mc, td);
    }

    @Override
    public void execute(int n) {
    }
    @Override
    public void display(){
        System.out.println(title);
        System.out.println("-----------------------------");
        for(int i=0; i<mChon.size();i++) 
            System.out.println((i+1)+". "+mChon.get(i));
        System.out.println("-----------------------------");
    }
}
