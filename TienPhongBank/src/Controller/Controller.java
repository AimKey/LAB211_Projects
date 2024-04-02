package Controller;

import Model.Account;
import View.ProgramView;
import java.util.Random;

public class Controller {

    private ProgramView view;

    public Controller(ProgramView view) {
        this.view = view;
    }

    public boolean login(String accNum, String pass) {
        return true;
    }

    public boolean checkAcc(String acc) {
        return new Account().setAccNum(acc);
    }

    public boolean checkPass(String pass) {
        return new Account().setAccPass(pass);
    }

    public String getCapcha(int size) {
        StringBuilder capcha = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            char c;
            if (rand.nextInt(2) == 0) {
                c = (char) (rand.nextInt(57 - 48 + 1) + 48);
            } else {
                c = (char) (rand.nextInt(90 - 65 + 1) + 65);
            }
            capcha.append(c);
        }
        return capcha.toString();
    }

    public boolean checkCapcha(String capcha, String input) {
        return capcha.equals(input);
    }

}
