package com.rishikesh.webservices.PicassoService;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.rishikesh.webservices.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class PicasoActivity extends AppCompatActivity {

    ImageView imageView;

    String url ="http://i.imgur.com/2M7Hasn.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picaso);

         imageView = findViewById(R.id.picassoimg);
         loadimage(url);
    }

    private void loadimage(String url) {

        Picasso.with(this).load(url).into(imageView);
    }
}
