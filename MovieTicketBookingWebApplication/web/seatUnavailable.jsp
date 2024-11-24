<%-- 
    Document   : seatUnavailable
    Created on : Nov 15, 2024, 10:57:56 PM
    Author     : user
--%>
<%@page import="nv.javaproject.mtb.dbconn.DBconn"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% DBconn db = new DBconn(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seat Unavailable</title>
    <link rel="stylesheet" href="css/styles.css"> <!-- Link to your CSS file -->
</head>

    <h2>Seat Unavailable</h2>
    <p>Sorry, the seat you selected is already booked. Please select a different seat.</p>
    <a href="movies.jsp">Back to Movies</a>
    
    <%= db.getConn()%>
    

</html>

