/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import java.util.ArrayList;
import tradeable.Currency;
import tradeable.Security;

/**
 *
 * @author stuart
 */
public class CTPortfolio extends Portfolio {

    Currency fundingCurrency;
    ArrayList<Currency> investmentCurrencies;

    CTPortfolio(String name) {
        super(name);
    }
    
    @Override
    double calculateRisk() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    double calculateROI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    double calculateAlpha() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
