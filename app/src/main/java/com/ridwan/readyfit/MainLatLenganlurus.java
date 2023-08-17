package com.ridwan.readyfit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainLatLenganlurus extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lat_lenganlurus);

        videoView = findViewById(R.id.video);

        String VideoPath = "android.resource://"+getPackageName()+"/"+R.raw.crunchlenganlurus;
        Uri uri = Uri.parse(VideoPath);
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
        videoView.setVideoURI(uri);
        videoView.start();


    }
}



