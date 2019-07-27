package com.codingblocks.switchintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  Switch sw;
  Button btn;
  String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw=findViewById(R.id.switch1);
        btn=findViewById(R.id.btn);
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("name","10");

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw.isChecked())
                {
                    str=sw.getTextOn().toString();

                }
                else
                {
                   str= sw.getTextOff().toString();
                }
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
