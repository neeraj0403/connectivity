package com.codingblocks.news_api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class news_adapter extends RecyclerView.Adapter<news_adapter.ViewHolder> {
 public static ArrayList<news_info> list;

 Context context;


    public interface OnItemClickListener {
        void onItemClick(news_info item);
    }




    public ArrayList<news_info> getList() {
        return list;
    }


    public news_adapter(ArrayList<news_info> list) {
        this.list = list;
    }

    public news_adapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public news_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_row,viewGroup,false);
     context=viewGroup.getContext();

//
//     view.setOnClickListener(new View.OnClickListener() {
//         @Override
//         public void onClick(View v) {
//             Intent intent=new Intent(context,Description.class);
//             Bundle args=new Bundle();
//
//             args.putSerializable("ARRAYLIST",(Serializable)list);
//             intent.putExtra("BUNDLE",args);
//             context.startActivity(intent);
//
//
//         }
//     });

        Log.e("adapterview","view");

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final news_adapter.ViewHolder viewHolder, int i) {
        String title=list.get(i).getTitle();
        String image=list.get(i).getUrltoimage();
        String description=list.get(i).getDescription();
        String url=list.get(i).getUrl();
        final String content=list.get(i).getContent();
        viewHolder.setdata(title,image,description,url,content);

//viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

//    @Override
//    public void onClick(View v) {
//        Log.d("in","i am in onclick");
//        Intent intent=new Intent(context,Description.class);
//        Log.d("in","i am in intent");
//
//
//
//             args.putSerializable("ARRAYLIST",(Serializable)list);
//             intent.putExtra("BUNDLE",args);
//        context.startActivity(intent);
//    }
//});


    }



    @Override
    public int getItemCount() {
        return list.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder
    {TextView headline,content;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            headline=(itemView).findViewById(R.id.headline);
            content=(itemView).findViewById(R.id.content);

            image=(itemView).findViewById(R.id.image);

        }
        public void  setdata(String ttitle,String iimage,String ddescription,String uurl,String ccontent)
        {
            headline.setText(ttitle);
            Picasso.with(context).load(iimage).fit().into(image);
            content.setText(ddescription);
itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context,Description.class);
                Log.d("in","i am in onclick");
      
        Log.d("in","i am in intent");

Bundle args=new Bundle();


//             args.putSerializable("ARRAYLIST",(Serializable)list);
//             intent.putExtra("BUNDLE",args);
        int pos=getAdapterPosition();
        intent.putExtra("pos",pos);

        context.startActivity(intent);


    }
});


        }



    }

}

