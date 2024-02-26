/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import Model.EastAsiaCountry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author Admin
 */
public class Library {
    private  Scanner sc = new Scanner(System.in);
    
    public String inputCode(ArrayList<EastAsiaCountry> countryList) {
        boolean isExist;
        while (true) {
            isExist = false;
            String code = sc.nextLine();
            for (EastAsiaCountry ct : countryList) {
                if (ct.getCountryCode().equals(code)) {
                    System.out.println("Id is existed");
                    System.out.println("Enter again:");
                    isExist = true;
                }
            }
            if (isExist == false) {
                return code;
            }
        }
    }
    public String inputName() {
        String name;
        while (true) {
            try {
                name = sc.nextLine();
                if (!name.matches("[a-zA-Z .]+")) {
                    throw new IllegalArgumentException("Invalid name. Please enter a valid name.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
        return name;
    }
    public String inputTerrian(){
        String st;
        while(true){
            try{
                st=sc.nextLine();
                if (!st.matches("[a-zA-Z .]+")){
                    throw new IllegalArgumentException("Invalid terrian. Please enter string!");
                }
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return st;
    }
    
    public float inputTotal() {
        int total;
        while (true){
            try{
                total = sc.nextInt();
                sc.nextLine();
                if (total<=0){
                    throw new IllegalArgumentException("Invalid phone number. Please enter a valid phone number.");
                }
                break;
            } catch(IllegalArgumentException e) {
                System.err.print(e.getMessage());
            }
        }
        return total;
    }
    
    
}
