package Lib;

import java.util.Scanner;

public class Lib {

    public int getInt(String td, int min, int max) {
        Scanner sc = new Scanner(System.in);
        System.out.println(td + ": ");
        int result = -1;
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Number not valid!");
            }
        }

    }
}
