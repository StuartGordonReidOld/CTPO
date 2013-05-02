/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package E_tests;

import C1_portfolio.Portfolio;
import C1_portfolio.CarryTradePortfolio;
import C2_portfolio.instruments.Trade;
import C2_portfolio.instruments.Currency;
import java.util.ArrayList;

/**
 *
 * @author stuart
 */
public class PortfolioTesting {

    public static void main(String args[]) {
        PortfolioTesting test = new PortfolioTesting();
        test.createPortfolio();
    }

    public Portfolio createPortfolio() {

        CarryTradePortfolio carryTradePortfolio;
        carryTradePortfolio = new CarryTradePortfolio("Testing Portfolio");
        carryTradePortfolio.creditCashBalance(100);
        carryTradePortfolio.printPortfolio();

        Currency rand;
        rand = new Currency("SA Rand");
        rand.setPrice(10);

        Trade buyRands = new Trade(rand, 5, "Buy Rands");
        carryTradePortfolio.buy(buyRands);
        carryTradePortfolio.printPortfolio();
        
        carryTradePortfolio.sell(buyRands, 3);
        carryTradePortfolio.printPortfolio();

        return null;
    }
}
