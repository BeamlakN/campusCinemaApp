package com.example.cinema;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MoviePlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoplayer);

        videoView = findViewById(R.id.videoView);

        int videoResource = getIntent().getIntExtra("videoResource", -1);

        if (videoResource != -1) {
            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videoResource);
            videoView.setVideoURI(videoUri);


            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);

            videoView.start();
        }
    }
}
