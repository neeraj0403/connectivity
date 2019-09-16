package com.codingblocks.iosd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.StringJoiner;

public class Fragment_profile extends Fragment {
private ImageView imageView;
private TextView college,branch,year,batch,Name,email,github,course,phone;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        View view=inflater.inflate(R.layout.activity_fragment_profile,container,false);
      imageView=view.findViewById(R.id.fragprofile_image);
      college=view.findViewById(R.id.fragprofile_college);
      branch=view.findViewById(R.id.fragprofile_branch);
      year=view.findViewById(R.id.fragprofile_year);
      batch=view.findViewById(R.id.fragprofile_batch);
      Name=view.findViewById(R.id.fragprofile_name);
      email=view.findViewById(R.id.fragprofile_mail);
      github=view.findViewById(R.id.fragprofile_github);
      course=view.findViewById(R.id.fragprofile_course);
      phone=view.findViewById(R.id.fragprofile_phone);

        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
        final DatabaseReference reference=databaseReference.child("details");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String image=dataSnapshot.child("Photo").getValue().toString();
                String name=dataSnapshot.child("Name").getValue().toString();
                String mcollege=dataSnapshot.child("College").getValue().toString();
                String  mcourse=dataSnapshot.child("Course").getValue().toString();
                String mbranch=dataSnapshot.child("Branch").getValue().toString();
                String myear=dataSnapshot.child("Year").getValue().toString();
                String mbatch=dataSnapshot.child("Batch").getValue().toString();
                String memail=dataSnapshot.child("Email").getValue().toString();
                String mgithub=dataSnapshot.child("Github").getValue().toString();
                String mphone=dataSnapshot.child("Phone").getValue().toString();
                Picasso.get().load(image).into(imageView);
                Name.setText(name);
                college.setText(mcollege);
                course.setText(mcourse);
                branch.setText(mbranch);
                year.setText(myear);
                batch.setText(mbatch);
                email.setText(memail);
                github.setText(mgithub);
                phone.setText(mphone);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }
}
