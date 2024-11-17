/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.admin.models;
//package models;

import java.util.Date;

public class Booking {
    private int bookingId;
    private int customerId;
    private int movieId;
    private String seatNumber;
    private Date bookingDate;

    // Default constructor
    public Booking() {}

    // Parameterized constructor
    public Booking(int bookingId, int customerId, int movieId, String seatNumber, Date bookingDate) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.movieId = movieId;
        this.seatNumber = seatNumber;
        this.bookingDate = bookingDate;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}

    
