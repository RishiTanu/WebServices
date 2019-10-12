package com.rishikesh.webservices.Asyntask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rishikesh.webservices.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Sendpostreques_Asyntask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysenddata_withpostrequestasyntask);

        Toast.makeText(this, "Practice On", Toast.LENGTH_SHORT).show();
    }
}
