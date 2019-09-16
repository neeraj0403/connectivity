package com.codingblocks.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private  stateadapter stateadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager=findViewById(R.id.container);
        stateadapter =new stateadapter(getSupportFragmentManager());
        setPager(pager);


    }
    private  void setPager(ViewPager viewPager)
    {   stateadapter adapter=new stateadapter(getSupportFragmentManager());
       adapter.addfragment(new fragment1(),"fragment1");
       adapter.addfragment(new fragment2(),"fragment2");
       viewPager.setAdapter(adapter);





    }
     public  void countfrag(int nfragment)
     {
         pager.setCurrentItem(nfragment);


     }
}
