package com.codingblocks.iosd;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class team_memberfrag extends Fragment {


    public team_memberfrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // TextView textView = new TextView(getActivity());
       // textView.setText(R.string.hello_blank_fragment);
       ViewGroup  viewGroup= (ViewGroup) inflater.inflate(R.layout.team_memberfc,container,false);
       return  viewGroup;

    }

}
