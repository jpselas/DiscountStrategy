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
public interface DataAccessStrategy {
    
    Customer findCustomer(final String custId);

    
    Product findProduct(final String prodId);
    
}
