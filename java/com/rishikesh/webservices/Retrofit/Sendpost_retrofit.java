package com.rishikesh.webservices.Retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rishikesh.webservices.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sendpost_retrofit extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;

    private static final String TAG = "Sendpost_retrofit";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysenddata_withapipost);

        inisilizeobjects();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://zzz/posts/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Map<String,String> mp = new HashMap<>();
        mp.put("cityfid","1");
        mp.put("vechicle","Bike");

        jsonplaceholderApi jsonplaceholderApi= retrofit.create(jsonplaceholderApi.class);
        Call<List<PostBike>> call = jsonplaceholderApi.getPostData(mp);

        call.enqueue(new Callback<List<PostBike>>() {
            @Override
            public void onResponse(Call<List<PostBike>> call, Response<List<PostBike>> response) {

                if(response.isSuccessful()) {
                    Toast.makeText(Sendpost_retrofit.this, "Successfull", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onResponse: "+response.body());
                    List<PostBike> postBikes = response.body();
                    recyclerView.setAdapter(new BikeAdapters(Sendpost_retrofit.this,postBikes));
                }
            }

            @Override
            public void onFailure(Call<List<PostBike>> call, Throwable t) {

                Toast.makeText(Sendpost_retrofit.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inisilizeobjects() {

        recyclerView = findViewById(R.id.recycle);
        progressBar = findViewById(R.id.prog);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

}

