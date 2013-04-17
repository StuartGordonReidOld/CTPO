/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import java.util.ArrayList;
import securities.Currency;

/**
 *
 * @author stuart
 */
public class Portfolio {
    
    String name;
    Currency fundingCurrency;
    ArrayList<Currency> investmentCurrencies;
    
    int risk, roi;
    
    public Portfolio(String name) {
        
    }
}
