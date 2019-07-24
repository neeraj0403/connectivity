package com.codingblocks.snackbarprogress;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;

  Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        coordinatorLayout=findViewById(R.id.coordinate);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
     Snackbar.make(coordinatorLayout,"default button is pressed",Snackbar.LENGTH_LONG)
             .setAction("undo", new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Snackbar.make(coordinatorLayout,"undo  done",Snackbar.LENGTH_SHORT).show();
                 }
             }).show();




            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout,"action call button is pressed",Snackbar.LENGTH_LONG).show();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout,"custom view button is pressed",Snackbar.LENGTH_LONG).show();
            }
        });





        }


    }

