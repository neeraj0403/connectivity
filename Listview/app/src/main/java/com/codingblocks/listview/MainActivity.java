package com.codingblocks.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lvcourses);
        data Data1=new data("arnav","gupta","android");
        data Data2=new data("harshit","diwedi","android");
        data Data3=new data("garima","chhikara","java");
        data Data4=new data("prateek","narang","c++");
        data Data5=new data("rishab","garg","java");
        ArrayList<data> info=new ArrayList<>();
        info.add(Data1);
        info.add(Data2);
        info.add(Data3);
        info.add(Data4);
        info.add(Data5);

        personadapter datapersonadapter;
        datapersonadapter = new personadapter(getApplicationContext(),R.layout.row_layout,info);

      listView.setAdapter(datapersonadapter);
    }
}
