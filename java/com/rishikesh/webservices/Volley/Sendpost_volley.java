package com.rishikesh.webservices.Volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rishikesh.webservices.Basic.AppUtil;
import com.rishikesh.webservices.Basic.CommonClass;
import com.rishikesh.webservices.R;

import java.util.HashMap;
import java.util.Map;

public class Sendpost_volley extends AppCompatActivity {


    //Here we see how we implement post request in Volley..
    private ProgressBar progressBar;

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senddata_withapi__postrequest_volley);

        progressBar = findViewById(R.id.prog);
        progressBar.setVisibility(View.VISIBLE);
        img = findViewById(R.id.img);

        String url = "http://i.imgur.com/2M7Hasn.png";
        setApi(url);
    }

    public void setApi(String url)
    {
        RequestQueue requestQueue;
        requestQueue =  Volley.newRequestQueue(getApplicationContext());
        progressBar.setVisibility(View.GONE);

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

                CommonClass.showtoastshort(Sendpost_volley.this,"Success");
                img.setImageBitmap(response);
            }
        }, 0,
                0,
                ImageView.ScaleType.CENTER_CROP,
                Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        CommonClass.showtoastshort(Sendpost_volley.this,"unSuccess");
                    }
                });

        requestQueue.add(imageRequest);

    }
}
