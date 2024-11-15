<%-- 
    Document   : movie
    Created on : Nov 15, 2024, 10:49:42 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie Listings</title>
    <link rel="stylesheet" href="css/styles.css"> <!-- Link to your CSS file -->
</head>
<body>
    <h2>Available Movies</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Genre</th>
                <th>Showtimes</th>
                <th>Available Seats</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>${movie.title}</td>
                    <td>${movie.description}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.showtimes}</td>
                    <td>${movie.availableSeats}</td>
                    <td>
                        <form action="BookingController" method="post">
                            <input type="hidden" name="movieId" value="${movie.movieId}">
                            <button type="submit">Book Now</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
