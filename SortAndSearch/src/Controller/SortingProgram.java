package Controller;

import Common.Algorithm;
import Common.Library;
import Model.Element;
import View.Menu;
import java.util.Arrays;
import java.util.Scanner;

public class SortingProgram extends Menu<String> {

    protected Algorithm algorithm;
    protected Library library;
    protected int[] array;
    protected int arrSize;
    protected boolean sorted = false;

    public SortingProgram(Element e) {
        super(new String[]{"Sort array", "Search element", "Exit"}, "Sorting Program");
        algorithm = new Algorithm();
        library = new Library();
        array = e.getArray();
        arrSize = e.getArraySize();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                System.out.println("Current array: " + Arrays.toString(array));
                doSort();
                break;
            }
            case 2: {
                System.out.println("Current array: " + Arrays.toString(array));
                doSearch();
                break;
            }
            case 3: {
                System.out.println("Exiting...");
                System.exit(0);
            }
        }
    }

    public void doSort() {
        Menu menu = new Menu(new String[]{"Bubble sort", "Quick sort"}, "Sorting Menu") {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1: {
                        algorithm.bubbleSort(array);
                        System.out.println("After sort: " + Arrays.toString(array));
                        Scanner sc = new Scanner(System.in);
                        sc.nextInt();
                        break;
                    }
                    case 2: {
                        algorithm.quickSort(array, 0, arrSize - 1);
                        System.out.println("After sort: " + Arrays.toString(array));
                        Scanner sc = new Scanner(System.in);
                        sc.nextInt();
                        break;
                    }
                }
                sorted = true;
            }
        };
        menu.run();
    }

    public void doSearch() {
        Menu menu = new Menu(new String[]{"Linear search", "Binary search"}, "Searching Menu") {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1: {
                        System.out.println("Current array: " + Arrays.toString(array));
                        int result = algorithm.linearSearch(array, library.getInt("Enter number to find"));
                        if (result >= 0) {
                            System.out.println("Your number is at position: " + result);
                        } else {
                            System.out.println("Not found!");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Current array: " + Arrays.toString(array));
                        if (sorted == true) {
                            int result = algorithm.binarySearch(array, library.getInt("Enter number to find"));
                            if (result >= 0) {
                                System.out.println("Your number is at position: " + result);
                            } else {
                                System.out.println("Not found!");
                            }
                        } else {
                            System.out.println("Array is not sorted");
                        }
                        break;
                    }
                }
            }
        };
        menu.run();
    }
}
