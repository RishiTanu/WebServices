package com.rishikesh.webservices.Volley;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rishikesh.webservices.Basic.AppUtil;
import com.rishikesh.webservices.Basic.CommonClass;
import com.rishikesh.webservices.R;

public class Readjson_volley extends AppCompatActivity {

    /**
     *
     * Here we read when any API hit on server we receive json data..
     * [
     *   {
     *     "userId": 1,
     *     "id": 1,
     *     "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
     *     "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
     *   }
     *  ] like this...here we read hole json and show in recycler view..
     * @param savedInstanceState
     *
     */

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_hole_json_volley);

        progressBar = findViewById(R.id.prog);
        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(Readjson_volley.this));
        progressBar.setVisibility(View.VISIBLE);
        //Here we receive four key value..and read hole json data..

        String url = "http://jsonplaceholder.typicode.com/posts";
        setApi(url);
    }

    private void setApi(String url)
    {
            final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

            StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Log.d("result", response);
                        if (!response.isEmpty())
                            parsejson(response);
                        else
                            CommonClass.showDialog(Readjson_volley.this,AppUtil.nothing);
                    }catch (Exception x){
                        x.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    CommonClass.showDialog(Readjson_volley.this,AppUtil.worng);
                }
            });
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 2000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            requestQueue.add(stringRequest);
    }

    private void parsejson(String response) {
        try {

            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();

            PostData[] postData = gson.fromJson(response, PostData[].class);
            recyclerView.setAdapter(new GitHubAdapter(Readjson_volley.this, postData));
            progressBar.setVisibility(View.GONE);

        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
