package Common;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public String getString(String td) {
        Scanner sc = new Scanner(System.in);
        System.out.print(td + ": ");
        return sc.nextLine();
    }

    public String getString(String td, String errorMsg) {
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

    public Double getDouble(String td, String errorMsg) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        while (true) {
            try {
                String s = getString(td);
                if (s.length() == 0) {
                    return (double) -1;
                }
                result = Double.parseDouble(s);
                break;
            } catch (Exception e) {
                System.out.println("\u001B[31m" + errorMsg + "\u001B[0m");
            }
        }
        return result;
    }

    public void printErr(String msg) {
        System.out.println("\u001B[31m" + msg + "\u001B[0m");
    }

    public void printSuc(String msg) {
        System.out.println("\u001B[32m" + msg + "\u001B[0m");
    }
}