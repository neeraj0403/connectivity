package com.codingblocks.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
  Button contact,save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact=findViewById(R.id.contact);
        save=findViewById(R.id.save);
        contact.setOnClickListener(this);
        save.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case (R.id.contact):
            {

                Intent intent=new Intent(MainActivity.this,contacts.class);
                //intent.putExtra("name","contacts");
               startActivity(intent);

                break;
            }

//            case(R.id.save):
//                   {
//
//            Intent intent=new Intent(MainActivity.this,savecontact.class);
//            //intent.putExtra("naame","save");
//            startActivity(intent);
//                       break;
//                   }


        }
    }
}
