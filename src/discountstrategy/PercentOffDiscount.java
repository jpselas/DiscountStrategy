/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author jselas1
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double discountRate;

    public PercentOffDiscount(double discountRate) {
        this.discountRate = discountRate;
    }
    

    @Override
    public double getDiscountProductTotal(double unitPrice, int qty){
        
        return (unitPrice * qty)-getAmountSaved(unitPrice,qty);
        
    }
    @Override
    public double getAmountSaved(double unitPrice, int qty){
        
        return (unitPrice * qty) * discountRate;
        
    }
    
    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public static void main(String[] args) {
        DiscountStrategy discount = new QtyDiscount(.10,5);
        DiscountStrategy discount1 = new PercentOffDiscount(.10);
        double amt = discount.getAmountSaved(14.00, 2);
        System.out.println("Discount Amount: $" + amt);
        double newTotal = discount.getDiscountProductTotal(14.00, 2);
        System.out.println("Discount Product Total: $" + newTotal);
    }
}
