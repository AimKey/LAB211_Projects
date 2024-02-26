
package Common;

import java.util.Random;
import java.util.Scanner;

public class Library {

    public int getInt(String td) {
        Scanner sc = new Scanner(System.in);
        System.out.print(td + ": ");
        return Integer.parseInt(sc.nextLine());
    }

    public int[] createRandomArray(int arrSize) {
        int[] temp = new int[arrSize];
        Random rd = new Random();
        for (int i = 0; i < arrSize; i++) {
            temp[i] = rd.nextInt(100);
        }
        return temp;
    }
}
