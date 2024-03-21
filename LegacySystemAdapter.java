/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: LegacySystemAdapter.java
 * Description: This class acts as an adapter to integrate a legacy system, which retrieves customer data via USB,
 *              with a new system that communicates over HTTPS.
 */

package UtilizingLegacySystems;

public class LegacySystemAdapter implements CustomerData_HTTPS{
    private final LegacySystem legacySystem;
    private final NewSystem newSystem;

    // constructor of legacy system adapter, retrieve id from usb and display with https
    public LegacySystemAdapter(LegacySystem legacySystem, NewSystem newSystem) {
        this.legacySystem = legacySystem;
        this.newSystem = newSystem;
    }

    //print with new system
    @Override
    public void printCustomer(int customerId) {
        long binaryCustomerId = legacySystem.getCustomerIdFromUSB();
        newSystem.printCustomer(customerId);
    }

    // get decimal id from legacy system
    @Override
    public Customer getCustomer_HTTPS(int customerId) {
        long binaryCustomerId = legacySystem.getCustomerIdFromUSB();
        return newSystem.getCustomer_HTTPS(customerId);
    }

}
