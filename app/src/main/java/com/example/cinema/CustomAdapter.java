package com.example.cinema;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<MovieDetail> movieList;
    private List<MovieDetail> filteredList;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(List<MovieDetail> movieList, Context context) {
        this.movieList = movieList;
        this.filteredList = new ArrayList<>(movieList);
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.watchlists, parent, false);
            holder = new ViewHolder();
            holder.movieTitle = convertView.findViewById(R.id.movie_title);
            holder.movieImage = convertView.findViewById(R.id.movie_image);
            holder.removeButton = convertView.findViewById(R.id.remove_button);
            holder.watchButton = convertView.findViewById(R.id.watch_button);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final MovieDetail movie = filteredList.get(position);
        holder.movieTitle.setText(movie.getMovieName());
        holder.movieImage.setImageResource(movie.getPoster());

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemoveConfirmationDialog(position);
            }
        });


        holder.watchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MoviePlayerActivity.class);
                intent.putExtra("videoResource", movie.getVideoResource());
                context.startActivity(intent);
            }
        });


        return convertView;
    }

    static class ViewHolder {
        TextView movieTitle;
        ImageView movieImage;
        Button removeButton;
        Button watchButton;
    }

    private void showRemoveConfirmationDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Are you sure you want to remove this movie?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        removeMovie(position);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void removeMovie(int position) {

        MovieDetail removedMovie = filteredList.remove(position);
        movieList.remove(removedMovie);


        Watchlist.removeFromWatchlist(removedMovie);

        notifyDataSetChanged();
    }


    public void filter(String query) {
        filteredList.clear();

        if (query.isEmpty()) {
            filteredList.addAll(movieList);
        } else {
            query = query.toLowerCase().trim();
            for (MovieDetail movie : movieList) {
                if (movie.getMovieName().toLowerCase().contains(query)) {
                    filteredList.add(movie);
                }
            }
        }

        notifyDataSetChanged(); 
    }
}
