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


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
         DatabaseReference reference=databaseReference.child("details");
        Log.d("in", "i have my reference ");






reference.addChildEventListener(new ChildEventListener()
{
    ArrayList<details> list=new ArrayList<>();


    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        //called when a new data node is inserted to the "newfirebase"  node
int count=0;

        Log.d("in", "i am in onChildAdded");
//        String name = dataSnapshot.child("name").getValue().toString() ;
//        String age = dataSnapshot.child("age").getValue().toString() ;
//        String phno = dataSnapshot.child("phone").getValue().toString() ;

  details details=dataSnapshot.getValue(com.codingblocks.newfirebase.details.class);


        details details1=new details(details.name,details.age,details.phone);
    list.add(details1);
//            String name=databaseReference.child("name").;
//            String age=dataSnapshot.getValue(details.class).getAge();
//            String  phone=dataSnapshot.getValue(details.class).getPhone();
//            String name=snapshot.getValue(;
//            String age=snapshot.child("age").getValue(String.class);
//            String phone=snapshot.child("phone").getValue(String.class);
//            Log.d("in", name+" "+age+"  "+phone);




            Log.d("in", "i am calling pojo class ");
            Log.d("in","bye"+" "+details1.name+" "+details1.age+" "+details1.phone);


           // Log.d("in", );





        Log.d("in", "i am outside newsfireadapter");


        Log.d("in", "listsize"+list.size()) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Log.d("in", "Adapter set");
        newfireadapter newfireadapter = new newfireadapter(list);
        Log.d("in", "Adapter created");
        recyclerView.setAdapter(newfireadapter);
        Log.d("in", "Adapter called" +
                "");

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
