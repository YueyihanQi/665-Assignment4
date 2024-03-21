/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: Customer.java
 * Description: This class represents a customer entity with a unique customer ID.
 *              It provides methods to get the customer ID.
 */

package UtilizingLegacySystems;

public class Customer {
    private int customerId;
    public Customer(int customerId) {
        this.customerId = customerId;
    } //constructor of customer
    public int getCustomerId(){
        return customerId;
    } //getter method to retrieve customer id
}
