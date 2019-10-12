package com.rishikesh.webservices.UniversalImageLoaderService;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.rishikesh.webservices.Basic.UniversalImageLoader;
import com.rishikesh.webservices.R;

public class UniversalActivity extends AppCompatActivity {

    ImageView imageView;

    String url ="http://i.imgur.com/2M7Hasn.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universal);

        imageView = findViewById(R.id.universalimg);
        UniversalImageLoader.universalsetup(this);


        final ImageLoader imageLoader = ImageLoader.getInstance();

        int defaultImage = this.getResources().getIdentifier("drawable/ic_home_black_24dp",null,getPackageName());

        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .showImageOnLoading(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageForEmptyUri(defaultImage)
                .build();

             imageLoader.displayImage(url, imageView,displayImageOptions, new ImageLoadingListener() {
                 @Override
                 public void onLoadingStarted(String imageUri, View view) {
                     imageView.setImageResource(R.drawable.ic_launcher_background);
                 }

                 @Override
                 public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                     imageView.setImageResource(R.drawable.ic_launcher_background);
                 }

                 @Override
                 public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                 }

                 @Override
                 public void onLoadingCancelled(String imageUri, View view) {
                   imageView.setImageResource(R.drawable.ic_launcher_background);
                 }
             });
    }
}
