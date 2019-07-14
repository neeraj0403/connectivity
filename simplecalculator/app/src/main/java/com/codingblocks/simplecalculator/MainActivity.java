package com.codingblocks.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public final String TAG=getClass().getSimpleName();
EditText num1;
EditText num2;
TextView countview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
countview=findViewById(R.id.textView);
        num1=findViewById(R.id.editText3);
        num2=findViewById(R.id.editText4);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }



    public void add(View view) {
       // int ans=num1.toString()+num2.toString();
int fn=Integer.parseInt(num1.getText().toString());
int sn=Integer.parseInt(num2.getText().toString());
Integer add=fn+sn;


    Log.e(TAG,"add");
    countview.setText(add.toString());


    }

    public void subtract(View view) {
      //  Integer ans=num1.toString()-num2.toString();
        Log.e(TAG,"sub");
        int fn=Integer.parseInt(num1.getText().toString());
        int sn=Integer.parseInt(num2.getText().toString());
        Integer sub=fn-sn;
        countview.setText(sub.toString());
    }

    public void multiply(View view) {
        // int ans=num1.toString()+num2.toString();
        int fn=Integer.parseInt(num1.getText().toString());
        int sn=Integer.parseInt(num2.getText().toString());
        Integer mul=fn*sn;
        Log.e(TAG,"multiply");
        countview.setText(mul.toString());
    }

    public void divide(View view) {
        int fn=Integer.parseInt(num1.getText().toString());
        int sn=Integer.parseInt(num2.getText().toString());
        if (sn==0)
        {
            Log.e(TAG,"cant divide");
            countview.setText("cant divide");

        }
        else
        {
           Integer div=fn/sn;
           countview.setText(div.toString());
        }
    }
}
