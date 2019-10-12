package com.rishikesh.webservices.Retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rishikesh.webservices.Basic.AppUtil;
import com.rishikesh.webservices.Basic.CommonClass;
import com.rishikesh.webservices.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReadJson_retrofit extends AppCompatActivity {

    TextView textView[] = new TextView[4];
    int id[] = {R.id.userid,R.id.id,R.id.body,R.id.title};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_hole_jsonretrofit);

        inisilizeobjects();

       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("http://jsonplaceholder.typicode.com/") //here we mention baseUrl.....
               .addConverterFactory(GsonConverterFactory.create())
               .build();

       jsonplaceholderApi jsonplaceholderApi = retrofit.create(jsonplaceholderApi.class);
       Call<List<Post>> call = jsonplaceholderApi.getPost();

       call.enqueue(new Callback<List<Post>>() {
           @Override
           public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

               if(response.isSuccessful())
               {
                   CommonClass.showtoastshort(ReadJson_retrofit.this,AppUtil.success);

                   Post post = response.body().get(0);
                   textView[0].setText(post.getTitle());
                   textView[1].setText(post.getId());
                   textView[2].setText(post.getBody());
                   textView[3].setText(post.getUserId());
               }
           }
           @Override
           public void onFailure(Call<List<Post>> call, Throwable t) {
             CommonClass.showtoastshort(ReadJson_retrofit.this,AppUtil.nothing);
           }
       });


    }

    private void inisilizeobjects() {
        for(int i=0; i<textView.length; i++)
            textView[i]= findViewById(id[i]);
    }
}
