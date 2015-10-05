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
public class Receipt {
    private LineItem lineitem;
    
    private double total;
    
    private LineItem [] lineitems = {};

    
    
    
    
    
    public final Product findProduct(String prodId){
        return lineitem.findProduct(prodId);
        
    }
    
//    public final Customer findCustomer(final String custId){
//        return lineitem.findCustomer(custId);
//        
//    }
    
    
    
    public LineItem getLineitem() {
        return lineitem;
    }

    public void setLineitem(LineItem lineitem) {
        this.lineitem = lineitem;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    

    public LineItem[] getLineitems() {
        return lineitems;
    }

    public void setLineitems(LineItem[] lineitems) {
        this.lineitems = lineitems;
    }
    
    
    public static void main(String[] args) {
       //String custId = "100";
       
       Receipt test = new Receipt();
       
        //System.out.println(test.findCustomer("100"));
        
       
    }
    
}
