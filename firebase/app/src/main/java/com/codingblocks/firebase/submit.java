package com.codingblocks.firebase;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class submit extends AppCompatActivity {

EditText age,number,name;

Button submit1;
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setContentView(R.layout.activity_submit);
        Intent intent=getIntent();
        age=findViewById(R.id.age);
        name=findViewById(R.id.name);
        number=findViewById(R.id.phone);
        submit1=findViewById(R.id.save);
      final DatabaseReference database= FirebaseDatabase.getInstance().getReference();
      submit1.setOnClickListener(new View.OnClickListener() {
   String nname=name.getText().toString();
   String aage=age.getText().toString();
   String nnumber=number.getText().toString();
          final DatabaseReference database= FirebaseDatabase.getInstance().getReference();
          @Override
          public void onClick(View v) {
     Log.d("in","in on click");

              database.push().setValue(new details(nname,aage,nnumber));
     Log.d("in","after setting data");











          }
      });


    }
}
