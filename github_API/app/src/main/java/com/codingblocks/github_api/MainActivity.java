package com.codingblocks.github_api;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class MainActivity extends AppCompatActivity {
EditText user;
Button btn;
RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.user);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updaterecyclerview(user.getText().toString());
            }
        });

    }

    private void updaterecyclerview(String str) {
        Network network=new Network();
        network.execute("https://api.github.com/search/users?q="+str);

    }
     class Network extends AsyncTask<String,Void,String>
     {



         @Override
         protected String doInBackground(String... strings) {
             String stringurl=strings[0];
             try {
                 URL url=new URL(stringurl);
                 // established connection using http
                 HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                 InputStream inputStream=httpURLConnection.getInputStream();
                 Scanner scanner=new Scanner(inputStream);
                 scanner.useDelimiter("//A");
//Delimeter is used to read the entire content in one go
                 if(scanner.hasNext())
                 {
                     String s=scanner.next();
                     return s;
                 }
             } catch (MalformedURLException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }


             return "Failed to load";
         }

         @Override
         protected void onPostExecute(String s) {
    super.onPostExecute(s);
    ArrayList<Githubuserinfo> githubuser_adapters=jsoncall(s);
             recycle=findViewById(R.id.recycle);
    githubuser_adapter githubuser_adapters1=new githubuser_adapter(githubuser_adapters);
    recycle.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    recycle.setAdapter(githubuser_adapters1);





         }
     }
     public ArrayList<Githubuserinfo> jsoncall(String s)
     {
         ArrayList<Githubuserinfo> list=new ArrayList<>();
         try {
             JSONObject object=new JSONObject(s);
             JSONArray items=object.getJSONArray("items");
             for(int i=0;i<items.length();i++)
             {
                 JSONObject object1=items.getJSONObject(i);
                 String name=object1.getString("login");
                 String id=object1.getString("id");
                 String avatarurl=object1.getString("avatar_url");
                 String url=object1.getString("url");
                 String score=object1.getString("score");
                 Githubuserinfo githubuserinfo=new Githubuserinfo(name,id,avatarurl,url,score);
                 list.add(githubuserinfo);

             }

         } catch (JSONException e) {
             e.printStackTrace();
         }


         return list;


     }
}
