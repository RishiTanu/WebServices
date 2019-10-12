package com.rishikesh.webservices.AndroidNetworking;

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

import org.json.JSONObject;

public class ReadHoleJson extends AppCompatActivity {

//    [
//    {
//        "userId": 1,
//            "id": 1,
//            "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//            "body": "quia et suscipit\nsuscipit tam\nnostrum rerum est autem sunt rem eveniet architecto"
//    }]
    TextView id ,userid,title,body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_hole_json);

        findviewbyid();
        AndroidNetworking.initialize(getApplicationContext());
        String url = "http://jsonplaceholder.typicode.com/posts";
        setApi(url);
    }

    private void setApi(String url) {

        AndroidNetworking.get(url)
                .addHeaders("setApi")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                       // CommonClass.print(response.toString());
                        CommonClass.showtoastshort(ReadHoleJson.this, AppUtil.success);
                        parsejson(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        //CommonClass.print(anError.getMessage());
                      CommonClass.showtoastshort(ReadHoleJson.this,AppUtil.worng);
                    }
                });
    }

    private void parsejson(JSONObject response) {
        try{

            CommonClass.showtoastshort(ReadHoleJson.this,AppUtil.success);
        }catch (Exception x){
            x.printStackTrace();
        }
    }

    private void findviewbyid() {

        id = findViewById(R.id.id);
        userid = findViewById(R.id.userid);
        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
    }
}
