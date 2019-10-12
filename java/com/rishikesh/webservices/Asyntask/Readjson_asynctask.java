package com.rishikesh.webservices.Asyntask;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rishikesh.webservices.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Readjson_asynctask extends AppCompatActivity {

    ProgressDialog progressDialog;
    TextView id,userid,title,body;

    private static final String TAG = "Readjson_asynctask";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityread_holejsonasyntask);

        new MyTask().execute("http://jsonplaceholder.typicode.com/posts");
        inisilzeobjects();
    }


    @SuppressLint("StaticFieldLeak")
    public class MyTask extends AsyncTask<String,String,String>
    {

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(Readjson_asynctask.this,"Downloading Continue ","wait for "+5+" seconds");

        }

        @Override
        protected String doInBackground(String... strings) {

            BufferedReader bufferedReader = null;
            try {
                Thread.sleep(3000);
                progressDialog.dismiss();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();

                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                Log.d(TAG, "doInBackground: "+bufferedReader.readLine());

                return bufferedReader.readLine();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
           return null;
        }


        @Override
        protected void onPostExecute(String reasult) {
            super.onPostExecute(reasult);

            try {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                DataModel[] dataModel = gson.fromJson(reasult, DataModel[].class);

                Log.d(TAG, "onPostExecute: "+dataModel.toString());

                DataModel dataModel1 = dataModel[0];
                id.setText(dataModel1.getId());
                userid.setText(dataModel1.getUserid());
                title.setText(dataModel1.getTitle());
                body.setText(dataModel1.getBody());


            }catch (Exception x){
                x.printStackTrace();
            }
        }

    }
    private void inisilzeobjects() {

        id = findViewById(R.id.id);
        userid = findViewById(R.id.userid);
        title = findViewById(R.id.title);
        body = findViewById(R.id.body);

    }
}
