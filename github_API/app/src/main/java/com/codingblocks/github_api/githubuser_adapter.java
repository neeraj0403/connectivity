package com.codingblocks.github_api;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class githubuser_adapter extends RecyclerView.Adapter<githubuser_adapter.ViewHolder> {
 Context context;
 private ArrayList<Githubuserinfo> list;

    public githubuser_adapter(ArrayList<Githubuserinfo> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public githubuser_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.github_row,viewGroup,false);
        context=viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull githubuser_adapter.ViewHolder viewHolder, int i) {

String name=list.get(i).getLogin();
String id=list.get(i).getId();
String avatarid=list.get(i).getAvatar_url();
String url=list.get(i).getUrl();
String score=list.get(i).getScore();
viewHolder.setData(name,id,avatarid,url,score);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      TextView name,id,score,url;
      ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(itemView).findViewById(R.id.user_name);
            id=(itemView).findViewById(R.id.user_id);
            score=(itemView).findViewById(R.id.user_score);
            url=itemView.findViewById(R.id.user_url);
            image=itemView.findViewById(R.id.user_image);
        }


        public void  setData(String nname, String iid, String aavatarid, String uurl, String sscore) {
            name.setText(nname);
            id.setText(iid);
            score.setText(sscore);
            url.setText(uurl);
            Picasso.with(context).load(aavatarid).resize(100,200).centerCrop().into(image);
        }
    }

}
