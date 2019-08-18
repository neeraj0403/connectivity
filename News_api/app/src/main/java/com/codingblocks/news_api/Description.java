package com.codingblocks.news_api;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class Description extends AppCompatActivity  {
TextView head,desc;
RecyclerView recyclerView;
 int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("in","i am before setcontentview");
        setContentView(R.layout.activity_description);
        Log.d("in","i am after setcontentview");
        head=findViewById(R.id.mainheadline);
        desc=findViewById(R.id.fulldescription);
        recyclerView=findViewById(R.id.recycle);
        Intent intent= getIntent();

     ArrayList<news_info>  list1= news_adapter.list;
//        Log.d("in","i am in description");
//        Bundle args=intent.getBundleExtra("BUNDLE");
//        Log.d("in ","in new activity");
//        ArrayList<news_info> list1= (ArrayList<news_info>) args.getSerializable("ARRAYLIST");


int  pos=intent.getIntExtra("pos",0);




        String title=  list1.get(pos).getTitle();
        Log.d("in i",i+"");
         String desc=list1.get(pos).getContent();
         setdata(title,desc);







    }

    private void setdata(String ttitle, String ddesc) {
       head.setText(ttitle);
        desc.setText(ddesc);
    }
}
