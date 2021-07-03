package com.example.leafrecognition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashActivity extends AppCompatActivity {
    Animation uptodown, downtoup;
    LinearLayout top_lay, bottom_lay;
    SharedPref sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        top_lay = (LinearLayout) findViewById(R.id.top_lay);
        bottom_lay = (LinearLayout) findViewById(R.id.bottom_lay);
        sharedPref = new SharedPref(this);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        top_lay.setAnimation(uptodown);
        bottom_lay.setAnimation(downtoup);
        uptodown.start();
        downtoup.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPref.getLoginStep().equals(LoginStep.welcome.toString()))
                    startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
                else if (sharedPref.getLoginStep().equals(LoginStep.login.toString()))
                    startActivity(new Intent(SplashActivity.this, StartActivity.class));
                else
                    startActivity(new Intent(SplashActivity.this, LandingActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();

            }
        }, 4000);
    }
}