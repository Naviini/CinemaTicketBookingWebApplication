/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.admin.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Payment;
import utils.DBConnection;

@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Payment details (for demonstration)
        String amount = request.getParameter("amount");
        String currency = "USD";

        // Redirect to PayPal payment page
        String paypalURL = "https://www.sandbox.paypal.com/cgi-bin/webscr";
        paypalURL += "?cmd=_xclick";
        paypalURL += "&business=YOUR_PAYPAL_SANDBOX_EMAIL"; // Replace with your sandbox business email
        paypalURL += "&item_name=Movie Ticket Booking";
        paypalURL += "&amount=" + amount;
        paypalURL += "&currency_code=" + currency;
        paypalURL += "&return=http://localhost:8080/yourAppName/paymentSuccess.jsp?amount=" + amount; // Pass amount as query param
        paypalURL += "&cancel_return=http://localhost:8080/yourAppName/paymentCancel.jsp";

        // Redirect to PayPal for payment
        response.sendRedirect(paypalURL);
    }

    // Method to handle storing payment confirmation data
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paymentStatus = request.getParameter("status"); // Assume this comes from PayPal callback
        String amount = request.getParameter("amount");
        int bookingId = Integer.parseInt(request.getParameter("bookingId")); // Pass this through when redirecting from PayPal

        if ("success".equalsIgnoreCase(paymentStatus)) {
            // Create and store payment in DB
            Payment payment = new Payment(0, bookingId, Double.parseDouble(amount), "Completed", new java.util.Date());
            if (storePayment(payment)) {
                response.sendRedirect("paymentSuccess.jsp");
            } else {
                response.sendRedirect("paymentError.jsp");
            }
        } else {
            response.sendRedirect("paymentCancel.jsp");
        }
    }

    // Store payment details in the database
    private boolean storePayment(Payment payment) {
        boolean isStored = false;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO Payment (booking_id, amount, status, payment_date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, payment.getBookingId());
            statement.setDouble(2, payment.getAmount());
            statement.setString(3, payment.getStatus());
            statement.setTimestamp(4, new java.sql.Timestamp(payment.getPaymentDate().getTime()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isStored = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isStored;
    }
}
    

