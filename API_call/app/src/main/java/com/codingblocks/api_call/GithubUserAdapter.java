package com.codingblocks.api_call;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.viewHolder> {

    Context context ;
    private ArrayList<GithubUser> list;

    public GithubUserAdapter(ArrayList<GithubUser> list) {
        this.list = list;
    }



    @NonNull
    @Override
    public GithubUserAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("main","oncreate") ;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout,viewGroup,false) ;
        context = viewGroup.getContext() ;
        return new viewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull GithubUserAdapter.viewHolder viewHolder, int i) {
        Log.d("main",i+"") ;

        String login = list.get(i).getLogin() ;
        String id = list.get(i).getId() ;
        String url = list.get(i).getUrl() ;
        String avatar = list.get(i).getAvatar_url() ;
        String score = list.get(i).getScore() ;
        viewHolder.setData(login,id,url,score,avatar);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder
    {
        TextView login,id,url,score  ;
        ImageView imageView ;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
             login = itemView.findViewById(R.id.user_name) ;
             id = itemView.findViewById(R.id.user_id) ;
             url = itemView.findViewById(R.id.user_profile) ;
             score = itemView.findViewById(R.id.user_score) ;
             imageView = itemView.findViewById(R.id.user_image) ;
            Log.d("main","viewholder") ;

        }

        public void setData(String loginn , String idd,String urll , String scoree , String imagelink)
        {
            login.setText(loginn);
            id.setText(idd);
            url.setText(urll);
            score.setText(scoree);
            Picasso.with(context).load(imagelink).into(imageView);
        }
    }
}
