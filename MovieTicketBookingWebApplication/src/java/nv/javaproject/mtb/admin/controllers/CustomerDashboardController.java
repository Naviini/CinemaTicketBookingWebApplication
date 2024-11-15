/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.admin.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Booking;
import models.Payment;
import utils.DBConnection;

@WebServlet("/CustomerDashboardController")
public class CustomerDashboardController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getSession().getAttribute("customerId").toString()); // Assume customer is logged in
        List<Booking> bookings = fetchCustomerBookings(customerId);
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("customerDashboard.jsp").forward(request, response);
    }

    // Fetch bookings for the customer
    private List<Booking> fetchCustomerBookings(int customerId) {
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Booking WHERE customer_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Booking booking = new Booking(
                    resultSet.getInt("booking_id"),
                    resultSet.getInt("customer_id"),
                    resultSet.getInt("movie_id"),
                    resultSet.getString("seat_number"),
                    resultSet.getTimestamp("booking_date")
                );
                booking.setPayment(fetchPaymentForBooking(booking.getBookingId()));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // Fetch payment details for a booking
    private Payment fetchPaymentForBooking(int bookingId) {
        Payment payment = null;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Payment WHERE booking_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookingId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                payment = new Payment(
                    resultSet.getInt("payment_id"),
                    resultSet.getInt("booking_id"),
                    resultSet.getDouble("amount"),
                    resultSet.getString("status"),
                    resultSet.getTimestamp("payment_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }
}
    
//UPDATE EG-:1
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    // Check if the user is logged in
//    if (request.getSession().getAttribute("customerId") == null) {
//        response.sendRedirect("login.jsp?error=Please login to access your dashboard.");
//        return;
//    }
//
//    int customerId = Integer.parseInt(request.getSession().getAttribute("customerId").toString());
//    List<Booking> bookings = fetchCustomerBookings(customerId);
//    request.setAttribute("bookings", bookings);
//    request.getRequestDispatcher("customerDashboard.jsp").forward(request, response);
//}

//UPDATE EG-:2
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    // Session validation for booking actions
//    if (request.getSession().getAttribute("customerId") == null) {
//        response.sendRedirect("login.jsp?error=Please login to proceed with booking actions.");
//        return;
//    }
//
//    String action = request.getParameter("action");
//    if ("cancel".equalsIgnoreCase(action)) {
//        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
//        if (cancelBooking(bookingId)) {
//            response.sendRedirect("customerDashboard.jsp?success=Booking cancelled successfully.");
//        } else {
//            response.sendRedirect("customerDashboard.jsp?error=Failed to cancel the booking.");
//        }
//    } else {
//        // Existing booking creation logic
//        int customerId = Integer.parseInt(request.getSession().getAttribute("customerId").toString());
//        int movieId = Integer.parseInt(request.getParameter("movieId"));
//        String seatNumber = request.getParameter("seatNumber");
//
//        if (isSeatAvailable(movieId, seatNumber)) {
//            Booking booking = new Booking(0, customerId, movieId, seatNumber, new Date());
//            if (createBooking(booking)) {
//                response.sendRedirect("bookingSuccess.jsp");
//            } else {
//                response.sendRedirect("bookingError.jsp");
//            }
//        } else {
//            response.sendRedirect("seatUnavailable.jsp");
//        }
//    }
//}


