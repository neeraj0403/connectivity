package com.codingblocks.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.zip.Inflater;

public class fragment1 extends Fragment implements View.OnClickListener {
Button frag1,frag2,second;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_fragment1,container,false);
      frag1=view.findViewById(R.id.Frag1);
      frag2=view.findViewById(R.id.Frag2);
      second=view.findViewById(R.id.SecondActivity);
      frag1.setOnClickListener(this);
      frag2.setOnClickListener(this);
      second.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case (R.id.Frag1):
                Toast.makeText(getActivity(),"going to fragment 1",Toast.LENGTH_LONG).show();
                ((MainActivity)getActivity()).countfrag(0);
            case (R.id.Frag2):
                Toast.makeText(getActivity(),"going to fragment 2",Toast.LENGTH_LONG).show();
                ((MainActivity)getActivity()).countfrag(1);
            case (R.id.SecondActivity):
                Toast.makeText(getActivity(),"going to second activity",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getContext(),secondactivvity.class);
                startActivity(intent);


        }

    }
}
