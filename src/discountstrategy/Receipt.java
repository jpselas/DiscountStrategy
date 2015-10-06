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
    //private LineItem lineitem;
    private Customer customer;
    
    private DataAccessStrategy db;
    private LineItem [] lineitems = {};

    public Receipt(String custId, DataAccessStrategy db) {
         this.db = db;
         this.customer = db.findCustomer(custId);
        
    }

    public void addLineItem(String prodId, int qty){
        LineItem item = new LineItem(db,qty,prodId);
        addLineItemToArray(item);
        
    }
    
    public void addLineItemToArray(LineItem item){
        LineItem [] items = new LineItem[lineitems.length+1];
        
        
        
        for(int i = 0; i< lineitems.length;i++){
            items[i]=lineitems[i];
            
        }
        items[items.length-1]= item;
        lineitems = items;
        items = null;
        
    }
    
    
    public final Customer findCustomer(final String custId) {
        // validation is needed for method parameter
        if(custId == null || custId.length() == 0) {
            System.out.println("Invalid ID");
            return null;  // end method prematurely after log to console
        }
        
        Customer customerID = db.findCustomer(custId);
        if(customerID == null){
            System.out.println("Invalid ID");
            
        }
        
        return customerID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    


    public double getTotalBeforeDiscount() {
        double total= 0;
        for(LineItem b : lineitems){
            total += b.getSubtotal();
            
        }
        
        return total;
    }

    public double getTotalSavings(){
        double savingsTotal = 0;
        for(LineItem b : lineitems){
            savingsTotal += b.getSubTotalDiscount();
            
        }
        return savingsTotal;
    }

    public double getTotal(){
        return getTotalBeforeDiscount() - getTotalSavings();
        
    }

    public LineItem[] getLineitems() {
        return lineitems;
    }

    public void setLineitems(LineItem[] lineitems) {
        this.lineitems = lineitems;
    }
    
    
    public static void main(String[] args) {
        String custId = "100";
        String prodId = "A101";
        Receipt first = new Receipt(custId,new FakeDatabase());
        String name = first.findCustomer(custId).getName();
        System.out.println(name);
        //first.addLineItem(prodId, 2);
        first.addLineItem("A101", 16);
        System.out.println("The total before discounts is :$" +first.getTotalBeforeDiscount());
        System.out.println("The total savings are :$" +first.getTotalSavings());
        System.out.println("The total after savings is :$" + first.getTotal());
    }
    
}
