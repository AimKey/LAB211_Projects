package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AnalysisString {
    private String inputs;
    private String[] numbers;
    private StringBuilder chars;

    public AnalysisString(String inputs) {
        this.inputs = inputs;
        extract();
    }

    // TODO: Test string 12jkl2JLKHjlk@#@*&^!d445jJWKLADJlka1349
    public void extract() {
        numbers = inputs.split("[ a-zA-Z\\*\\!\\@\\#\\$\\%\\^\\&\\(\\)\\,\\.\\/\\?\\;\\:]+");
        chars = new StringBuilder(String.join("", inputs.split("\\d+")));
        System.out.println(Arrays.toString(numbers));
        System.out.println(chars);
    }

    public HashMap<String, ArrayList<Integer>> getNumber() {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> square = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> normal = new ArrayList<>();
        for (String sNum : numbers) {
            int num = Integer.valueOf(sNum);
            if (num % 2 == 0)
                even.add(num);
            if (num % 2 != 0)
                odd.add(num);
            if (isPerfectSquare(num))
                square.add(num);
            normal.add(num);
        }
        HashMap<String, ArrayList<Integer>> r = new HashMap<>();
        r.put("Even numbers: ", even);
        r.put("Odd numbers: ", odd);
        r.put("Square numbers: ", square);
        r.put("All numbers: ", normal);
        return r;
    }

    public boolean isPerfectSquare(int num) {
        int square = (int) (Math.sqrt(num));
        return square * square == num;
    }

    public HashMap<String, ArrayList<Character>> getCharacter() {
        ArrayList<Character> upper = new ArrayList<>();
        ArrayList<Character> lower = new ArrayList<>();
        ArrayList<Character> special = new ArrayList<>();
        ArrayList<Character> all = new ArrayList<>();
        for (int i = 0; i < chars.length(); i++) {
            Character c = chars.charAt(i);
            if (65 <= c && c <= 90)
                upper.add(c);
            else if (97 <= c && c <= 122)
                lower.add(c);
            else
                special.add(c);
            all.add(c);
        }
        HashMap<String, ArrayList<Character>> r = new HashMap<>();
        r.put("Upper case: ", upper);
        r.put("Lower case: ", lower);
        r.put("Special chars: ", special);
        r.put("All chars: ", all);
        return r;
    }
}
