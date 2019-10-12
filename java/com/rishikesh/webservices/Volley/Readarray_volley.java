package com.rishikesh.webservices.Volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rishikesh.webservices.Basic.AppUtil;
import com.rishikesh.webservices.Basic.CommonClass;
import com.rishikesh.webservices.R;
import com.rishikesh.webservices.Retrofit.Readarray_retrofit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Readarray_volley extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_with_array_volley);

        //Here we get data JSanArray ... in result response..
        String url = "http://abc/select?mono=11233222&custmono=23233&funid=45";
        setApi(url);
    }

    private void setApi(String url)
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                CommonClass.showtoastshort(Readarray_volley.this,"Success");
//                parseArray(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                CommonClass.showtoastshort(Readarray_volley.this,"UnSuccess");
//            }
//        });

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    CommonClass.print(response);
                    if(!response.isEmpty())
                        parsejson(response);
                    else
                        CommonClass.showtoastshort(Readarray_volley.this, AppUtil.nothing);

                }catch (Exception x){
                    CommonClass.showtoastshort(Readarray_volley.this, AppUtil.worng);
                    x.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CommonClass.showtoastshort(Readarray_volley.this, AppUtil.worng);
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 2000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);
    }

//    private void parseArray(JSONArray response) {
//
//        try {
//
//            CommonClass.showtoastshort(Readarray_volley.this,AppUtil.success);
//
//           // JSONArray jsonArray = response.getJSONObject(0) //here we get JSon array
//            JSONObject jsonrow = response.getJSONObject(0); //here we receive 0 index json Object data...
//
//
//            TextView folderName, totalImage, selectedImage;
//            folderName = findViewById(R.id.folname);
//            totalImage = findViewById(R.id.tvimg);
//            selectedImage = findViewById(R.id.selectimg);
//
//            folderName.setText(jsonrow.getString("FolderName"));
//            totalImage.setText(jsonrow.getString("TotalImages"));
//            selectedImage.setText(jsonrow.getString("SelectedFile"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

    private void parsejson(String response) {
        try {

            CommonClass.showtoastshort(Readarray_volley.this,AppUtil.success);

            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("data"); //here we get JSon array
            JSONObject jsonrow = jsonArray.getJSONObject(0); //here we receive 0 index json Object data...


            TextView folderName, totalImage, selectedImage;
            folderName = findViewById(R.id.folname);
            totalImage = findViewById(R.id.tvimg);
            selectedImage = findViewById(R.id.selectimg);

            folderName.setText(jsonrow.getString("FolderName"));
            totalImage.setText(jsonrow.getString("TotalImages"));
            selectedImage.setText(jsonrow.getString("SelectedFile"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
