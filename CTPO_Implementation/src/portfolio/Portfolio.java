/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package portfolio;

import java.util.ArrayList;
import tradeable.Investment;
import tradeable.Security;

/**
 *
 * @author stuart
 */
public abstract class Portfolio {

    private ArrayList<Investment> investments;
    private String name;
    private double risk, roi;
    private double cashBalance;
    private double profit;

    //Constructers
    public Portfolio(String name) {
        risk = Double.MAX_VALUE;
        roi = Double.MIN_VALUE;
    }

    public Portfolio(String name, String fileName) {
    }

    //Abstract override methods
    abstract double calculateRisk();

    abstract double calculateROI();

    abstract double calculateAlpha();

    //Portfolio import and export
    public void printPortfolio() {
        System.out.println("Investments: ");
        for (int i = 0; i < investments.size(); i++) {
        }
    }

    public void exportPortfolio() {
    }

    public void importPortfolio() {
    }

    //Portfolio operations
    public void add(Security security) {
    }

    public void sell(Investment investment, double qty) {
        try {
            for (int i = 0; i < investments.size(); i++) {
                //Loop through portfolio find and 'sell' security

                if (investments.get(i).equals(investment)) {
                    //Get the details of the investment being sold off
                    double buyPrice = investments.get(i).getPrice();
                    double sellPrice = investment.getPrice();
                    double quantity = investment.getQuantity();

                    if (quantity >= qty) {
                    } else {
                        System.out.println("You can't sell more of " + investment.getName() + " than you have");
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Exception caught in Portfolio.sell function" + exception);
        }
    }

    public void sellOff(Investment investment) {
        try {
            for (int i = 0; i < investments.size(); i++) {
                //Loop through portfolio find and 'sell' security

                if (investments.get(i).equals(investment)) {
                    //Get the details of the investment being sold off
                    double buyPrice = investments.get(i).getPrice();
                    double sellPrice = investment.getPrice();
                    double quantity = investment.getQuantity();

                    //Calculate the revenues vs. profits of the sale
                    double i_revenue = sellPrice * quantity;
                    double i_profit = (sellPrice - buyPrice) * quantity;

                    //Update the profit and cash balance of the portfolio
                    cashBalance += i_revenue;
                    profit += i_profit;

                    //Remove the investment from the portfolio
                    investments.remove(i);
                    break;
                }
            }
        } catch (Exception exception) {
            System.out.println("Exception caught in Portfolio.sellOff function" + exception);
        }
    }

    //Portfolio getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRisk() {
        if (risk != Double.MAX_VALUE) {
            return risk;
        } else {
            calculateRisk();
            return risk;
        }
    }

    public double getRoi() {
        if (roi != Double.MIN_VALUE) {
            return roi;
        } else {
            calculateRisk();
            return roi;
        }
    }

    public ArrayList<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(ArrayList<Investment> investments) {
        this.investments = investments;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public double getProfit() {
        return profit;
    }
}
