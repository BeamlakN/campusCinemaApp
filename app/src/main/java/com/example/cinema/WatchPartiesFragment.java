package com.example.cinema;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WatchPartiesFragment extends Fragment {
    private ListView listViewWatchParties;
    private WatchPartyAdapter watchPartyAdapter;
    private List<WatchParty> watchPartyList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watchparty, container, false);

        listViewWatchParties = view.findViewById(R.id.listViewWatchParties);
        watchPartyList = new ArrayList<>();
        watchPartyAdapter = new WatchPartyAdapter(getContext(), watchPartyList, new WatchPartyAdapter.OnJoinClickListener() {
            @Override
            public void onJoinClick(WatchParty watchParty) {
                if (isShowTime(watchParty)) {
                    Intent intent = new Intent(getContext(), WatchRoomActivity.class);
                    intent.putExtra("videoUrl", watchParty.getVideoUrl());
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "It's not time yet!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        listViewWatchParties.setAdapter(watchPartyAdapter);

        fetchWatchParties();

        return view;
    }

    private void fetchWatchParties() {
        DatabaseReference watchPartiesRef = FirebaseDatabase.getInstance().getReference("watchParties");

        watchPartiesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                watchPartyList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    WatchParty watchParty = snapshot.getValue(WatchParty.class);
                    if (watchParty != null) {
                        watchPartyList.add(watchParty);
                    }
                }
                watchPartyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("WatchPartiesFragment", "Database error: " + databaseError.getMessage());
            }
        });
    }

    private boolean isShowTime(WatchParty watchParty) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String currentDate = sdf.format(new Date());
        return currentDate.equals(watchParty.getDate());
    }
}
