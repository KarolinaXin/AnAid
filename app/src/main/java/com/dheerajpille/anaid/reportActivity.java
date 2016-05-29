package com.dheerajpille.anaid;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class ReportActivity extends AppCompatActivity {

    Button captureButton, submitButton;
    ImageView captureImage;
    private static final int CAMERA_REQUEST = 1313;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        captureButton = (Button)findViewById(R.id.capture);
        captureImage = (ImageView)findViewById(R.id.captureImage);
        submitButton = (Button)findViewById(R.id.submit);

        RelativeLayout reportScreen = (RelativeLayout) findViewById(R.id.reportScreen);

        reportScreen.setOnTouchListener(new OnSwipeTouchListener(ReportActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(ReportActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
            public void onSwipeLeft() {
                Toast.makeText(ReportActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(ReportActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }
        });

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement submit feature here.
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap)data.getExtras().get("data");
            captureImage.setImageBitmap(photo);

        }
    }
}