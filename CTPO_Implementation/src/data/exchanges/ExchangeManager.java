/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.exchanges;

import data.exchanges.Forex.ForexExchange;
import java.util.ArrayList;
import data.exchanges.WorldBank.*;
import portfolio.Portfolio;

/**
 *
 * @author stuart
 */
public class ExchangeManager {

    ArrayList<Exchange> exchanges;

    public ExchangeManager() {
        exchanges = new ArrayList();
    }

    public void addNewExchange(String name, String type, Portfolio portfolio) {
        if (type.equals("WorldBank")) {
            exchanges.add(new WorldBankExchange(name, portfolio));
        } else if (type.equals("Forex")) {
            exchanges.add(new ForexExchange(name, portfolio));
        } else {
            System.out.println("Error: Invalid exchange type");
        }
    }
}
