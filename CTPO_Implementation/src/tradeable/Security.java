/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tradeable;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author stuart
 */
public class Security {

    //Historical data
    private ArrayList<Double> priceHistory;
    //Security values
    private double price;
    //Security metrics 
    private double risk;
    private double roi;
    private double alpha;

    Security() {
    }

    //Getters and setters
    public double getRisk() {
        return risk;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public ArrayList<Double> getPriceHistory() {
        return priceHistory;
    }

    public void setPriceHistory(ArrayList<Double> priceHistory) {
        this.priceHistory = priceHistory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
