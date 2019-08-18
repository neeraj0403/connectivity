package com.codingblocks.count_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_negative extends Fragment {

TextView txt;
Button btn;
Integer count=0;

    public fragment_negative() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_negative, container, false);

        txt=view.findViewById(R.id.negative);
        btn=view.findViewById(R.id.subtract);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=count-1;
                txt.setText(count.toString());

            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
