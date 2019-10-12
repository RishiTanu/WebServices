package com.rishikesh.webservices.Volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rishikesh.webservices.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class PostVolleyAdapter extends RecyclerView.Adapter<PostVolleyAdapter.Holder> {


    private PostRequestData postRequestData[];
    private Context context;

    public PostVolleyAdapter(Context context ,PostRequestData[] postRequestData) {
        this.postRequestData = postRequestData;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_volley_post,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {

       PostRequestData postRequest =  postRequestData[position];

        Picasso.with(context).load(postRequest.getBikeImage()).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                holder.imageView.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

                holder.imageView.setImageResource(R.drawable.ic_launcher_background);
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                holder.imageView.setImageResource(R.drawable.ic_launcher_background);
            }
        });

        holder.textView.setText(postRequest.getBikeType());
    }

    @Override
    public int getItemCount() {
        return postRequestData.length;
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public Holder(View itemView) {
            super(itemView);

            imageView =itemView.findViewById(R.id.img);
            textView =itemView.findViewById(R.id.imgname);
        }

    }

}
