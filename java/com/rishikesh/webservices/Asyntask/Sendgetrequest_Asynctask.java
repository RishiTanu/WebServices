package com.rishikesh.webservices.Asyntask;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rishikesh.webservices.R;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Sendgetrequest_Asynctask extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private TextView textView[] = new TextView[8];
    private int id[] = {R.id.bid,R.id.bokdate,R.id.dismbno,R.id.stdmbno,R.id.pass,R.id.disitle,R.id.stdpassword,R.id.stdname};
   private ImageView front,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_dataapiget_withasyntask);

        findviewByid();

        String url = "xyz.aspx?StudioNo=11111&Password=123";
        new MyTaskAsynTask().execute(url);

    }

    private void findviewByid() {

        front = findViewById(R.id.fpage);
        back = findViewById(R.id.bpage);

        for(int i=0;i<textView.length;i++){
            textView[i]=findViewById(id[i]);
        }
    }
    @SuppressLint("StaticFieldLeak")
    public class MyTaskAsynTask extends AsyncTask<String,String,String>
    {
        @Override
        protected void onPreExecute() {

            progressDialog = ProgressDialog.show(Sendgetrequest_Asynctask.this,"Download","wait for "+5+"seconds");
        }

        @Override
        protected String doInBackground(String... params) {


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
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

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                DotNetModel[] dotNetModel = gson.fromJson(data, DotNetModel[].class);

                DotNetModel dotNetModel1 = dotNetModel[0];
                textView[0].setText(dotNetModel1.getBookingId());
                textView[1].setText(dotNetModel1.getBookingDate());
                textView[2].setText(dotNetModel1.getDistributorMbNo());
                textView[3].setText(dotNetModel1.getDisplayTitle());
                textView[4].setText(dotNetModel1.getPassword());
                textView[5].setText(dotNetModel1.getStudioMbNo());
                textView[6].setText(dotNetModel1.getStudioPassword());
                textView[7].setText(dotNetModel1.getBookingDate());

                Picasso.with(Sendgetrequest_Asynctask.this).load(dotNetModel1.getFrontPageURL()).into(front);
                Picasso.with(Sendgetrequest_Asynctask.this).load(dotNetModel1.getBackPageURL()).into(back);

            }catch (Exception x){
                x.printStackTrace();
            }
        }
    }
}
