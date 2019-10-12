package com.rishikesh.webservices.Retrofit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.rishikesh.webservices.Basic.UniversalImageLoader;
import com.rishikesh.webservices.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CityAdapters extends RecyclerView.Adapter<CityAdapters.Holder> {


    private Context context;
    private List<CityData> cityData;

    public CityAdapters(Context context, List<CityData> cityData) {
        this.context = context;
        this.cityData = cityData;
        UniversalImageLoader.universalsetup(context);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.bikeitems,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {

        CityData city = cityData.get(position);

        ImageLoader imageLoader = ImageLoader.getInstance();

        int defaultImage = context.getResources().getIdentifier("@drawable/ic_launcher_background",null,context.getPackageName());
        //create display options

        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();

        //download and display image from url
        imageLoader.displayImage(city.getImageUrl(), holder.imageView, displayImageOptions, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                holder.imageView.setImageResource(R.drawable.ic_launcher_background);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                holder.imageView.setImageResource(R.drawable.ic_launcher_background);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                holder.imageView.setImageResource(R.drawable.ic_launcher_background);
            }
        });

        holder.textView.setText(city.getCityName());
    }

    @Override
    public int getItemCount() {
        return cityData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public Holder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.bikename);
        }
    }
}
