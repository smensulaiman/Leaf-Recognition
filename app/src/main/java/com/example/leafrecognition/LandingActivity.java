package com.example.leafrecognition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.leafrecognition.R;

public class LandingActivity extends AppCompatActivity {

    CardView object_detect;
    CardView dataset;
    CardView settings;
    CardView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        object_detect = (CardView) findViewById(R.id.object_detect);
        dataset = (CardView) findViewById(R.id.dataset);
        settings = (CardView) findViewById(R.id.settings);
        profile = (CardView) findViewById(R.id.profile);

        object_detect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, MainActivity.class));
            }
        });
        dataset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, DatasetActivity.class));
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, SettingsActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, ProfileActivity.class));
            }
        });

    }
}