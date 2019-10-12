package com.rishikesh.webservices.GlideService;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rishikesh.webservices.R;

public class GlideActivity extends AppCompatActivity {

    ImageView imageView;

    String url ="http://i.imgur.com/2M7Hasn.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

       imageView = findViewById(R.id.glideimg);

       loadimage(url);
    }

    private void loadimage(String url) {

        Glide.with(this).load(url).into(imageView);
    }
}
