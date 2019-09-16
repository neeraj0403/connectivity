package me.kumarrohit.syndicatefinal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    FirebaseAuth mAuth = FirebaseAuth.getInstance() ;
    String uid = mAuth.getUid()  ;
    String profile_url ,name_person ;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("admin_app").child("profiles")
            .child(uid);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content_frame, new HomeFragment());
        tx.commit();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = findViewById(R.id.fab);
        View v = findViewById(R.id.fab) ;
        NavigationView navigationView = findViewById(R.id.nav_view);
        View Navheaderview  = navigationView.getHeaderView(0) ;
        CircleImageView  profile_image = (CircleImageView) Navheaderview.findViewById(R.id.profile_image) ;
        TextView profile_name = (TextView) Navheaderview.findViewById(R.id.nav_header_name) ;

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String valid = dataSnapshot.child("is_hni").getValue().toString() ;
                 profile_url = dataSnapshot.child("profile_image").getValue().toString() ;
                  name_person = dataSnapshot.child("Name").getValue().toString() ;
                Picasso.get().load(profile_url).into(profile_image) ;
                profile_name.setText(name_person);


                if(valid.equals("false"))
                {
                    fab.hide();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }) ;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction tx1 = getSupportFragmentManager().beginTransaction();

                tx1.replace(R.id.content_frame, new File_request());
                tx1.commit() ;

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Fragment fragment = null;

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new HomeFragment() ;
        } else if (id == R.id.nav_previousrequest) {
            Toast.makeText(getApplicationContext(), "This is a just to demonstrate a Real Application", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_profile) {
            fragment = new ProfileFragment() ;

        } else if (id == R.id.nav_feedback) {
            fragment = new Feedback()   ;
        }
        else if(id==R.id.nav_logout)
        {
            FirebaseAuth fAuth = FirebaseAuth.getInstance();
            fAuth.signOut();

            Intent I = new Intent(this,loginActivity.class) ;
            startActivity(I);

        }
        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
