<%-- 
    Document   : booking
    Created on : Nov 15, 2024, 5:11:47 PM
    Author     : user
--%>
<%@page import="nv.javaproject.mtb.dbconn.DBconn"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% DBconn db = new DBconn(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Page</title>
    </head>
    
        <h1>Hello Navii!</h1>
        <%= db.getConn()%>
    
</html>
