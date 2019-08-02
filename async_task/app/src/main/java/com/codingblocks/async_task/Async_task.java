package com.codingblocks.async_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.TimerTask;

public class Async_task extends AppCompatActivity {


    TextView textView,textView1 ;
    Button btnRandom,btnStart ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        textView = findViewById(R.id.textView) ;
        textView1=findViewById(R.id.textView1) ;
        btnRandom = findViewById(R.id.Random) ;
        btnStart = findViewById(R.id.backButton) ;

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random() ;
                textView.setText(String.valueOf(random.nextInt(100)));
            }
        });

      btnStart.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              TimerTask task=new TimerTask();
              task.execute(5);
          }
      });




    }
    class TimerTask extends AsyncTask<Integer,Integer,Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView1.setText(String.valueOf(values[0]));
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int n = integers[0] ;
            for(int i=0;i<n;i++)
            {
                wait1sec();
                publishProgress(i);
            }
            return null ;
        }

    }
    void wait1sec()
    {
        long startTime = System.currentTimeMillis() ;
        while(System.currentTimeMillis()<startTime+1000) ;
    }
    void waitNsec(int n)
    {
        long startTime = System.currentTimeMillis() ;
        while(System.currentTimeMillis()<startTime+1000*n) ;
    }
}
