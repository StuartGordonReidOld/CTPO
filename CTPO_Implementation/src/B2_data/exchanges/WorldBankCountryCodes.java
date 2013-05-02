/* The WorldBank uses country codes in it's argument based API to identify
 * for which countries the argument applies. This class aims to define a way to
 * get valid country codes and names for the World Bank
 */
package B2_data.exchanges;

import B1_data.FileInputOutput;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author stuart
 */
public class WorldBankCountryCodes {

    private ArrayList<CountryCode> countryCodes;
    FileInputOutput sharedFileIO;

    public static void main(String args[]) {
        try {
            WorldBankCountryCodes countryCode = new WorldBankCountryCodes();
            countryCode.initializeCountryCodeList();
            System.out.println(countryCode.getCountry("AFG"));
        } catch (IOException ex) {
            Logger.getLogger(WorldBankCountryCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* This is the constructor for the class. It created a shared FilIO object
     * for manipulating files and it initializes the country code list.
     */
    WorldBankCountryCodes() {
        try {
            sharedFileIO = new FileInputOutput();
            countryCodes = new ArrayList();
            initializeCountryCodeList();
        } catch (IOException ex) {
            Logger.getLogger(WorldBankCountryCodes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* This method initialized the country code list from the source data file
     * based on the ISO 31661 standard. 
     */
    private void initializeCountryCodeList() throws IOException {
        String fullFileName = sharedFileIO.currentDirectory() + "src/data/exchanges/#ISO31661.txt";
        BufferedReader bufferedFileReader = sharedFileIO.getBufferedReader(fullFileName);
        String str = bufferedFileReader.readLine();

        while (str != null) {
            String country = str.substring(4, str.length()).replaceAll("\t", "");
            String code = str.substring(0, 4).replaceAll("\t", "");

            CountryCode countryCode = new CountryCode(country, code);
            countryCodes.add(countryCode);
            str = bufferedFileReader.readLine();
        }
    }

    /* This function prints out a list of the countries with their codes, this 
     * is used for internal testing. 
     */
    private void printCountryCodeList() {
        for (int i = 0; i < countryCodes.size(); i++) {
            System.out.println("Country - " + countryCodes.get(i).getCountryName());
            System.out.println("Code - " + countryCodes.get(i).getCountryCode());
            System.out.println("---");
        }
    }

    /* This method takes a country as an argument and returns the country code
     * for that country. 
     */
    public String getCode(String country) {
        for (int i = 0; i < countryCodes.size(); i++) {
            if (countryCodes.get(i).getCountryName().equals(country)) {
                return countryCodes.get(i).getCountryCode();
            }
        }
        return "Country not found";
    }

    /* This method takes a country code as an argument and returns the name
     * of the country that belongs to that code. 
     */
    public String getCountry(String code) {
        for (int i = 0; i < countryCodes.size(); i++) {
            if (countryCodes.get(i).getCountryCode().equals(code)) {
                return countryCodes.get(i).getCountryName();
            }
        }
        return "Code not found";
    }
    
    /* This method returns a list of all the countries currently in the ISO3661
     * standard
     */
    public ArrayList<String> getCountries() {
        ArrayList<String> countries = new ArrayList();
        for(int i=0; i<countryCodes.size(); i++) {
            countries.add(countryCodes.get(i).getCountryName());
        }
        return countries;
    }
    
    /* This method returns a list of all the country codes currently in the 
     * ISO366 standard
     */
    public ArrayList<String> getCodes() {
        ArrayList<String> codes = new ArrayList();
        for(int i=0; i<countryCodes.size(); i++) {
            codes.add(countryCodes.get(i).getCountryCode());
        }
        return codes;
    }
}
/* This class is just a struct with some getters and settes for Country Codes
 */
class CountryCode {

    private String countryName;
    private String countryCode;

    CountryCode(String cN, String cC) {
        countryName = cN;
        countryCode = cC;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
