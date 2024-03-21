/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: CustomerData_HTTPS.java
 * Description: This interface defines methods for retrieving customer data from a new system
 *              using HTTPS.
 */

package UtilizingLegacySystems;

//New System via HTTPS

public interface CustomerData_HTTPS {
    void printCustomer(int customerId); //method to print customer id
    Customer getCustomer_HTTPS(int customerId); //method to retrieve customer id
}
