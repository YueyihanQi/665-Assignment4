/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: CustomerData_USB.java
 * Description: This interface defines methods for retrieving customer data from a legacy system
 *              using USB.
 */

package UtilizingLegacySystems;

//Legacy System via USB

public interface CustomerData_USB {
    void printCustomer(int customerId); //method to print customer id
    Customer getCustomer_USB(int customerId); //method to retrieve customer id
}
