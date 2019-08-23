package com.codingblocks.newfirebase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class view extends AppCompatActivity {
  RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Log.d("in", "i am in view activity");
        recyclerView = findViewById(R.id.recycle);


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        Log.d("in", "i have my reference ");


databaseReference.addChildEventListener(new ChildEventListener()
{

    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        //called when a new data node is inserted to the "newfirebase"  node
int count=0;
        ArrayList<details> list=new ArrayList<>();
        Log.d("in", "i am in onChildAdded");

            String name=databaseReference.child("name").;
            String age=dataSnapshot.getValue(details.class).getAge();
            String  phone=dataSnapshot.getValue(details.class).getPhone();
            count=count+1;
            Log.d("in", "i am in datasnapshot loop"+count);
//            String name=snapshot.getValue(;
//            String age=snapshot.child("age").getValue(String.class);
//            String phone=snapshot.child("phone").getValue(String.class);
//            Log.d("in", name+" "+age+"  "+phone);
        details  details1=new details(name,age,phone);

        Log.d("in","hy"+" "+details1.name+" "+details1.age+" "+details1.phone);


            Log.d("in", "i am calling pojo class ");
            Log.d("in","bye"+" "+details1.name+" "+details1.age+" "+details1.phone);


           list.add(details1);
           // Log.d("in", );





        Log.d("in", "i am outside newsfireadapter");

        newfireadapter newfireadapter = new newfireadapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(newfireadapter);


    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        //An existing data node is updated

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
        //When a data at a subnode is removed

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//When the position  of the subnode changes
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
//when the read operation failed
    }
});
    }

}
