package com.rishikesh.webservices.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rishikesh.webservices.AndroidNetworking.GetRequest;
import com.rishikesh.webservices.AndroidNetworking.PostRequest;
import com.rishikesh.webservices.AndroidNetworking.ReadHoleJson;
import com.rishikesh.webservices.AndroidNetworking.ReadJsonArray;
import com.rishikesh.webservices.Basic.BaseFragment;
import com.rishikesh.webservices.R;
import com.rishikesh.webservices.Retrofit.ReadJson_retrofit;
import com.rishikesh.webservices.Retrofit.Readarray_retrofit;
import com.rishikesh.webservices.Retrofit.Sendgetrequest_retrofit;
import com.rishikesh.webservices.Retrofit.Sendpost_retrofit;

public class AndroidNetworkingService  extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.androidnetworingviewfragment, container, false);

        view.findViewById(R.id.readarray_networking).setOnClickListener(this);
        view.findViewById(R.id.readjson_networking).setOnClickListener(this);
        view.findViewById(R.id.networking_get).setOnClickListener(this);
        view.findViewById(R.id.networking_post).setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.readarray_networking:
                startActivity(new Intent(mactivity, ReadJsonArray.class));
                break;
            //Volley...
            case R.id.readjson_networking:
                startActivity(new Intent(mactivity, ReadHoleJson.class));
                break;

            case R.id.networking_post:
                startActivity(new Intent(mactivity, PostRequest.class));
                break;

            case R.id.networking_get:
                startActivity(new Intent(mactivity, GetRequest.class));
                break;
        }
    }
}
