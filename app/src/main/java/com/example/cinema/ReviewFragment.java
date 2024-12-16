package com.example.cinema;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ReviewFragment extends Fragment {

    private ImageView movieImage;
    private ListView reviewsList;
    private EditText editReview;
    private Button btnSend;

    private List<Review> reviews;
    private ReviewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review, container, false);

        movieImage = view.findViewById(R.id.movie_image);
        reviewsList = view.findViewById(R.id.reviews_list);
        editReview = view.findViewById(R.id.edit_review);
        btnSend = view.findViewById(R.id.btn_send);


        movieImage.setImageResource(R.drawable.ifm);

        reviews = new ArrayList<>();
        adapter = new ReviewAdapter(getContext(), reviews);
        reviewsList.setAdapter(adapter);

        reviews.add(new Review("Yonatan", "Amazing movie! Highly recommend.", "2024-07-01"));
        reviews.add(new Review("Beimnet", "Not bad, but could be better.", "2024-06-30"));
        adapter.notifyDataSetChanged();


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reviewText = editReview.getText().toString().trim();
                if (!reviewText.isEmpty()) {
                    String reviewerName = "beamlak";
                    String reviewDate = "Now";
                    Review newReview = new Review(reviewerName, reviewText, reviewDate);
                    reviews.add(0, newReview);
                    adapter.notifyDataSetChanged();
                    editReview.setText("");
                }
            }
        });

        return view;
    }
}
