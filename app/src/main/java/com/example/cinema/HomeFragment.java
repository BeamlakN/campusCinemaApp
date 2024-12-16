package com.example.cinema;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView sliderRecyclerView;
    private RecyclerView bestMoviesRecyclerView;
    private RecyclerView upcomingMoviesRecyclerView;

    private SliderAdapter sliderAdapter;
    private BestMoviesAdapter bestMoviesAdapter;
    private UpcomingMoviesAdapter upcomingMoviesAdapter;

    private List<MovieDetail> sliderMoviesList;
    private List<MovieDetail> bestMoviesList;
    private List<MovieDetail> upcomingMoviesList;

    private EditText searchEditText;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderRecyclerView = view.findViewById(R.id.slider_recycler_view);
        bestMoviesRecyclerView = view.findViewById(R.id.best_movies_recycler_view);
        upcomingMoviesRecyclerView = view.findViewById(R.id.upcoming_movies_recycler_view);
        searchEditText = view.findViewById(R.id.searchEditText);


        sliderRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        bestMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        upcomingMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        sliderMoviesList = new ArrayList<>();
        bestMoviesList = new ArrayList<>();
        upcomingMoviesList = new ArrayList<>();


        sliderMoviesList.add(new MovieDetail(R.drawable.avatar, "Avatar: The Way of Water", "120 min"));
        sliderMoviesList.add(new MovieDetail(R.drawable.ifimage, "IF", "120 min"));
        sliderMoviesList.add(new MovieDetail(R.drawable.furiosa2, "Furiosa: Mad Max Saga", "110 min"));
        sliderMoviesList.add(new MovieDetail(R.drawable.thecreator, "The Creator", "130 min"));

        bestMoviesList.add(new MovieDetail(R.drawable.creator, "The Creator", "120 min"));
        bestMoviesList.add(new MovieDetail(R.drawable.wish, "Wish", "110 min"));
        bestMoviesList.add(new MovieDetail(R.drawable.ifm, "IF", "130 min"));
        bestMoviesList.add(new MovieDetail(R.drawable.exhuma, "Exhuma", "110 min"));
        bestMoviesList.add(new MovieDetail(R.drawable.damsel, "Damsel", "130 min"));

        upcomingMoviesList.add(new MovieDetail(R.drawable.rebelmoon, "Rebel Moon", "135 min"));
        upcomingMoviesList.add(new MovieDetail(R.drawable.roleplay, "Role Play", "140 min"));
        upcomingMoviesList.add(new MovieDetail(R.drawable.upgraded, "Upgraded", "150 min"));
        upcomingMoviesList.add(new MovieDetail(R.drawable.roadhouse, "Road House", "140 min"));
        upcomingMoviesList.add(new MovieDetail(R.drawable.operationfortune, "Operation Fortune", "150 min"));



        sliderAdapter = new SliderAdapter(sliderMoviesList);
        bestMoviesAdapter = new BestMoviesAdapter(bestMoviesList, getContext());
        upcomingMoviesAdapter = new UpcomingMoviesAdapter(upcomingMoviesList, getContext());


        sliderRecyclerView.setAdapter(sliderAdapter);
        bestMoviesRecyclerView.setAdapter(bestMoviesAdapter);
        upcomingMoviesRecyclerView.setAdapter(upcomingMoviesAdapter);

        setupSearchFunctionality();

        return view;
    }

    private void setupSearchFunctionality() {
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String query = charSequence.toString().toLowerCase().trim();


                List<MovieDetail> filteredBestMovies = filterList(bestMoviesList, query);
                bestMoviesAdapter.filterList(filteredBestMovies);

               
                List<MovieDetail> filteredUpcomingMovies = filterList(upcomingMoviesList, query);
                upcomingMoviesAdapter.filterList(filteredUpcomingMovies);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private List<MovieDetail> filterList(List<MovieDetail> originalList, String query) {
        List<MovieDetail> filteredList = new ArrayList<>();
        for (MovieDetail movie : originalList) {
            if (movie.getMovieName().toLowerCase().contains(query)) {
                filteredList.add(movie);
            }
        }
        return filteredList;
    }
}

