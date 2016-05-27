package com.dheerajpille.anaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AnidexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anidex);
        RelativeLayout anidexScreen = (RelativeLayout)findViewById(R.id.anidexScreen);
        anidexScreen.setOnTouchListener(new OnSwipeTouchListener(AnidexActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(AnidexActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(AnidexActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
            public void onSwipeBottom() {
                Toast.makeText(AnidexActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }
        });
    }
}