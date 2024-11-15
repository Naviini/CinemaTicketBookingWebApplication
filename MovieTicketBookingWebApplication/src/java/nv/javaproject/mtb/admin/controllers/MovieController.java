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
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Movie;
import utils.DBConnection;

@WebServlet("/MovieController")

public class MovieController extends HttpServlet{
    private static final long serialVersionUID = 1L;

    // Handle GET requests (e.g., displaying movie listings)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Movie> movies = fetchMovies();
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("movies.jsp").forward(request, response);
    }

    // Fetch movies from the database
    private List<Movie> fetchMovies() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Movie";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie(
                    resultSet.getInt("movie_id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getString("genre"),
                    resultSet.getString("showtimes"),
                    resultSet.getInt("available_seats")
                );
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
    

