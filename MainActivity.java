package com.example.swipevideoapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        final ViewPager2 videoViewPager = findViewById(R.id.videoViewPager);

        List<VideoItem> videoItems = new ArrayList<>();

        VideoItem videoBG3 = new VideoItem();
        videoBG3.vidURL = "https://firebasestorage.googleapis.com/v0/b/fir-case-d128a.appspot.com/o/Oh.mp4?alt=media&token=0c5562f3-ff1c-4722-86d4-fb738fba3ce6";
        videoBG3.vidTitle = "Baldur's Gate 3 with Friends";
        videoBG3.vidDescription = "Just throwing a huge explosive on a Dragon and some tentacles, what's new with you?";

        videoItems.add(videoBG3);

        VideoItem reFantazio = new VideoItem();
        reFantazio.vidURL = "https://firebasestorage.googleapis.com/v0/b/fir-case-d128a.appspot.com/o/Comforting%20Library.mp4?alt=media&token=bc414c9b-5a03-4bae-b141-dd89f8739315";
        reFantazio.vidTitle = "Calming Library";
        reFantazio.vidDescription = "reFantazio by ATLUS";

        videoItems.add(reFantazio);

        VideoItem league = new VideoItem();
        league.vidURL = "https://firebasestorage.googleapis.com/v0/b/fir-case-d128a.appspot.com/o/Comforting%20Library.mp4?alt=media&token=bc414c9b-5a03-4bae-b141-dd89f8739315";
        league.vidTitle = "Wait for it. . .";
        league.vidDescription = "Just wait for it. . .";

        videoItems.add(reFantazio);

        videoViewPager.setAdapter(new VideoAdapter(videoItems));

    }
}