package com.rishikesh.webservices.AndroidNetworking;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.rishikesh.webservices.Basic.AppUtil;
import com.rishikesh.webservices.Basic.CommonClass;
import com.rishikesh.webservices.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadJsonArray extends AppCompatActivity {

    private TextView first,second,third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_json_array);

        findviewbyid();
        AndroidNetworking.initialize(getApplicationContext());
        String url = "http:xyz.com?mono=777&mono=88&id=45";
        setAPI(url);
    }

    private void setAPI(String url) {

        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        CommonClass.showtoastshort(ReadJsonArray.this, AppUtil.success);
                        try {
                            parsejson(response);
                        }catch (Exception x){
                            x.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                       CommonClass.showtoastshort(ReadJsonArray.this,AppUtil.worng);
                    }
                });
    }

    private void parsejson(JSONObject response) {

        try {
            JSONArray jsonArray = response.getJSONArray("data");
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            first.setText(jsonObject.getString("FolderName"));
            second.setText(jsonObject.getString("TotalImages"));
            third.setText(jsonObject.getString("SelectedFile"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void findviewbyid() {
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
    }
}
