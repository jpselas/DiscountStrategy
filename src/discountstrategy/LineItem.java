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
    private DataAccessStrategy db;
    private int qty;
    private Product product;
    
    public LineItem(DataAccessStrategy db, int qty, String prodId) {
        this.db = db;
        this.qty = qty;
        this.product = db.findProduct(prodId);
    }

    
    
    
    public LineItem() {
    }

    
    
    private final Product findProduct(final String prodId) {
        // validation needed
        return db.findProduct(prodId);
    }
    
    public double getAmtSAved(){
        return product.getAmountSaved(qty);
        
    }
    public double getSubtotal(){
        
        return product.getUnitPrice()* qty; 
    }
        
    public double getSubTotalDiscount(){
        
        return product.getAmountSaved(qty);
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

    public DataAccessStrategy getDb() {
        return db;
    }

    public void setDb(DataAccessStrategy db) {
        this.db = db;
    }

    
    
   
    
   
    
    
    
    
    
    
}
