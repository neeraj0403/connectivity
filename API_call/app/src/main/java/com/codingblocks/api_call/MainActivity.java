package com.codingblocks.api_call;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    EditText  editText ;
    Button btn ;
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.user) ;
        btn = findViewById(R.id.btn) ;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updaterecyclerview(editText.getText().toString()) ;
            }
        });
    }
    private void updaterecyclerview(String str)
    {
      NetworkTask networkTask = new NetworkTask() ;
      networkTask.execute("https://api.github.com/search/users?q="+str) ;
    }

    class NetworkTask extends AsyncTask<String,Void,String>
    {


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
           // Log.d("main","ONPOSTEXECUTE") ;

            ArrayList<GithubUser> users = jsonparser(s);
            //Log.d("main",users.size()+"") ;

            GithubUserAdapter adapter = new GithubUserAdapter(users) ;
            recyclerView = findViewById(R.id.recycle) ;


            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

            recyclerView.setAdapter(adapter);

           // Log.d("main","ONPOSTEXECUTEENDED") ;


        }

        @Override
        protected String doInBackground(String... strings) {
            String url1 = strings[0] ;
            Log.d("main","DOINBACKGROUND") ;
            try {
                URL url = new URL(url1) ;
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection() ;
                InputStream inputStream = httpURLConnection.getInputStream() ;
                Scanner scanner = new Scanner(inputStream) ;
                scanner.useDelimiter("\\A") ;
                if(scanner.hasNext())
                {
                    String s = scanner.next() ;
                    Log.d("main","DOINBACKGROUNDEND") ;


                    return s ;  }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("main","DOINBACKGROUNDEND") ;


            return "Failed to load " ;
        }
    }

    private ArrayList<GithubUser> jsonparser(String s) {
        ArrayList<GithubUser> list = new ArrayList<>() ;
        Log.d("main","JSONPARSER") ;

        try {
            JSONObject object = new JSONObject(s) ;
            JSONArray items = object.getJSONArray("items");
            for(int i=0;i<items.length();i++)
            {
                JSONObject object1 = items.getJSONObject(i) ;
                String login = object1.getString("login")  ;
                String id = object1.getString("id") ;
                String avatar = object1.getString("avatar_url") ;
                String userurl = object1.getString("url") ;
                String score = object1.getString("score") ;
                GithubUser githubUser = new GithubUser(login,id,avatar,userurl,score) ;
                list.add(githubUser) ;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("main",list.size()+"") ;
        return list ;
    }
}
