package com.example.cinema;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinema.MovieDetail;

import java.util.List;

public class BestMoviesAdapter extends RecyclerView.Adapter<BestMoviesAdapter.MovieViewHolder> {

    private List<MovieDetail> movieList;
    private Context context;

    public BestMoviesAdapter(List<MovieDetail> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_best_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieDetail movie = movieList.get(position);
        holder.imageView.setImageResource(movie.getPoster());
        holder.titleView.setText(movie.getMovieName());
        holder.durationView.setText(movie.getRuntime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra("posterResId", movie.getPoster());
                intent.putExtra("title", movie.getMovieName());
                intent.putExtra("releaseDate", movie.getReleaseDate());
                intent.putExtra("genre", movie.getGenre());
                intent.putExtra("rating", movie.getRating());
                intent.putExtra("description", movie.getDescription());
                context.startActivity(intent);
            }
        });

        holder.addToWatchlistButton.setOnClickListener(v -> {
            Watchlist.addToWatchlist(movie);
            Toast.makeText(context, "Added to watchlist", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void filterList(List<MovieDetail> filteredList) {
        movieList = filteredList;
        notifyDataSetChanged();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleView;
        TextView durationView;
        Button addToWatchlistButton;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageBestMovie);
            titleView = itemView.findViewById(R.id.titleBestMovie);
            durationView = itemView.findViewById(R.id.runtimeBestMovie);
            addToWatchlistButton = itemView.findViewById(R.id.buttonBestMovie);
        }
    }
}
