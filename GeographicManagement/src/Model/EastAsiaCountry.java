/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class EastAsiaCountry extends Country {

    private String countryTerrian;

    public EastAsiaCountry() {
    }

    public EastAsiaCountry(String countryCode, String countryName, float totalArea, String countryTerrian) {
        super(countryCode, countryName, totalArea);
        this.countryTerrian = countryTerrian;
    }

    public String getCountryTerrian() {
        return countryTerrian;
    }

    public void setCountryTerrian(String countryTerrian) {
        this.countryTerrian = countryTerrian;
    }

    @Override
    public String toString() {
        System.out.printf("%-10s %-10s %-10.1f %-10s", super.countryCode,super.countryName,super.totalArea, countryTerrian);
        return "";
    }

}
