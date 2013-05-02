/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package C1_portfolio;

import java.util.ArrayList;
import C2_portfolio.instruments.Currency;
import C2_portfolio.instruments.Security;

/**
 *
 * @author stuart
 */
public class CarryTradePortfolio extends Portfolio {

    Currency fundingCurrency;
    ArrayList<Currency> investmentCurrencies;

    public CarryTradePortfolio(String name) {
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
