package com.rishikesh.webservices.Retrofit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rishikesh.webservices.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BikeAdapters extends RecyclerView.Adapter<BikeAdapters.Holder> {


    private Context context;
    private List<PostBike> postBikes;

    public BikeAdapters(Context context, List<PostBike> postBikes) {
        this.context = context;
        this.postBikes = postBikes;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.bikeitems,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        PostBike postBike = postBikes.get(position);
        Picasso.with(context).load(postBike.getBikeImage()).into(holder.imageView);
        holder.textView.setText(postBike.getBikeType());
    }

    @Override
    public int getItemCount() {

        return postBikes.size();
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
