package com.example.cinema;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class WatchListFragment extends Fragment {


        private GridView gridView;
        private CustomAdapter customAdapter;
        private List<MovieDetail> movieList;
        private EditText searchView;

        public WatchListFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_mywatchlist, container, false);

            gridView = view.findViewById(R.id.grid_view_watch);
            searchView = view.findViewById(R.id.search_view);

            movieList = Watchlist.getWatchlist();

            customAdapter = new CustomAdapter(movieList, requireContext());
            gridView.setAdapter(customAdapter);

            searchView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    customAdapter.filter(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });

            return view;
        }

        public void updateWatchList() {
            movieList = Watchlist.getWatchlist();
            customAdapter = new CustomAdapter(movieList, requireContext());
            gridView.setAdapter(customAdapter);
        }
    }


