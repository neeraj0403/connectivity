package com.codingblocks.news_api;

import android.net.Network;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity  {
 ImageView imageView;
 RecyclerView recyclerView;
    DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
    DatabaseReference databaseReference=reference.child("details");
            ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        String s="https://newsapi.org/v2/top-headlines?sources=google-news-in&apiKey=f9d45c8ff7fa4e5bb9f63948fbf9ec47";
      updaterecyclerview(s);
      Log.d("in","in main function");


    }
public void updaterecyclerview(String s) {
    Log.e("in ","inside update");
        Network network=new Network();
        network.execute(s);


    }



    class Network extends AsyncTask<String,Void,String>
{

    @Override
    protected void onPostExecute(final String s) {
        super.onPostExecute(s);


        recyclerView=findViewById(R.id.recycle);


        databaseReference.addChildEventListener(new ChildEventListener() {
            ArrayList<news_info>
          list=Jsoncall(s);
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d("in", "onChildAdded: ");
              //  news_info news_info=dataSnapshot.getValue(com.codingblocks.news_api.news_info.class);
                String content = dataSnapshot.child("content").getValue().toString() ;
                String desc=dataSnapshot.child("description").getValue().toString();
                String title= dataSnapshot.child("title").getValue().toString() ;
                String url=dataSnapshot.child("url").getValue().toString();
                String urltoimage=dataSnapshot.child("urltoimage").getValue().toString();
                news_info news_info1=new news_info(content,desc,title,url,urltoimage);
              list.add(news_info1);

                news_adapter newsInfos1=new news_adapter(list);
                Log.d("in","i am in network");
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(newsInfos1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }

    @Override
    protected String doInBackground(String... strings) {
        String s=strings[0];
        try {
            URL url=new URL(s);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
         InputStream inputStream= httpURLConnection.getInputStream();
         Log.d("in","I am in background");
         Scanner scanner=new Scanner(inputStream);
         scanner.useDelimiter("//A");
         if(scanner.hasNext())
         {
             String ns=scanner.next();
             return  ns;
         }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
return "invalid API";
    }

}
public ArrayList<news_info> Jsoncall(String s)
{

    ArrayList<news_info> list=new ArrayList<>();
    try {
        JSONObject object=new JSONObject(s);
        JSONArray array=object.getJSONArray("articles");
        Log.d("in","I am in jsoncall");
        for(int i=0;i<array.length();i++)
        {
            JSONObject object1=array.getJSONObject(i);
            String heading=object1.getString("title");
            String image=object1.getString("urlToImage");
            String desc=object1.getString("description");
            String url=object1.getString("url");
            String content=object1.getString("content");
            news_info info=new news_info(heading,image,desc,url,content);

            list.add(info);
            reference.child("details").push().setValue(info);

        }

    } catch (JSONException e) {
        e.printStackTrace();
    }


    return list;



}
}
