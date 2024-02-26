package View;

import java.util.List;

/**
 *
 * @author phamm
 */
public class Display {

    public void displayList(List<Double> list, String title) {
        System.out.print(title + ": ");
        if (list.isEmpty()) System.out.print("None");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%.1f", list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
//
    public void displaySolution(List<Double> list) {
        try {
            if (list.isEmpty()) {
                System.out.println("Infinite solution");
            } else {
                System.out.print("Solution(s): ");
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) == null) {
                        continue;
                    }
                    System.out.print("x" + (i+1)+ ": " + list.get(i) + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("No solution");
        }
    }
}
