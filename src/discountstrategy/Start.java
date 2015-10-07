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
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Register r = new Register();
        
        // Customer #1 sale
        r.startNewSale("100", new FakeDatabase(), new ConsoleOutput());
        r.addItemToSale("B205", 2);
        r.addItemToSale("A101", 1);
        r.OutputReceipt();
        
        // Customer #2 sale
        r.startNewSale("200", new FakeDatabase(), new ConsoleOutput());
        r.addItemToSale("C222", 4);
        r.addItemToSale("B205", 6);
        r.OutputReceipt();
    }
    
    
}
