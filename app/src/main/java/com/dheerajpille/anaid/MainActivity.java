package com.dheerajpille.anaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickReport(View v) {
        Intent rep = new Intent(MainActivity.this, reportActivity.class);
        startActivity(rep);
    }

    public void onClickAniDex(View v) {
        Intent aniD = new Intent(MainActivity.this, anidexActivity.class);
        startActivity(aniD);
    }
}
