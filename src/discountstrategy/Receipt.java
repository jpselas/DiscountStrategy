/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.NumberFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author John
 */
public class Receipt {
    //private LineItem lineitem;
    private Customer customer;
    private Date rDate;
    private String dateFormat = "M/d/yyyy hh:mm a";
    private OutputStrategy output; 
    private DataAccessStrategy db;
    private LineItem [] lineitems = {};
    private static int receiptNum = 0;
    public Receipt(String custId, DataAccessStrategy db,OutputStrategy output) {
         this.db = db;
         this.customer = db.findCustomer(custId);
         this.output = output;
         receiptNum++;
         rDate = new Date();
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
    public String getReceiptDateFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(rDate);
    }
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
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
            savingsTotal += b.getAmtSAved();
            
        }
        return ((int)(savingsTotal *100)) /100.0;
    }

    public double getTotal(){
        return ((int)((getTotalBeforeDiscount() - getTotalSavings())*100))/100.0;
        
    }

    public LineItem[] getLineitems() {
        return lineitems;
    }

    public void setLineitems(LineItem[] lineitems) {
        this.lineitems = lineitems;
    }
    public final void outputReceipt() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        final String CRLF = "\n";
        final String CRLF2 = "\n\n";
        
        
        StringBuilder receiptData = new StringBuilder("Thank you for shopping at Kohls!\n\n");
        receiptData.append("Sold to: ").append(customer.getName()).append(CRLF);
        receiptData.append("Date of Sale: ").append(getReceiptDateFormatted()).append(CRLF);
        receiptData.append("Receipt No.: " ).append(Receipt.receiptNum).append(CRLF2);
        
        // process line items
        receiptData.append("ID\tItem\t\t\tPrice\tQty\tSubtotal\tDiscount").append(CRLF);
        receiptData.append("------------------------------------------------------------------------").append(CRLF);
        for(LineItem item : lineitems) {
            receiptData.append(item.getProduct().getProdId()).append("\t");
            receiptData.append(item.getProduct().getTitle()).append("\t");
            receiptData.append(nf.format(item.getProduct().getUnitPrice())).append("\t");
            receiptData.append(item.getQty()).append("\t");
            receiptData.append(nf.format(item.getSubtotal())).append("\t\t");
            receiptData.append(nf.format(item.getSubTotalDiscount())).append(CRLF);
        }
        
        //  process totals
        receiptData.append(CRLF);
        receiptData.append("\t\t\t\t\t\t\t\t--------").append(CRLF);
        double totalNet = getTotalBeforeDiscount();
        receiptData.append("\t\t\t\t\t\tNet Total: \t").append(nf.format(totalNet)).append(CRLF);
        double totalDiscount = getTotalSavings();
        receiptData.append("\t\t\t\t\t\tTotal Saved: \t-").append(nf.format(totalDiscount)).append(CRLF);
        double totalDue = getTotal();
        receiptData.append("\t\t\t\t\t\tTotal Due: \t").append(nf.format(totalDue)).append(CRLF);
        
        // Now generate data string...
        // Notice that the format is hardcoded into this method. We could do
        // better by using a format strategy in the future.
        output.outputReceipt(receiptData.toString());
    }
    
    public static void main(String[] args) {
        String custId = "100";
        String prodId = "A101";
        Receipt first = new Receipt(custId,new FakeDatabase(),new ConsoleOutput());
        String name = first.findCustomer(custId).getName();
        System.out.println(name);
        //first.addLineItem(prodId, 2);
        first.addLineItem("A101", 10);
        first.addLineItem("C222",10);
        System.out.println("The total before discounts is :$" +first.getTotalBeforeDiscount());
        System.out.println("The total savings are :$" +first.getTotalSavings());
        System.out.println("The total after savings is :$" + first.getTotal());
    }
    
}
