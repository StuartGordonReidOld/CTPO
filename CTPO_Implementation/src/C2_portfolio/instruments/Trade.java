/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package C2_portfolio.instruments;

import java.util.Objects;

/**
 *
 * @author stuart
 */
public class Trade {

    final Security security;
    final double price;
    final String name;
    double quantity;

    public Trade(Security s, double qty, String n) {
        security = s;
        quantity = qty;
        price = s.getPrice();
        name = n;
    }

    public double calculateValue() {
        return price * quantity;
    }

    public Security getSecurity() {
        return security;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double qty) {
        quantity = qty;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.print(name + "| " + security.getName() + " at "
                + price + " for " + quantity);
    }

    //Comparitive functions
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trade other = (Trade) obj;
        if (!Objects.equals(this.security, other.security)) {
            return false;
        }
        if (Double.doubleToLongBits(this.quantity) != Double.doubleToLongBits(other.quantity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.security);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.quantity) ^ (Double.doubleToLongBits(this.quantity) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
