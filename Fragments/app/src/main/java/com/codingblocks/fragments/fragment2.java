package com.codingblocks.fragments;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class fragment2 extends Fragment implements View.OnClickListener {
    Button frag1,frag2,second;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment2,container,false);
        frag1=view.findViewById(R.id.nFrag1);
        frag2=view.findViewById(R.id.nFrag2);
        second=view.findViewById(R.id.nSecondActivity);
        frag1.setOnClickListener(this);
        frag2.setOnClickListener(this);
        second.setOnClickListener(this);



        return view;
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case (R.id.nFrag1):
                Toast.makeText(getActivity(),"going to fragment 1",Toast.LENGTH_LONG).show();
                ((MainActivity)getActivity()).countfrag(0);
            case (R.id.nFrag2):
                Toast.makeText(getActivity(),"going to fragment 2",Toast.LENGTH_LONG).show();
                ((MainActivity)getActivity()).countfrag(1);
            case (R.id.nSecondActivity):
                Toast.makeText(getActivity(),"going to second activity",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getContext(),secondactivvity.class);
                startActivity(intent);


        }

    }
}
