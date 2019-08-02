package com.codingblocks.stopwatch;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
  TextView output;
  EditText input;
  Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output=findViewById(R.id.output);
        input=findViewById(R.id.input);
        btn=findViewById(R.id.btn);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          task task=new task();
          task.execute(Integer.parseInt(input.getText().toString()));
           }

    });
    }
    class task extends AsyncTask<Integer,Integer,Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(),"task completed",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            output.setText(String.valueOf(values[0]));
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int n=integers[0];
            for(int i=1;i<=n;i++)
            {
                wait1sec();
                publishProgress(i);


            }
  return null;
        }

    }
    public void  wait1sec()
    {
       long starttime=System.currentTimeMillis();
       while(System.currentTimeMillis()<starttime+1000);


    }
}
