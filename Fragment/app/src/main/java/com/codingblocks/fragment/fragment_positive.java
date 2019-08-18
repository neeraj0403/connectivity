package com.codingblocks.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class fragment_positive extends Fragment {
    Integer count=0;
    TextView txt;
    Button btn;

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_negative,container,false);
        txt=view.findViewById(R.id.positive);
        btn=container.findViewById(R.id.Add);
        btn.setOnClickListener(new ViewGroup.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=count+1;
                txt.setText(count.toString());
            }
        });



        return inflater.inflate(R.layout.fragment_positive,container,false);
    }




}
