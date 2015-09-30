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
public class ArrayPractice {
    public static void main(String[] args) {
        String [] names = new String[0];
        
        String [] temp = new String[names.length +1];
        
        for(int i = 0; i< names.length;i++){
            temp[i]=names[i];
            
        }
        temp[temp.length-1]= "Hello";
        names = temp;
        temp = null;
    }
    
    
    
    
}
