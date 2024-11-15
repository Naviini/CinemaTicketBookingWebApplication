<%-- 
    Document   : payment
    Created on : Nov 15, 2024, 11:00:33 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Make Payment</title>
    <link rel="stylesheet" href="css/styles.css"> <!-- Link to your CSS file -->
</head>
<body>
    <h2>Payment</h2>
    <form action="PaymentController" method="post">
        <div>
            <label for="amount">Amount:</label>
            <input type="text" id="amount" name="amount" required readonly value="20.00"> <!-- Example amount -->
        </div>
        <button type="submit">Proceed to PayPal</button>
    </form>
</body>
</html>
