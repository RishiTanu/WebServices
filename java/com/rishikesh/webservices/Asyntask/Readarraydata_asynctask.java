package com.rishikesh.webservices.Asyntask;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.rishikesh.webservices.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Readarraydata_asynctask extends AppCompatActivity {


    ProgressDialog progressDialog;
    TextView folname,totalimg,selectedimg;

    private static final String TAG = "Readarraydata_asynctask";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityread_witharrayasyntask);

        String studio_mono = "11111111";
        String customer_mono = "11118";
        String function_id = "45";

        String url = "xyz.com/folder?studio_mono="+studio_mono+"&customer_mono="+customer_mono+"&function_id="+function_id+"";
        new MyTaskArray().execute(url);

    }

    @SuppressLint("StaticFieldLeak")
    public class MyTaskArray extends AsyncTask<String,String,String>
    {

        @Override
        protected void onPreExecute() {

            progressDialog =  ProgressDialog.show(Readarraydata_asynctask.this,"Download","wait for "+5+" minutes");
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(1500000);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.connect();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
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
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String data) {
            super.onPostExecute(data);

            try {
                JSONObject jsonObject = new JSONObject(data);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                JSONObject jsonObject1 = jsonArray.getJSONObject(0);

                folname.setText(jsonObject1.getString("FolderName"));
                totalimg.setText(jsonObject1.getString("TotalImages"));
                selectedimg.setText(jsonObject1.getString("SelectedFile"));


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
