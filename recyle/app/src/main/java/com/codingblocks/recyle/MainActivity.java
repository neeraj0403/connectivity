package com.codingblocks.recyle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this) ;
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL) ;
        recyclerView.setLayoutManager(layoutManager);


        List<name> list = new ArrayList<>() ;
        list.add(new name("vimal","triapathi")) ;
        list.add(new name("neeraj","pandey  ")) ;
        list.add(new name("abhishek","tripathi"));
        list.add(new name("manish","yadav"));
        list.add(new name("aman","achee"));
        list.add(new name("rahul","meena"));
        list.add(new name("dhanji","ray"));
        list.add(new name("shivam","dhaka"));
        list.add(new name("akhil","kumar"));
        list.add(new name("vimal","chutiya"));
        list.add(new name("abhishek","HHH"));
        list.add(new name ("achee","amandeep"));
        list.add(new name ("achee","amandeep"));
        list.add(new name ("achee","amandeep"));
        list.add(new name("rahul","meena"));
        list.add(new name("abhishek","tripathi"));
        list.add(new name("manish","yadav"));
        list.add(new name("aman","achee"));
        list.add(new name("rahul","meena"));
        list.add(new name("rahul","meena"));
        list.add(new name("dhanji","ray"));
        list.add(new name("shivam","dhaka"));
        list.add(new name("akhil","kumar"));
        list.add(new name("vimal","chutiya"));
        list.add(new name("abhishek","HHH"));
        list.add(new name ("achee","amandeep"));

    Adapter adapter = new Adapter(list) ;
    recyclerView.setAdapter(adapter);




    }
}
