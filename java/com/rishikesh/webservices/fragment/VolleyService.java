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
import com.rishikesh.webservices.Volley.PostRequestData;
import com.rishikesh.webservices.Volley.Readarray_volley;
import com.rishikesh.webservices.Volley.Readjson_volley;
import com.rishikesh.webservices.Volley.Sendget_request;
import com.rishikesh.webservices.Volley.Sendpost_volley;

public class VolleyService extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.volleyfragmnet,container,false);

        view.findViewById(R.id.jsonarray).setOnClickListener(this);
        view.findViewById(R.id.jsonobject).setOnClickListener(this);
        view.findViewById(R.id.imagerequest).setOnClickListener(this);
        view.findViewById(R.id.stringrequest).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.jsonarray:
                startActivity(new Intent(mactivity, Readarray_volley.class)); //JSONArrayRequest
                break;
            //Volley...
            case R.id.jsonobject:
                startActivity(new Intent(mactivity, Readjson_volley.class));   //StringRequest
                break;

            case R.id.imagerequest:
                startActivity(new Intent(mactivity, Sendpost_volley.class)); //ImageRequest
                break;

            case R.id.stringrequest:
                startActivity(new Intent(mactivity, Sendget_request.class)); //JSonObject
                break;
        }
    }
}
