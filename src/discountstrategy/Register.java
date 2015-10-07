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
public class Register {
    private Receipt receipt;
    
   
    public final void OutputReceipt() {
        receipt.outputReceipt();
    }
    
    
    public final void addItemToSale(String prodId, int qty) {
          
            if(prodId ==  null || prodId.length() == 0 || qty < 1) {
                System.out.println("Failure");
                return;
            }
            receipt.addLineItem(prodId, qty);
    }
    
    
    public final void startNewSale(String custId, DataAccessStrategy db, OutputStrategy output) {
      
        if(custId == null || custId.length() == 0
                || db == null || output == null) {
            System.out.println("Failure");
            return;  
        }
        
        receipt = new Receipt(custId, db, output);
    }
}
