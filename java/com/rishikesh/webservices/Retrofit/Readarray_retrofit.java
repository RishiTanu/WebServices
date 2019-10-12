package com.rishikesh.webservices.Retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.rishikesh.webservices.Basic.CommonClass;
import com.rishikesh.webservices.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Readarray_retrofit extends AppCompatActivity {


    TextView folnane,selecedimg,totolaimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_with_arrayretrofit);

        inisilizeobjects();

        Map<String,String> mp=new HashMap<>();
        mp.put("mono","1111111");
        mp.put("mono","223338");
        mp.put("f_id","45");

        Retrofit retrofit =new  Retrofit.Builder()
                .baseUrl("http://xyz/abc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonplaceholderApi jsonplaceholderApi = retrofit.create(jsonplaceholderApi.class);
        Call<PostObject> call = jsonplaceholderApi.getDataArray(mp);

        call.enqueue(new Callback<PostObject>() {
            @Override
            public void onResponse(Call<PostObject> call, Response<PostObject> response) {
                try {
                    if (response.isSuccessful()) {
                        List<ImagePost> postData = response.body().getSponsors();
                        ImagePost imagePost = postData.get(0);

                        CommonClass.print(imagePost.getFolderName());
                        CommonClass.print(imagePost.getSelectedFile());
                        CommonClass.print(imagePost.getTotalImages());

                        folnane.setText(imagePost.getFolderName());
                        selecedimg.setText(imagePost.getSelectedFile());
                        totolaimage.setText(imagePost.getTotalImages());
                    }
                }catch (Exception x){
                    x.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<PostObject> call, Throwable t) {

                Toast.makeText(Readarray_retrofit.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inisilizeobjects() {

        folnane = findViewById(R.id.folname);
        selecedimg = findViewById(R.id.selimg);
        totolaimage =findViewById(R.id.tolimg);
    }
}
