package Model;

public class Account {

    private String accNum, accPass;

    public Account() {

    }

    public Account(String accNum, String accPass) {
        this.accNum = accNum;
        this.accPass = accPass;
    }

    public String getAccNum() {
        return accNum;
    }

    public boolean setAccNum(String accNum) {
        if (accNum.matches("^\\d{10}$")) {
            this.accNum = accNum;
            return true;
        }
        else return false;
    }

    public String getAccPass() {
        return accPass;
    }

    public boolean setAccPass(String accPass) {
        if (accPass.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$") && accPass.length() >= 8 && accPass.length() <= 31) {
            this.accPass = accPass;
            return true;
        }
        else return false;
    }
}
