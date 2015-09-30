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
public class Product {
    private String prodId;
    private String title;
    private double unitPrice;
    private DiscountStrategy discount;

    public Product() {
    }

    public Product(String prodId, String title, double unitPrice, DiscountStrategy discount) {
        this.prodId = prodId;
        this.title = title;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }
    public double getAmountSaved(int qty){
        
        return discount.getAmountSaved(unitPrice, qty);
        
    }
    
     public double getDiscountProductTotal(int qty){
        
        return discount.getDiscountProductTotal(unitPrice, qty);
        
    }
    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    
    
    public static void main(String[] args) {
        Product product = new Product("A100","Hat",20.00,new PercentOffDiscount(.10));
        
        double amtSaved = product.getAmountSaved(2);
        System.out.println("Expected $4.00 and got: $" + amtSaved);
    }
    
}
