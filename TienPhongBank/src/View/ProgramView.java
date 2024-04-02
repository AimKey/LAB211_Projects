package View;

import Common.Library;
import Controller.Controller;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Change this to your program name
 */
public class ProgramView extends Menu<String> {

    private Controller controller;
    private Library library;

    // TODO: Change functions names, title, and choices
    public ProgramView() {
        super(new String[]{"Vietnamese", "English", "Exit"}, "Tien Phong Bank login");
        library = new Library();
        controller = new Controller(this);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                displayVietnamese();
                break;
            case 2:
                displayEnglish();
                break;
            case 3:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void displayVietnamese() {
        displayView("vi");
    }

    public void displayEnglish() {
        displayView("en");
    }

    public void displayView(String baseName) {
        boolean status = false;
        Locale locale = new Locale(baseName);
        ResourceBundle msgs = ResourceBundle.getBundle(baseName, locale);
        try {
            String accNum, pass;
            boolean check;
//            Account
            do {
                accNum = library.getString(msgs.getString("stk"));
                check = controller.checkAcc(accNum);
                if (!check) {
                    library.printErr(msgs.getString("err_stk"));
                }
            } while (!check);
//            Pass
            do {
                pass = library.getString(msgs.getString("pass"));
                check = controller.checkPass(pass);
                if (!check) {
                    library.printErr(msgs.getString("err_pass"));
                }
            } while (!check);
//            Captcha
            do {
                String capcha = controller.getCapcha(5);
                String input = library.getString(msgs.getString("enter_captcha") + " " + capcha);
                check = controller.checkCapcha(capcha, input);
                if (!check) {
                    library.printErr(msgs.getString("err_captcha"));
                }
            } while (!check);

            status = controller.login(accNum, pass);
        } catch (Exception e) {
            library.printErr(e.getMessage());
        }
        if (status) {
            library.printSuc("Success!");
        } else {
            library.printErr("Failed...");
        }
    }

}
