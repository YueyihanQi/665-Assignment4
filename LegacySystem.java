/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: LegacySystem.java
 * Description: This class represents a legacy system that retrieves customer data via USB.
 */

package UtilizingLegacySystems;

//the legacy system implements interface CustomerData_USB
public class LegacySystem implements CustomerData_USB{
    private final long customerIdFromUSB;

    //constructor of legacy system
    public LegacySystem(long customerIdFromUSB){
        this.customerIdFromUSB = customerIdFromUSB;
    }
    @Override
    //print customer id via USB
    public void printCustomer(int customerId){
        System.out.println("Customer ID(Via USB): " + customerId);
    }

    //getter method of customer id(binary)
    public long getCustomerIdFromUSB() {
        return customerIdFromUSB;
    }

    //retrieves customer id from legacy system using usb
    @Override
    public Customer getCustomer_USB(int customerId){
        long binaryCustomerId = customerIdFromUSB; //binary id
        customerId = parseBinaryCustomerId(binaryCustomerId); //change into decimal
        printCustomer(customerId);
        return new Customer(customerId);
    }

    // parses binary id to decimal
    private int parseBinaryCustomerId(long binaryCustomerId){
        int customerId = 0;
        int base = 1;
        while (binaryCustomerId != 0){
            long lastDigit = binaryCustomerId % 10;
            customerId += lastDigit * base;
            binaryCustomerId = binaryCustomerId / 10;
            base = base  * 2;
        }
        return customerId;
    }


}
