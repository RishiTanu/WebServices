package com.rishikesh.webservices.Basic;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class CommonClass {

    private static Toast mToast;
    private static ProgressDialog progressDialog;

    public static void showtoastshort(Context context, String msg) {

        if(mToast != null && mToast.getView().isShown())
            mToast.cancel();

        mToast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void showDialog(Activity context, String msg){

        if(progressDialog == null) {
           progressDialog = new ProgressDialog(context);
           progressDialog.setCancelable(false);
           progressDialog.setMessage(msg);
           progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
           progressDialog.show();
        }
    }

    public static void hideDialog(Context context){

           if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
            progressDialog = null;
           }
    }

    public static void print(String msg){
        Log.d("WebService",msg);
    }
}
