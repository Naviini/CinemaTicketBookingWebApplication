<%-- 
    Document   : bookingSuccess
    Created on : Nov 15, 2024, 10:52:12 PM
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
    <title>Booking Successful</title>
    <link rel="stylesheet" href="css/styles.css"> <!-- Link to your CSS file -->
</head>
<body>
    <h2>Booking Successful!</h2>
    <p>Your ticket has been successfully booked.</p>
    <a href="movies.jsp">Back to Movies</a>
    
    <%= db.getConn()%>
    
</body>
</html>

