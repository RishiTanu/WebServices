package com.rishikesh.webservices.Retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.rishikesh.webservices.Basic.AppUtil;
import com.rishikesh.webservices.Basic.CommonClass;
import com.rishikesh.webservices.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sendgetrequest_retrofit extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private static final String TAG = "Sendgetrequest_retrofit";
    //send here post request.. with retrofit..
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senddata_retrofitget);

       inisilize();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://xyz/ab.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        jsonplaceholderApi jsonplaceholderApi = retrofit.create(jsonplaceholderApi.class);
        Call<List<CityData>> call = jsonplaceholderApi.getCitydata();

        call.enqueue(new Callback<List<CityData>>() {
            @Override
            public void onResponse(Call<List<CityData>> call, Response<List<CityData>> response) {

                if(response.isSuccessful())
                {
                    CommonClass.showtoastshort(Sendgetrequest_retrofit.this, AppUtil.success);
                    Log.d(TAG, "onResponse: "+response.body());
                    List<CityData> cityData = response.body();
                    recyclerView.setAdapter(new CityAdapters(Sendgetrequest_retrofit.this,cityData));
                }
            }

            @Override
            public void onFailure(Call<List<CityData>> call, Throwable t) {
                CommonClass.showtoastshort(Sendgetrequest_retrofit.this, AppUtil.worng);
            }
        });
    }

    private void inisilize() {

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        progressBar = findViewById(R.id.prog);
    }
}
