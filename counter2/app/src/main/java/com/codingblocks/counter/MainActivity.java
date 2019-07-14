package com.codingblocks.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public  final  String TAG=getClass().getSimpleName();
 private   Integer count =0;
    TextView mycount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mycount=findViewById(R.id.textView);

        Log.e(TAG, "onCreate:");
    }

        @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        //your app is on runing state
        super.onResume();
        Log.e(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        //called when your activity is partially hidden
        super.onPause();
        Log.e(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        //called when your activity is fully hidden/no longer visible
        super.onStop();
        Log.e(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        //not called always but is called when the activity is destroyed explicitly
        //or when the back button is pressed
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }


    public void increments(View view) {
        //write some code that gives me access to textview
        //update the textview with the value of count


         count++;
        mycount.setText(count.toString());
        Log.e(TAG,"Increment"+count);
    }

    public void decremrent(View view) {
        //write some code that gives me access to the textview
        //update the textview with the value of count

        count--;
        Log.e(TAG,"decrement"+count);
        mycount.setText(count.toString());
    }
}

