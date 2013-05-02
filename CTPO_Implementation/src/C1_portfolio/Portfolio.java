/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package C1_portfolio;

import java.util.ArrayList;
import C2_portfolio.instruments.Trade;
import C2_portfolio.instruments.Security;

/**
 *
 * @author stuart
 */
public abstract class Portfolio {

    private ArrayList<Trade> investments;
    private String name;
    private double risk, roi;
    private double cashBalance;
    private double profit;

    //Constructers
    Portfolio(String n) {
        risk = Double.MAX_VALUE;
        roi = Double.MIN_VALUE;
        investments = new ArrayList();
        name = n;
    }

    public Portfolio(String name, String fileName) {
    }

    //Abstract override methods
    abstract double calculateRisk();

    abstract double calculateROI();

    abstract double calculateAlpha();

    //Portfolio import and export
    public void printPortfolio() {
        System.out.println("PRINTING " + name.toUpperCase() + ":");
        System.out.print("Investments: {");
        for (int i = 0; i < investments.size(); i++) {
            investments.get(i).print();
            if (i != investments.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}, Cash Balance: " + this.cashBalance + "\n");
    }

    public void exportPortfolio() {
    }

    public void importPortfolio() {
    }

    //Portfolio operations
    public void buy(Trade investment) {
        try {
            if (investment.getPrice() >= 0) {
                if (investment.getQuantity() >= 0) {
                    investments.add(investment);
                    cashBalance = cashBalance - (investment.getPrice() * investment.getQuantity());
                } else {
                    System.out.println("You can't make an investment with a negative quantity");
                }
            } else {
                System.out.println("You can't make an investment with a negative price");
            }
        } catch (Exception exception) {
        }
    }

    public void sell(Trade investment, double sellQuantity) {
        try {
            for (int i = 0; i < investments.size(); i++) {
                //Loop through portfolio find and 'sell' security

                if (investments.get(i).equals(investment)) {
                    //Get the details of the investment being sold off
                    double buyPrice = investments.get(i).getPrice();
                    double sellPrice = investment.getPrice();
                    double holdingQuantity = investment.getQuantity();

                    if (holdingQuantity >= sellQuantity) {
                        double profitLoss = (sellPrice - buyPrice) * sellQuantity;
                        cashBalance += sellPrice * sellQuantity;
                        profit += profitLoss;
                        investments.get(i).setQuantity(holdingQuantity - sellQuantity);
                    } else {
                        System.out.println("You can't sell more of " + investment.getName() + " than you have");
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Exception caught in Portfolio.sell function" + exception);
        }
    }

    public void sellOff(Trade investment) {
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

    public ArrayList<Trade> getInvestments() {
        return investments;
    }

    public void setInvestments(ArrayList<Trade> investments) {
        this.investments = investments;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void creditCashBalance(double credit) {
        if (credit >= 0) {
            this.cashBalance += credit;
        } else {
            System.out.println("You can't credit a negative cash amount");
        }
    }

    public void debitCashBalance(double debit) {
        if (debit >= 0) {
            this.cashBalance -= debit;
        } else {
            System.out.println("You can't debit a negative cash amount");
        }
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public double getProfit() {
        return profit;
    }
}
