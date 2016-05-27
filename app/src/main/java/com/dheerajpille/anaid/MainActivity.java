package com.dheerajpille.anaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button reportButton, anidexButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout homeScreen = (RelativeLayout) findViewById(R.id.homeScreen);
        homeScreen.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Intent aniD = new Intent(MainActivity.this,AnidexActivity.class);
                startActivity(aniD);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
            public void onSwipeLeft() {
                Intent rep = new Intent(MainActivity.this,ReportActivity.class);
                startActivity(rep);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }
        });

        reportButton = (Button)findViewById(R.id.report);
        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rep = new Intent(MainActivity.this,ReportActivity.class);
                startActivity(rep);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        anidexButton = (Button)findViewById(R.id.anidex);
        anidexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aniD = new Intent(MainActivity.this,AnidexActivity.class);
                startActivity(aniD);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }


}

//https://www.youtube.com/watch?v=XwOuTjUFexE