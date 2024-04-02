package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputData {
    private String number, email, date;

    public String getNumber() {
        return number;
    }

    public String setNumber(String number) {
        if (number.length() > 10)
            return "Digits must less than 10";
        else if (!number.matches("[0-9]+"))
            return "Number must contain only digits";
        this.number = number;
        return "";
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            return "Wrong email format";
        this.email = email;
        return "";
    }

    public String getDate() {
        return date;
    }

    public String setDate(String date) {
        try {
            System.out.println("Input dob: " + date);
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            return "Wrong date format";
        }
        this.date = date;
        return "";
    }

    @Override
    public String toString() {
        return "InputData [number=" + number + ", email=" + email + ", date=" + date + "]";
    }

}
