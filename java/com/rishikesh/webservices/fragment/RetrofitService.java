package com.rishikesh.webservices.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rishikesh.webservices.Basic.BaseFragment;
import com.rishikesh.webservices.R;
import com.rishikesh.webservices.Retrofit.ReadJson_retrofit;
import com.rishikesh.webservices.Retrofit.Readarray_retrofit;
import com.rishikesh.webservices.Retrofit.Sendgetrequest_retrofit;
import com.rishikesh.webservices.Retrofit.Sendpost_retrofit;
import com.rishikesh.webservices.Volley.Readarray_volley;
import com.rishikesh.webservices.Volley.Readjson_volley;
import com.rishikesh.webservices.Volley.Sendget_request;
import com.rishikesh.webservices.Volley.Sendpost_volley;

public class RetrofitService extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.retrogitfragment,container,false);

        view.findViewById(R.id.readarray_retrofit).setOnClickListener(this);
        view.findViewById(R.id.readjson_retrofit).setOnClickListener(this);
        view.findViewById(R.id.senddataget_retrofit).setOnClickListener(this);
        view.findViewById(R.id.sendpost_retrofit).setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.readarray_retrofit:
                startActivity(new Intent(mactivity, Readarray_retrofit.class));
                break;
            //Volley...
            case R.id.readjson_retrofit:
                startActivity(new Intent(mactivity, ReadJson_retrofit.class));
                break;

            case R.id.sendpost_retrofit:
                startActivity(new Intent(mactivity, Sendpost_retrofit.class));
                break;

            case R.id.senddataget_retrofit:
                startActivity(new Intent(mactivity, Sendgetrequest_retrofit.class));
                break;
        }
    }
}
