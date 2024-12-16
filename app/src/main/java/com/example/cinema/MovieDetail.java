package com.example.cinema;

public class MovieDetail {
    private int id;
    private int poster;
    private String movieName;
    private String releaseDate;
    private String genre;
    private String rating;
    private String description;
    private String runtime;
    private int videoResource;
    private String videoUrl;


    public MovieDetail(int id, int poster, String movieName, String releaseDate, String genre, String rating, String description) {
        this.id = id;
        this.poster = poster;
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating = rating;
        this.description = description;
    }


    public MovieDetail(int poster, String movieName, int id) {
        this.id = id;
        this.movieName = movieName;
        this.poster = poster;
    }


    public MovieDetail(int id, int poster, String movieName, int videoResource) {
        this.id = id;
        this.poster = poster;
        this.movieName = movieName;
        this.videoResource = videoResource;
    }
    public MovieDetail(int poster, String movieName, String runtime) {
        this.poster = poster;
        this.movieName = movieName;
        this.runtime = runtime;
    }


    public MovieDetail(int id, int poster, String movieName, String runtime) {
        this.id = id;
        this.poster = poster;
        this.movieName = movieName;
        this.runtime = runtime;
    }
    public MovieDetail(String title, String videoUrl) {
        this.movieName = title;
        this.videoUrl = videoUrl;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public int getVideoResource() {
        return videoResource;
    }

 }
