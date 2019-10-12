package com.rishikesh.webservices.AndroidNetworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.rishikesh.webservices.Basic.AppUtil;
import com.rishikesh.webservices.Basic.CommonClass;
import com.rishikesh.webservices.R;

import org.json.JSONObject;

public class GetRequest extends AppCompatActivity {

    TextView bokid,disnumber,studioname,studiopassword;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_request);

        findviewbyid(); //inisilize objects
        String url = "http:xyz.com?MobileNo=11111111&Password=123";

        AndroidNetworking.initialize(getApplicationContext());
        callwebservice(url);
    }

    private void callwebservice(String url) {

        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        CommonClass.showtoastshort(GetRequest.this,AppUtil.success);
                        parsejson(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        CommonClass.showtoastshort(GetRequest.this, AppUtil.worng);
                    }
                });
    }

    private void parsejson(JSONObject response) {

        try{
            CommonClass.showtoastshort(GetRequest.this,AppUtil.success);

        }catch (Exception x){
            x.printStackTrace();
        }

    }

    private void findviewbyid() {

        bokid = findViewById(R.id.bid);
        disnumber = findViewById(R.id.dismbno);
        imageView = findViewById(R.id.bpage);

        studioname = findViewById(R.id.stdname);
        studiopassword = findViewById(R.id.stdpassword);
    }
}
