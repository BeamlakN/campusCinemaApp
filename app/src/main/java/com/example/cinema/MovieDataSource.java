package com.example.cinema;

import java.util.ArrayList;
import java.util.List;

public class MovieDataSource {

    private static List<MovieDetail> movieList = new ArrayList<>();

    static {
        movieList.add(new MovieDetail(R.drawable.rebelmoon, "Rebel Moon", R.raw.migration));
        movieList.add(new MovieDetail(R.drawable.damsel, "Damsel", R.raw.damsel));
        movieList.add(new MovieDetail(R.drawable.migration1, "Migration", R.raw.migration));

    }

    public static List<MovieDetail> getMovieList() {
        return new ArrayList<>(movieList);
    }

    public static MovieDetail getMovieById(int videoResource) {
        for (MovieDetail movie : movieList) {
            if (movie.getVideoResource() == videoResource) {
                return movie;
            }
        }
        return null;
    }
}
