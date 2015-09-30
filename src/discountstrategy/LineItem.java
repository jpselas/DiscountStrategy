/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author John
 */
public class LineItem {
  
    private int qty;
    private Product product;

    public LineItem() {
    }

    public LineItem(int qty, Product product) {
        this.qty = qty;
        this.product = product;
    }

    
    public double getSubtotal(){
        
        return product.getUnitPrice()* qty; 
    }
        
    public double getSubTotalDiscount(){
        
        return getSubtotal() - product.getDiscountProductTotal(qty);
    }    
    
   public String getProdId() {
        return product.getProdId();
    }
    
   public String getTitle(){
       return product.getTitle();
       
   } 
   
   public double getUnitPrice(){
       return product.getUnitPrice();
       
   }
   
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
    
   
    
   
    
    
    
    
    public static void main(String[] args) {
        LineItem item = new LineItem(4,new Product ("A100","Men's Shorts", 31.00,new PercentOffDiscount(.1)));
        
        double subtotal = item.getSubtotal();
        double subtotalDiscount = item.getSubTotalDiscount();
        System.out.println("Expected Subtotal = 124 and got :" + subtotal);
        System.out.println("Expected Subtotal Discount = 12.4 and got :" + subtotalDiscount);
    }
    
}
