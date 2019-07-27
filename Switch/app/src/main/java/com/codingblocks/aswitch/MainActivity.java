package com.codingblocks.aswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn  ;
    Switch sw ;
    String str ;
    int a= 0 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn) ;
        sw= findViewById(R.id.switch1) ;

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(a==1)
                sw.setText("select to off");
                else {
                    sw.setText("select to on");
                    a = 0;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw.isChecked())
                {
                    str = sw.getTextOn().toString() ;

                }
                else {
                    str = sw.getTextOff().toString();

                }
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
