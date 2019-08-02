package com.codingblocks.background_colour;

import android.graphics.Color;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
Button btn;
ConstraintLayout layout;
ListView view;
String []items=new String []{

    "Rohit",
        "neeraj",
        "vimal"
,"abhishek",
        "aman","manish","dhanji"
, "Rohit",
        "neeraj",
        "vimal"
        ,"abhishek",
        "aman","manish","dhanji","drona"




};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        layout=findViewById(R.id.color);
        view=findViewById(R.id.listview);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler h=new Handler();
                Runnable r=new Runnable() {
                    @Override
                    public void run() {

       layout.setBackgroundColor(Color.YELLOW);
                    }
                };
                h.postDelayed(r,5000);
            }
        });
        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext()
                ,android.R.layout.simple_list_item_1,android.R.id.text1,items);
        view.setAdapter(adapter);

    }
void waitnsec(int n)
{
    long starttime=System.currentTimeMillis();
    while(System.currentTimeMillis()<starttime*n);
}
}
