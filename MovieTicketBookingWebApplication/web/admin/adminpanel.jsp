<!--added this import to fix the error that appears in 4th line-->
<%@page import="nv.javaproject.mtb.dbconn.DBconn"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% DBconn db = new DBconn(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>

    </head>
    <body>
        <h1>Hello World!</h1>
        <%= db.getConn()%>
    </body>
</html>
