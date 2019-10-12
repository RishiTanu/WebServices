package com.rishikesh.webservices.Volley;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rishikesh.webservices.R;

public class GitHubAdapter extends RecyclerView.Adapter<GitHubAdapter.Holder> {

    private Context context;
    private PostData postData[];

    public GitHubAdapter(Context context, PostData[] postData) {
        this.context = context;
        this.postData = postData;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.volley_itemview,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        PostData post = postData[position];
        holder.id.setText(post.getId());
        holder.userid.setText(post.getUserId());
        holder.body.setText(post.getBody());
        holder.title.setText(post.getTitle());
    }

    @Override
    public int getItemCount() {
        return postData.length;
    }


    public class Holder extends RecyclerView.ViewHolder {

        TextView id, userid, title, body;

        public Holder(View itemView) {
            super(itemView);

            userid = itemView.findViewById(R.id.userid);
            id = itemView.findViewById(R.id.Idvalue);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);

        }
    }
}
