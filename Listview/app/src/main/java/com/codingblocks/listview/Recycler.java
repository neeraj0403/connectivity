package com.codingblocks.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity {

    ArrayList<data> Data=new ArrayList<>();
 RecyclerView recycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recycle=findViewById(R.id.rview);
        data Data1=new data("arnav","gupta","android");
        data Data2=new data("harshit","diwedi","android");
        data Data3=new data("garima","chhikara","java");
        data Data4=new data("prateek","narang","c++");
        data Data5=new data("rishab","garg","java");
      Data.add(Data1);
        Data.add(Data2);
        Data.add(Data3);
        Data.add(Data4);
        Data.add(Data5);

    }
}
