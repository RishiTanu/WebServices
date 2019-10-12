package com.rishikesh.webservices.Volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rishikesh.webservices.Basic.AppUtil;
import com.rishikesh.webservices.Basic.CommonClass;
import com.rishikesh.webservices.R;
import com.rishikesh.webservices.Retrofit.Sendgetrequest_retrofit;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class Sendget_request extends AppCompatActivity {

    private static final String TAG = "Sendget_request";
    private TextView textView[] = new TextView[8];
    private int id[] = {R.id.bid,R.id.bokdate,R.id.dismbno,R.id.stdmbno,R.id.pass,R.id.disitle,R.id.stdpassword,R.id.stdname};
    private ImageView front,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysenddata_withapi_volleyget);

        for(int i=0; i<textView.length; i++)
            textView[i]= findViewById(id[i]);

        front = findViewById(R.id.fpage);
        back = findViewById(R.id.bpage);

        String url = "http://xyz.com?Studio=7869956676&Password=123";
        setApi(url);

    }

    private void setApi(String url)
    {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                String newResponce = response.replace("[", "").replace("]", "");
                String[] gg = newResponce.split(Pattern.quote("}"));

                String g = "";
                for (int i = 0; i < gg.length - 1; i++) {
                    g += gg[i];
                    g += "}";
                }
                String FinalResponce = "["+g+"]";
                CommonClass.print(FinalResponce);

                if(!response.isEmpty())
                    parsejson(FinalResponce);
                else
                    CommonClass.showtoastshort(Sendget_request.this,AppUtil.worng);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CommonClass.showtoastshort(Sendget_request.this,AppUtil.worng);
            }
        });

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 2000,0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);
    }

    private void parsejson(String response) {

        try {
              CommonClass.showtoastshort(Sendget_request.this,AppUtil.success);

                JSONObject jsonObject = new JSONObject(response);
                String bokid = jsonObject.getString("BookingId");
                textView[0].setText(bokid);
                textView[1].setText(jsonObject.getString("BookingDate"));
                textView[2].setText(jsonObject.getString("DistributorMbNo"));
                textView[3].setText(jsonObject.getString("StudioMbNo"));
                textView[4].setText(jsonObject.getString("password"));
                textView[5].setText(jsonObject.getString("DisplayTitle"));
                textView[6].setText(jsonObject.getString("StudioPassword"));
                textView[7].setText(jsonObject.getString("StudioName"));

                Picasso.with(Sendget_request.this).load(jsonObject.getString("http://43.240.65.33/EbookData/NDPData/AE20P481940/01-0[High Gloss].jpg"))
                        .into(front);

                Picasso.with(Sendget_request.this).load(jsonObject.getString("http://43.240.65.33/EbookData/NDPData/AE20P481940/01-0[High Gloss].jpg"))
                        .into(back);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

//    private void setWebService(String url) {
//        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url, null,
//                new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
//
//               CommonClass.showtoastshort(Sendget_request.this,"Success");
//              parjsonObject(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                CommonClass.showtoastshort(Sendget_request.this,"unSuccess");
//            }
//        });
//
//        requestQueue.add(jsonObjectRequest);
//    }

//    private void parjsonObject(JSONObject jsonObject) {
//
//        try {
//            String bokid = jsonObject.getString("BookingId");
//            textView[0].setText(bokid);
//            textView[1].setText(jsonObject.getString("BookingDate"));
//            textView[2].setText(jsonObject.getString("DistributorMbNo"));
//            textView[3].setText(jsonObject.getString("StudioMbNo"));
//            textView[4].setText(jsonObject.getString("password"));
//            textView[5].setText(jsonObject.getString("DisplayTitle"));
//            textView[6].setText(jsonObject.getString("StudioPassword"));
//            textView[7].setText(jsonObject.getString("StudioName"));
//
//            Picasso.with(Sendget_request.this).load(jsonObject.getString("http://43.240.65.33/EbookData/NDPData/AE20P481940/01-0[High Gloss].jpg"))
//                    .into(front);
//
//            Picasso.with(Sendget_request.this).load(jsonObject.getString("http://43.240.65.33/EbookData/NDPData/AE20P481940/01-0[High Gloss].jpg"))
//                    .into(back);
//        }catch (Exception x){
//            x.printStackTrace();
//        }
//    }
}
