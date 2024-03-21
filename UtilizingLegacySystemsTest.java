/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: UtilizingLegacySystemTest.java
 * Description: JUnit tests to test the function of majority methods
 */

package UtilizingLegacySystems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class UtilizingLegacySystemsTest {

    //Test case to verify the functionality of the legacy system.
    //binary id to decimal id
    @Test
    public void testLegacySystem(){
        long customerIdFromUSB = 1010011001;
        LegacySystem legacySystem = new LegacySystem(customerIdFromUSB);
        legacySystem.getCustomer_USB(0);
    }

    //Test case to verify the printing functionality of the legacy system adapter
    //using https interface to print id from usb
    @Test
    public void testLegacySystemAdapterPrint() {
        LegacySystem legacySystem = new LegacySystem(1010011001);
        NewSystem newSystem = new NewSystem();
        LegacySystemAdapter adapter = new LegacySystemAdapter(legacySystem, newSystem);
        adapter.printCustomer(665);
    }

    //Test case to verify the functionality of the legacy system adapter in retrieving and display customer data.
    @Test
    public void testLegacySystemAdapter() {
        LegacySystem legacySystem = new LegacySystem(1010011001);
        NewSystem newSystem = new NewSystem();
        LegacySystemAdapter adapter = new LegacySystemAdapter(legacySystem, newSystem);
        Customer customer = adapter.getCustomer_HTTPS(665);
        assertEquals(665, customer.getCustomerId());
    }

    //Test case to verify the functionality of the new system in retrieving and display customer data from the server.
    @Test
    public void testGetCustomerFromServer() {
        NewSystem newSystem = new NewSystem();
        Customer customer = newSystem.getCustomer_HTTPS(665);
        assertEquals(665, customer.getCustomerId());
    }





}
