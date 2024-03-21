/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: New.java
 * Description: This class represents a new system that communicates over HTTPS to retrieve customer data.
 */

package UtilizingLegacySystems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewSystem implements CustomerData_HTTPS {
    @Override
    public void printCustomer(int customerId) {
        System.out.println("Customer ID(Via HTTPS): " + customerId);
    }

    @Override
    public Customer getCustomer_HTTPS(int customerId) {
        try {
            // Create a URL object and change to servlet url
            URL url = new URL("http://localhost:8080/customer");

            // open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // get server response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // parse customer id from response
            int customerID = parseCustomerIdFromJson(response.toString());

            // return customer object
            return new Customer(customerID);
        } catch (IOException e) {
            e.printStackTrace();
            return new Customer(-1); //return default value when error
        }
    }

    // parses the customer id from json response
    private int parseCustomerIdFromJson(String json) {

        int customerId = -1; // set default as -1
        try {
            customerId = Integer.parseInt(json.split("\"customerId\":")[1].split("}")[0].trim());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return customerId;
    }
}
