package com.example.cinema;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WatchPartyActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_watchparty);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        storeWatchParties();
    }

    private void storeWatchParties() {
        WatchParty watchParty1 = new WatchParty("rebelmoon", "7:00 PM", "2024-12-22", "150 mins");
        WatchParty watchParty2 = new WatchParty("damsel", "8:30 PM", "2024-12-23", "120 mins");
        WatchParty watchParty3 = new WatchParty("ifm", "5:30 PM", "2024-8-02", "130 mins");
        WatchParty watchParty4 = new WatchParty("roleplay", "3:00 PM", "2024-11-12", "110 mins");



        mDatabase.child("watchParties").child("watchParty1").setValue(watchParty1);
        mDatabase.child("watchParties").child("watchParty2").setValue(watchParty2);

        mDatabase.child("watchParties").child("watchParty3").setValue(watchParty3);
        mDatabase.child("watchParties").child("watchParty4").setValue(watchParty4);


    }
}
