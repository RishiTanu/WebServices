package com.rishikesh.webservices.AndroidNetworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rishikesh.webservices.Basic.AppUtil;
import com.rishikesh.webservices.Basic.CommonClass;
import com.rishikesh.webservices.R;
import com.rishikesh.webservices.Retrofit.PostBike;
import com.rishikesh.webservices.Volley.PostVolleyAdapter;

import org.json.JSONException;
import org.json.JSONObject;

public class PostRequest extends AppCompatActivity {

   private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);

            recyclerView = findViewById(R.id.recycle);
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        AndroidNetworking.initialize(getApplicationContext());

        String url = "http://xyz/yy.php";
        setapi(url);
    }

    private void setapi(String url) {

        JSONObject putdata = new JSONObject();
        try {
            putdata.put("id","1");
            putdata.put("password","Bike");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(url)
                .addJSONObjectBody(putdata)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        CommonClass.showtoastshort(PostRequest.this, AppUtil.success);
                        parsejson(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                      CommonClass.showtoastshort(PostRequest.this,AppUtil.worng);
                    }
                });

    }

    private void parsejson(JSONObject response) {

        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            PostBike[] postBike = gson.fromJson(response.toString(), PostBike[].class);
            recyclerView.setAdapter(new PostAdapter(PostRequest.this, postBike));
        }catch (Exception x){
            x.printStackTrace();
        }
    }
}
