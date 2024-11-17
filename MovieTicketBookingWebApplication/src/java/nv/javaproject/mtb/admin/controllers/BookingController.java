/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.admin.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
//update
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Booking;
import utils.DBConnection;

@WebServlet("/BookingController")
public class BookingController extends HttpServlet{
    private static final long serialVersionUID = 1L;

//    // Handle POST requests for booking
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int customerId = Integer.parseInt(request.getSession().getAttribute("customerId").toString()); // Assuming customer is logged in
//        int movieId = Integer.parseInt(request.getParameter("movieId"));
//        String seatNumber = request.getParameter("seatNumber"); // Assuming a form input for seat number
//
//        Booking booking = new Booking(0, customerId, movieId, seatNumber, new Date());
//        if (createBooking(booking)) {
//            response.sendRedirect("bookingSuccess.jsp");
//        } else {
//            response.sendRedirect("bookingError.jsp");
//        }
//    }
//
//    // Method to create a booking
//    private boolean createBooking(Booking booking) {
//        boolean isSuccess = false;
//        try (Connection connection = DBConnection.getConnection()) {
//            String sql = "INSERT INTO Booking (customer_id, movie_id, seat_number, booking_date) VALUES (?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, booking.getCustomerId());
//            statement.setInt(2, booking.getMovieId());
//            statement.setString(3, booking.getSeatNumber());
//            statement.setTimestamp(4, new java.sql.Timestamp(booking.getBookingDate().getTime()));
//
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                isSuccess = true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return isSuccess;
//    }
//}
    


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getSession().getAttribute("customerId").toString()); // Assuming customer is logged in
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        String seatNumber = request.getParameter("seatNumber"); // Assuming a form input for seat number

        if (isSeatAvailable(movieId, seatNumber)) {
            Booking booking = new Booking(0, customerId, movieId, seatNumber, new Date());
            if (createBooking(booking)) {
                response.sendRedirect("bookingSuccess.jsp");
            } else {
                response.sendRedirect("bookingError.jsp");
            }
        } else {
            response.sendRedirect("seatUnavailable.jsp");
        }
    }

    // Method to check if a seat is available
    private boolean isSeatAvailable(int movieId, String seatNumber) {
        boolean isAvailable = true;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Booking WHERE movie_id = ? AND seat_number = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, movieId);
            statement.setString(2, seatNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isAvailable = false; // Seat is already booked
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAvailable;
    }

    // Existing createBooking method
    private boolean createBooking(Booking booking) {
        boolean isSuccess = false;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO Booking (customer_id, movie_id, seat_number, booking_date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, booking.getCustomerId());
            statement.setInt(2, booking.getMovieId());
            statement.setString(3, booking.getSeatNumber());
            statement.setTimestamp(4, new java.sql.Timestamp(booking.getBookingDate().getTime()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}




//UPDATE
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//
//// Method to cancel a booking
//private boolean cancelBooking(int bookingId) {
//    boolean isCancelled = false;
//    try (Connection connection = DBConnection.getConnection()) {
//        String sql = "DELETE FROM Booking WHERE booking_id = ?";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1, bookingId);
//
//        int rowsDeleted = statement.executeUpdate();
//        if (rowsDeleted > 0) {
//            isCancelled = true;
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return isCancelled;
//}


//Example Integration in BookingController.java

//protected boolean createBooking(Booking booking) {
//    boolean isSuccess = false;
//    try (Connection connection = DBConnection.getConnection()) {
//        String sql = "INSERT INTO Booking (customer_id, movie_id, seat_number, booking_date) VALUES (?, ?, ?, ?)";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1, booking.getCustomerId());
//        statement.setInt(2, booking.getMovieId());
//        statement.setString(3, booking.getSeatNumber());
//        statement.setTimestamp(4, new java.sql.Timestamp(booking.getBookingDate().getTime()));
//
//        int rowsInserted = statement.executeUpdate();
//        if (rowsInserted > 0) {
//            isSuccess = true;
//
//            // Send email notification
//            String email = "recipient@example.com"; // Replace with recipient's email address (e.g., fetched from Customer data)
//            String subject = "Booking Confirmation";
//            String message = "Dear Customer,\n\nYour booking has been confirmed for Movie ID: " + booking.getMovieId()
//                            + "\nSeat Number: " + booking.getSeatNumber() + "\nThank you for booking with us!";
//            EmailUtility.sendEmail(email, subject, message);
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return isSuccess;
//}















