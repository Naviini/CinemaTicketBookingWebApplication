<%-- 
    Document   : customerDashboard
    Created on : Nov 15, 2024, 11:07:29 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <link rel="stylesheet" href="css/styles.css"> <!-- Link to your CSS file -->
</head>
<body>
    <h2>Welcome to Your Dashboard</h2>
    <h3>Your Bookings</h3>
    <table border="1">
        <thead>
            <tr>
                <th>Booking ID</th>
                <th>Movie ID</th>
                <th>Seat Number</th>
                <th>Booking Date</th>
                <th>Payment Status</th>
                <th>Payment Amount</th>
            </tr>
        </thead>
<!--        <tbody>
            <c:forEach var="booking" items="${bookings}">
                <tr>
                    <td>${booking.bookingId}</td>
                    <td>${booking.movieId}</td>
                    <td>${booking.seatNumber}</td>
                    <td>${booking.bookingDate}</td>
                    <td>${booking.payment != null ? booking.payment.status : "Pending"}</td>
                    <td>${booking.payment != null ? booking.payment.amount : "N/A"}</td>
                </tr>
            </c:forEach>
        </tbody>-->
        <tbody>
    <c:forEach var="booking" items="${bookings}">
        <tr>
            <td>${booking.bookingId}</td>
            <td>${booking.movieId}</td>
            <td>${booking.seatNumber}</td>
            <td>${booking.bookingDate}</td>
            <td>${booking.payment != null ? booking.payment.status : "Pending"}</td>
            <td>${booking.payment != null ? booking.payment.amount : "N/A"}</td>
            <td>
                <form action="BookingController" method="post">
                    <input type="hidden" name="action" value="cancel">
                    <input type="hidden" name="bookingId" value="${booking.bookingId}">
                    <button type="submit" onclick="return confirm('Are you sure you want to cancel this booking?');">Cancel Booking</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</tbody>
    </table>
    <a href="movies.jsp">Book Another Movie</a>
</body>
</html>
