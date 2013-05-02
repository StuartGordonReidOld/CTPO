/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B2_data.exchanges;

import java.util.ArrayList;
import C1_portfolio.Portfolio;

/**
 *
 * @author stuart
 */
public class DataExchangeManager {

    ArrayList<DataExchange> exchanges;

    public DataExchangeManager() {
        exchanges = new ArrayList();
    }

    public void addNewExchange(String name, String type, Portfolio portfolio) {
        if (type.equals("WorldBank")) {
            exchanges.add(new WorldBankDataExchange(name, portfolio));
        } else if (type.equals("Forex")) {
            exchanges.add(new ForexDataExchange(name, portfolio));
        } else {
            System.out.println("Error: Invalid exchange type");
        }
    }
}
