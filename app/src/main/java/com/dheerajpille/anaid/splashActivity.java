package com.dheerajpille.anaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final ImageView splashPic = (ImageView)findViewById(R.id.splashPic);

        final Animation anim1 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.splash_anim);
        final Animation anim2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);

        splashPic.startAnimation(anim1);

        anim1.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation){

            }

            @Override
            public void onAnimationEnd(Animation animation){
                splashPic.startAnimation(anim2);
                finish();
                Intent main = new Intent(getBaseContext(), MainActivity.class);
                startActivity(main);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation){

            }
        });
    }
}
