/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.user.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Payment details (for demonstration)
        String amount = request.getParameter("amount"); // Assume amount is passed as a form parameter
        String currency = "USD"; // Change as per your requirement

        // Redirect to PayPal payment page
        String paypalURL = "https://www.sandbox.paypal.com/cgi-bin/webscr";
        paypalURL += "?cmd=_xclick";
        paypalURL += "&business=YOUR_PAYPAL_SANDBOX_EMAIL"; // Replace with your sandbox business email
        paypalURL += "&item_name=Movie Ticket Booking";
        paypalURL += "&amount=" + amount;
        paypalURL += "&currency_code=" + currency;
        paypalURL += "&return=http://localhost:8080/yourAppName/paymentSuccess.jsp"; // Change URL as needed
        paypalURL += "&cancel_return=http://localhost:8080/yourAppName/paymentCancel.jsp"; // Change URL as needed

        // Redirect to PayPal for payment
        response.sendRedirect(paypalURL);
    }
}
    

