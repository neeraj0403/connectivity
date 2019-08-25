package com.codingblocks.newfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class submit extends AppCompatActivity {
    EditText age,number,name;

    Button submit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final DatabaseReference database= FirebaseDatabase.getInstance().getReference();
        final DatabaseReference reference=database.child("details");
        setContentView(R.layout.activity_submit);
        age=findViewById(R.id.age);
        name=findViewById(R.id.name);
        number=findViewById(R.id.phone);
        submit1=findViewById(R.id.save);


        // DatabaseReference database= FirebaseDatabase.getInstance().getReference();
        submit1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("in","in on click");
                String nname=name.getText().toString();
                String aage=age.getText().toString();
                String nnumber=number.getText().toString();
                details  details=new details(nname,aage,nnumber);


               reference.child("details").push().setValue(details);








            }
        });


    }
}
