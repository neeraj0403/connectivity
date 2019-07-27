package com.codingblocks.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public ListView list;
    String[] str=new String[]
    {"rohit","neeraj","vimal","sachin","aman","abhishek"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,str);
      list.setAdapter(arrayAdapter);
      list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              int item =position;
              String value=(String)list.getItemAtPosition(item);
              Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();
          }
      });
    }

}
