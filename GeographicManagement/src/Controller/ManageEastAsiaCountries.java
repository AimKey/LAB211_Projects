/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Common.Library;
import Model.Countries;
import Model.EastAsiaCountry;
import View.Menu;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class ManageEastAsiaCountries extends Menu {

    private Countries countryList;
    Library lib = new Library();

    public ManageEastAsiaCountries() {
        super(new String[]{"Enter the information for 11 countries in Southeast Asia.", "Display already information.", "Search the country according to the entered country's name.", "Display the information increasing with the country name.",
            "Exit."}, "Manage EastAsia Countries");
        countryList = new Countries();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addCountries();
                break;
            case 2:
                displayRecentlyCountry();
                break;
            case 3:
                searchByName();
                break;
            case 4:
                sortByName();
                break;
            case 5:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public void addCountries() {
        int count = 0;
        //        Change back to 11
        while (countryList.size() < 11) {
            System.out.println("Enter code of country:");
            String code = lib.inputCode(countryList);
            System.out.println("Enter name of country:");
            String name = lib.inputName();
            System.out.println("Enter total Area:");
            float area = lib.inputTotal();
            System.out.println("Enter terrain of country:");
            String terrain = lib.inputTerrian();
            EastAsiaCountry eac = new EastAsiaCountry(code, name, area, terrain);
            countryList.add(eac);
            ++count;
            System.out.println(count + " countries is created!");
        }
        System.out.println("11 countries is created!");
        displayCountry(countryList);
    }

    public void displayRecentlyCountry() {
        displayCountry(countryList.getRecentlyEnteredInformation());
    }

    public void searchByName() {
        System.out.println("Enter name you want to find:");
        String name = lib.inputName();
        displayCountry(countryList.search((p -> p.getCountryName().contains(name))));
    }

    public void displayCountry(ArrayList<EastAsiaCountry> countryList) {
        System.out.println("-----------------------------");
        for (EastAsiaCountry countries : countryList) {
            System.out.println(countries);
        }
        System.out.println("-----------------------------");
    }

    public void sortByName() {
        Collections.sort(countryList, (EastAsiaCountry st1, EastAsiaCountry st2) -> st1.getCountryName().compareTo(st2.getCountryName()));
        displayCountry(countryList);
    }
}
