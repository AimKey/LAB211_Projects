package Common;

import java.util.Scanner;
import java.util.function.Predicate;

public class Library {

    public String getString(String td) {
        Scanner sc = new Scanner(System.in);
        System.out.print(td + ": ");
        return sc.nextLine();
    }

    public String getString(String td, String errorMsg, Predicate<String> predicate) {
        Scanner sc = new Scanner(System.in);
        System.out.print(td + ": ");
        String s = sc.nextLine();
        if (s.length() == 0) {
            return "";
        }
        while (!s.matches("[A-Za-z ]+")) {
            System.out.println("\u001B[31m" + errorMsg + "\u001B[0m");
            s = getString(td);
        }
        return s;
    }

    public void printErr(String msg) {
        System.out.println("\u001B[31m" + msg + "\u001B[0m");
    }
}
