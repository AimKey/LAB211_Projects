package Common;

import java.util.Scanner;

public class Library {
    // Only choose what you need to avoid redundancy

    public String getString(String td) {
        Scanner sc = new Scanner(System.in);
        System.out.print(td + ": ");
        return sc.nextLine();
    }

    public void printErr(String msg) {
        System.out.println("\u001B[31m" + msg + "\u001B[0m");
    }

    public void printSuc(String msg) {
        System.out.println("\u001B[32m" + msg + "\u001B[0m");
    }
}
