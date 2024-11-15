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
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Customer;
import utils.DBConnection; 

@WebServlet("/CustomerController")
//public class CustomerController {
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests (e.g., displaying registration/login pages)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("register".equalsIgnoreCase(action)) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if ("login".equalsIgnoreCase(action)) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // Handle POST requests (e.g., form submissions for registration/login)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equalsIgnoreCase(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String password = request.getParameter("password");

            Customer customer = new Customer(0, name, email, phoneNumber, password);
            if (registerCustomer(customer)) {
                response.sendRedirect("success.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } else if ("login".equalsIgnoreCase(action)) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if (authenticateCustomer(email, password)) {
                response.sendRedirect("welcome.jsp");
            } else {
                response.sendRedirect("login.jsp?error=Invalid credentials");
            }
        }
    }

    // Method to register a new customer
    private boolean registerCustomer(Customer customer) {
        boolean isRegistered = false;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO Customer (name, email, phone_number, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhoneNumber());
            statement.setString(4, customer.getPassword());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isRegistered = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRegistered;
    }

    // Method to authenticate a customer
    private boolean authenticateCustomer(String email, String password) {
        boolean isAuthenticated = false;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Customer WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isAuthenticated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }
}


