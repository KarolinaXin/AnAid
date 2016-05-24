package com.dheerajpille.anaid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    ImageView mainScreen;
    TranslateAnimation moveLeft, moveRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        mainScreen=(ImageView)findViewById(R.id.mainScreen);
        TouchAndDrag test = new TouchAndDrag();
        mainScreen.setOnTouchListener(test);
    }

    public void onClickReport(View v) {
        Intent rep = new Intent(MainActivity.this, reportActivity.class);
        startActivity(rep);
    }

    public void onClickAniDex(View v) {
        Intent aniD = new Intent(MainActivity.this, anidexActivity.class);
        startActivity(aniD);
    }

    public class TouchAndDrag extends Activity implements OnTouchListener {
        float change = 0.0f;
        boolean moving = false;
        float start = 0.0f;

        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            switch (arg1.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    moving = true;
                    start = arg1.getRawX();
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (moving) {
                        change = start - arg1.getRawX();
                        if (change > 0)
                            mainScreen.setX(mainScreen.getX() - change);
                        else {
                            if (mainScreen.getX() - change <= 0)
                                mainScreen.setX(mainScreen.getX() - change);
                        }
                        start = arg1.getRawX();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    moving = false;
                    moveLeft = new TranslateAnimation(0.0f, -(mainScreen.getX()+mainScreen.getWidth()), 0.0f, 0.0f);
                    moveRight = new TranslateAnimation(0.0f, -(mainScreen.getX()), 0.0f, 0.0f);

                    moveLeft.setDuration(1000);
                    /*moveLeft.setFillEnabled(true);
                    moveLeft.setFillBefore(false);*/
                    moveLeft.setFillAfter(true);

                    moveRight.setDuration(1000);
                    /*moveRight.setFillEnabled(true);
                    moveRight.setFillBefore(false);*/
                    moveRight.setFillAfter(true);

                    if (mainScreen.getX() <= -mainScreen.getWidth()/2) {
                        Log.d("CREATION", "Left");
                        mainScreen.startAnimation(moveLeft);
                    }
                    else
                        Log.d("CREATION", "Right");
                        mainScreen.startAnimation(moveRight);

                    break;
            }
            return true;
        }
    }
}

//https://www.youtube.com/watch?v=XwOuTjUFexE