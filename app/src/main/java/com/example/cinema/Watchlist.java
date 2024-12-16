package com.example.cinema;

import java.util.ArrayList;
import java.util.List;

public class Watchlist {
    private static List<MovieDetail> watchlist = new ArrayList<>();

    public static void addToWatchlist(MovieDetail movie) {
        watchlist.add(movie);
    }

    public static void removeFromWatchlist(MovieDetail movie) {
        watchlist.remove(movie);
    }

    public static List<MovieDetail> getWatchlist() {
        return new ArrayList<>(watchlist);
    }
}
