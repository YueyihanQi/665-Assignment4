/**
 * Name: Yueyihan Qi
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: CustomerServlet.java
 * Description: This servlet class defines methods for retrieving customer data both from a legacy system
 *              and new system using HTTPS.
 */

package UtilizingLegacySystems;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CustomerServlet", value = "/customer") //Associate the Servlet class with the specified URL mapping
public class CustomerServlet extends HttpServlet {
    private final CustomerData_HTTPS customerData;

    //Constructor for CustomerServlet
    public CustomerServlet(CustomerData_HTTPS customerData) {
        this.customerData = customerData;
    }

    //Used to process HTTP GET requests from the client, fetch client data from the new system and return it to the client in JSON format.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*"); //Set to allow cross-domain access, * means that requests from any domain are allowed to access the resource
        PrintWriter out = response.getWriter(); //A PrintWriter object is created to send response data to the client.
        try {
            Customer customer = customerData.getCustomer_HTTPS(665);
            String json = "{\"customerId\": " + customer.getCustomerId() + "}";
            out.println(json);
        } catch (Exception e) { //exception handling
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"error\": \"Internal server error\"}");
            e.printStackTrace();
        }
    }
}
