package com.codingblocks.contactlist;

import android.content.Intent;
import android.drm.DrmStore;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class contacts extends AppCompatActivity  {
    RecyclerView recycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        recycle = findViewById(R.id.recycle);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(linearLayoutManager);
        List<contactinfo> list = new ArrayList<>();
        list.add(new contactinfo("rohit", "8700618519" +
                "", "https://media.wired.com/photos/5b80661c2c80eb32627bf13b/master/w_582,c_limit/PresDonaldTrump-1022296714.jpg"));
        list.add(new contactinfo("vimal", "8700032995", "https://images.livemint.com/rf/Image-621x414/LiveMint/Period2/2018/12/24/Photos/Processed/modi8-kb6B--621x414@LiveMint.jpg"));
        list.add(new contactinfo("neeraj", "8810439244", "https://en.wikipedia.org/wiki/Barack_Obama#/media/File:President_Barack_Obama.jpg"));
        list.add(new contactinfo("prabhat", "9958898968", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTohaXooMIT6Q1fn76fDz0i_F2FnAaWuHvX9qzAXOTfe7A8XrrL"));
        list.add(new contactinfo("abhishek", "8800202487", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlIFpOD7z3z18oH8DBdsjgJh1LneOeL7vKrAyvvZ_YVl1hagABVw"));
        list.add(new contactinfo("amandeep", "8750448727", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlIFpOD7z3z18oH8DBdsjgJh1LneOeL7vKrAyvvZ_YVl1hagABVw"));
        list.add(new contactinfo("manish", "8802850720", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlIFpOD7z3z18oH8DBdsjgJh1LneOeL7vKrAyvvZ_YVl1hagABVw"));
        list.add(new contactinfo("rahul", "9540450444", "https://media.wired.com/photos/5b80661c2c80eb32627bf13b/master/w_582,c_limit/PresDonaldTrump-1022296714.jpg"));
        list.add(new contactinfo("amandeep", "8750448727", "https://media.wired.com/photos/5b80661c2c80eb32627bf13b/master/w_582,c_limit/PresDonaldTrump-1022296714.jpg"));
        list.add(new contactinfo("manish", "8802850720", "https://media.wired.com/photos/5b80661c2c80eb32627bf13b/master/w_582,c_limit/PresDonaldTrump-1022296714.jpg"));
        list.add(new contactinfo("rahul", "9540450444", "https://media.wired.com/photos/5b80661c2c80eb32627bf13b/master/w_582,c_limit/PresDonaldTrump-1022296714.jpg"));
        list.add(new contactinfo("neeraj", "1645454885", "https://media.wired.com/photos/5b80661c2c80eb32627bf13b/master/w_582,c_limit/PresDonaldTrump-1022296714.jpg"));
        contactadapter contactadapter = new contactadapter(list);
        recycle.setAdapter(contactadapter);


    }


}