package com.codingblocks.async_task;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lsView ;
    Button btn ;


    String[] names = new String[]{"neeraj","rohit","aman","abhi","vimal","shubham","manu","neeraj","rohit","aman","abhi","vimal","shubham","manu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn) ;
        lsView = findViewById(R.id.listview) ;
        final LinearLayout linear = findViewById(R.id.linear) ;

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,names) ;
        lsView.setAdapter(arrayAdapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Handler neeraj = new Handler() ;
//                Runnable neerajrun = new Runnable() {
//                    @Override
//                    public void run() {
//
//                        linear.setBackgroundColor(Color.BLUE);
//                    }
//                } ;
//                neeraj.postDelayed(neerajrun,10000);





            }
        });

    }
}
