package com.example.marriageanniversary;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.videoactivity);
        videoView = findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);

        videoView.setVideoURI(uri);
        videoView.start();
    }


    @Override
    protected void onPause() {
        super.onPause();

        videoView.pause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        videoView.stopPlayback();
    }
}
