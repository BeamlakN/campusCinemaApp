package com.example.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView moviePosterImageView;
    private ImageView blurredBackgroundImageView;
    private TextView movieTitleTextView;
    private TextView movieReleaseDateTextView;
    private TextView movieGenreTextView;
    private TextView movieRatingTextView;
    private TextView movieDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moviedetail);

        blurredBackgroundImageView = findViewById(R.id.blurred_background);
        moviePosterImageView = findViewById(R.id.movie_poster);
        movieTitleTextView = findViewById(R.id.movie_title);
        movieReleaseDateTextView = findViewById(R.id.movie_release_date);
        movieGenreTextView = findViewById(R.id.movie_genre);
        movieRatingTextView = findViewById(R.id.movie_rating);
        movieDescriptionTextView = findViewById(R.id.movie_description);


        Intent intent = getIntent();
        if (intent != null) {
            String movieTitle = intent.getStringExtra("title");


            movieTitleTextView.setText(movieTitle);


            if (movieTitle != null) {
                switch (movieTitle) {
                    case "Rebel Moon":
                        setMovieDetails(R.drawable.rebelmoon, R.string.movie_rebel_moon_details);
                        break;
                    case "Damsel":
                        setMovieDetails(R.drawable.damsel, R.string.movie_damsel_details);
                        break;
                    case "Migration":
                        setMovieDetails(R.drawable.migration1, R.string.movie_migration_details);
                        break;
                    case "Wish":
                        setMovieDetails(R.drawable.wish, R.string.movie_wish_details);
                        break;
                    case "The BeeKeeper":
                        setMovieDetails(R.drawable.beekeeper, R.string.movie_beekeeper_details);
                        break;
                    case "The Creator":
                        setMovieDetails(R.drawable.creator, R.string.movie_creator_details);
                        break;
                    case "Operation Fortune":
                        setMovieDetails(R.drawable.operationfortune, R.string.movie_operation_fortune_details);
                        break;
                    case "Road House":
                        setMovieDetails(R.drawable.roadhouse, R.string.movie_road_house_details);
                        break;
                    case "Exhuma":
                        setMovieDetails(R.drawable.exhuma, R.string.movie_exhuma_details);
                        break;
                    case "IF":
                        setMovieDetails(R.drawable.ifm, R.string.movie_if_details);
                        break;
                    case "Role Play":
                        setMovieDetails(R.drawable.roleplay, R.string.movie_roleplay_details);
                        break;
                    case "Upgraded":
                        setMovieDetails(R.drawable.upgraded, R.string.movie_upgraded_details);
                        break;
                    default:
                        setMovieDetails(0, R.string.movie_rebel_moon_details); // Placeholder for default image and details
                        break;
                }
            }
        }
    }

    private void setMovieDetails(int posterResId, int detailsResId) {
        Glide.with(this)
                .load(posterResId)
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(moviePosterImageView);


        Glide.with(this)
                .load(posterResId)
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(blurredBackgroundImageView);

       
        movieReleaseDateTextView.setText(getString(detailsResId));

    }
}
