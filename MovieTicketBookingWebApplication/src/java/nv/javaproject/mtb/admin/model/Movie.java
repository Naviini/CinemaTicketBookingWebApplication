/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nv.javaproject.mtb.admin.model;

/**
 *
 * @author user
 */
public class Movie {
    private int id;
    private String name;
    private String director;
    private String cast;
    private String relaese_date;
    private String description;
    private String duration;
    private String cover1;
    private String trailer;
    private String cover2;
    private String show_time;
    private String category_id;
//    defult constructor

    public Movie(int id, String name, String director, String cast, String relaese_date, String description, String duration, String cover1, String trailer, String cover2, String show_time, String category_id) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.cast = cast;
        this.relaese_date = relaese_date;
        this.description = description;
        this.duration = duration;
        this.cover1 = cover1;
        this.trailer = trailer;
        this.cover2 = cover2;
        this.show_time = show_time;
        this.category_id = category_id;
    }
//constructor without id

    public Movie(String name, String director, String cast, String relaese_date, String description, String duration, String cover1, String trailer, String cover2, String show_time, String category_id) {
        this.name = name;
        this.director = director;
        this.cast = cast;
        this.relaese_date = relaese_date;
        this.description = description;
        this.duration = duration;
        this.cover1 = cover1;
        this.trailer = trailer;
        this.cover2 = cover2;
        this.show_time = show_time;
        this.category_id = category_id;
    }
//    getters n setters 4 all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getRelaese_date() {
        return relaese_date;
    }

    public void setRelaese_date(String relaese_date) {
        this.relaese_date = relaese_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCover1() {
        return cover1;
    }

    public void setCover1(String cover1) {
        this.cover1 = cover1;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getCover2() {
        return cover2;
    }

    public void setCover2(String cover2) {
        this.cover2 = cover2;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
//toString method 4 debugging
    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", director=" + director + ", cast=" + cast + ", relaese_date=" + relaese_date + ", description=" + description + ", duration=" + duration + ", cover1=" + cover1 + ", trailer=" + trailer + ", cover2=" + cover2 + ", show_time=" + show_time + ", category_id=" + category_id + '}';
    }
    
}



//package models;
//
//public class Movie {
//    private int movieId;
//    private String title;
//    private String description;
//    private String genre;
//    private String showtimes;
//    private int availableSeats;
//
//    // Default constructor
//    public Movie() {}
//
//    // Parameterized constructor
//    public Movie(int movieId, String title, String description, String genre, String showtimes, int availableSeats) {
//        this.movieId = movieId;
//        this.title = title;
//        this.description = description;
//        this.genre = genre;
//        this.showtimes = showtimes;
//        this.availableSeats = availableSeats;
//    }
//
//    // Getters and Setters
//    public int getMovieId() {
//        return movieId;
//    }
//
//    public void setMovieId(int movieId) {
//        this.movieId = movieId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public String getShowtimes() {
//        return showtimes;
//    }
//
//    public void setShowtimes(String showtimes) {
//        this.showtimes = showtimes;
//    }
//
//    public int getAvailableSeats() {
//        return availableSeats;
//    }
//
//    public void setAvailableSeats(int availableSeats) {
//        this.availableSeats = availableSeats;
//    }
//}



































