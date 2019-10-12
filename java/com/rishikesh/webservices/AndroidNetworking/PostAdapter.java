package com.rishikesh.webservices.AndroidNetworking;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rishikesh.webservices.R;
import com.rishikesh.webservices.Retrofit.PostBike;
import com.rishikesh.webservices.Volley.PostRequestData;
import com.rishikesh.webservices.Volley.PostVolleyAdapter;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private Context context;
    private PostBike[] postBike;

    public PostAdapter(Context context, PostBike postBike[]) {
        this.context = context;
        this.postBike = postBike;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_volley_post,viewGroup,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostHolder holder, int position) {
        PostBike postRequest = postBike[position];

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
        return postBike.length;
    }

    class PostHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            imageView =itemView.findViewById(R.id.img);
            textView =itemView.findViewById(R.id.imgname);
        }
    }
}
