package com.rishikesh.webservices.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rishikesh.webservices.Asyntask.Readarraydata_asynctask;
import com.rishikesh.webservices.Asyntask.Readjson_asynctask;
import com.rishikesh.webservices.Asyntask.Sendgetrequest_Asynctask;
import com.rishikesh.webservices.Asyntask.Sendpostreques_Asyntask;
import com.rishikesh.webservices.Basic.BaseFragment;
import com.rishikesh.webservices.R;
import com.rishikesh.webservices.Volley.Readarray_volley;
import com.rishikesh.webservices.Volley.Readjson_volley;
import com.rishikesh.webservices.Volley.Sendget_request;
import com.rishikesh.webservices.Volley.Sendpost_volley;

public class AsyntaskService extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.asyntaskfragment,container,false);
        view.findViewById(R.id.readarray_asyntask).setOnClickListener(this);
        view.findViewById(R.id.readjson_asyntask).setOnClickListener(this);
        view.findViewById(R.id.sendpost_async).setOnClickListener(this);
        view.findViewById(R.id.sendget_async).setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.readarray_asyntask:
                startActivity(new Intent(mactivity, Readarraydata_asynctask.class));
                mactivity.finish();
                break;
            //Volley...
            case R.id.readjson_asyntask:
                startActivity(new Intent(mactivity, Readjson_asynctask.class));
                break;

            case R.id.sendget_async:
                startActivity(new Intent(mactivity, Sendgetrequest_Asynctask.class));
                break;

            case R.id.sendpost_async:
                startActivity(new Intent(mactivity, Sendpostreques_Asyntask.class));
                break;
        }
    }
}
