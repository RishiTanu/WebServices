package com.rishikesh.webservices.Basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.rishikesh.webservices.GlideService.GlideActivity;
import com.rishikesh.webservices.PicassoService.PicasoActivity;
import com.rishikesh.webservices.R;
import com.rishikesh.webservices.UniversalImageLoaderService.UniversalActivity;

import com.rishikesh.webservices.fragment.AndroidNetworkingService;
import com.rishikesh.webservices.fragment.AsyntaskService;
import com.rishikesh.webservices.fragment.RetrofitService;
import com.rishikesh.webservices.fragment.VolleyService;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //volley..
        findViewById(R.id.volley).setOnClickListener(this);
        //android Netwoking.
        findViewById(R.id.androidnetworking).setOnClickListener(this);
        //Asyntask
        findViewById(R.id.asyn).setOnClickListener(this);
        //retrofit
        findViewById(R.id.retrofit).setOnClickListener(this);
        //universalmage loader
        findViewById(R.id.universal).setOnClickListener(this);
        //glide
        findViewById(R.id.glide).setOnClickListener(this);
        //picaso
        findViewById(R.id.picaso).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            //Volley...
            case R.id.volley:
                fragment = new VolleyService();
                break;

                //android networking
            case R.id.androidnetworking:
                fragment = new AndroidNetworkingService();
                break;

                //Asyntask
            case R.id.asyn:
                fragment = new AsyntaskService();
                break;

                //retrofit
            case R.id.retrofit:
                fragment = new RetrofitService();
                break;


            //universal
            case R.id.universal:
                startActivity(new Intent(MainActivity.this, UniversalActivity.class));
                break;

                //glide
            case R.id.glide:
                startActivity(new Intent(MainActivity.this, GlideActivity.class));
                break;

                //picasso
            case R.id.picaso:
                startActivity(new Intent(MainActivity.this, PicasoActivity.class));
                break;

        }

        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.popBackStack(fragment.toString(), FragmentManager.POP_BACK_STACK_INCLUSIVE);

            FragmentTransaction tx = fragmentManager.beginTransaction();
            tx.replace(R.id.container, fragment).addToBackStack(fragment.toString());

            tx.commit();
            System.gc();

        } else {
            // error in creating fragment
            Log.e("ImageDataActivity", "Error in creating fragment");
        }
    }
}
