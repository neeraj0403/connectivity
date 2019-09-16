package com.codingblocks.iosd;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
 private DrawerLayout mlayout;
 ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      ///indow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        mlayout=(DrawerLayout)findViewById(R.id.draw);
        toggle=new ActionBarDrawerToggle(this,mlayout,R.string.open,R.string.close);

        mlayout.addDrawerListener(toggle);
        toggle.syncState();
        ActionBar actionBar = getSupportActionBar();
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

          navigationView=findViewById(R.id.navbutton);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            public boolean onOptionsItemSelected(MenuItem item){
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
                return true;
            }
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

     int id=menuItem.getItemId();
                Fragment fragment=null;
    if(id==R.id.home)
                {
                    fragment =new Fragment_home();
                    Toast.makeText(getApplicationContext(),"home",Toast.LENGTH_SHORT).show();


                }
               else if(id==R.id.profile)
                {
                    fragment=new Fragment_profile();

                }
    else if(id==R.id.upcomingevents)
                {
                    Toast.makeText(getApplicationContext(),"upcoming events",Toast.LENGTH_SHORT).show();

                }
    else  if(id==R.id.our_Team)
                {
                    Toast.makeText(getApplicationContext(),"ourteam",Toast.LENGTH_SHORT).show();

                }
    else  if(id==R.id.achievement)
                {
                    Toast.makeText(getApplicationContext(),"achievement",Toast.LENGTH_SHORT).show();

                }
    else  if(id==R.id.faqs)
                {
                    Toast.makeText(getApplicationContext(),"faqs",Toast.LENGTH_SHORT).show();

                }
    else if(id==R.id.sign_out)
                {
                    FirebaseAuth.getInstance().signOut();
                    Intent intent=new Intent(MainActivity.this,login_page.class);
                    startActivity(intent);
                }
           if(fragment!=null)
           {
               FragmentManager fragmentManager=getSupportFragmentManager();
               FragmentTransaction transaction=fragmentManager.beginTransaction();
               transaction.replace(R.id.mrel,fragment).addToBackStack(null);

               transaction.commit();


           }

                mlayout.closeDrawers();
                 return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toggle.onOptionsItemSelected(item)||super.onOptionsItemSelected(item);
    }
}
