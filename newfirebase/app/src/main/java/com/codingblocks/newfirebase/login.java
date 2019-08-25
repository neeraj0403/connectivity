package com.codingblocks.newfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class login extends AppCompatActivity {

    private static final int RC_SIGN_IN = 121 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        FirebaseAuth auth = FirebaseAuth.getInstance();
//        if (auth.getCurrentUser() != null) {
////            Intent i = new Intent(this,MainActivity.class) ;
////            startActivity(i);
//          } else {
//            startActivityForResult(
//                    AuthUI.getInstance()
//                            .createSignInIntentBuilder()
//                            .setAvailableProviders(Arrays.asList(
//                                    new AuthUI.IdpConfig.GoogleBuilder().build(),
//                                    new AuthUI.IdpConfig.EmailBuilder().build(),
//                                    new AuthUI.IdpConfig.PhoneBuilder().build(),
//                                    new AuthUI.IdpConfig.AnonymousBuilder().build()))
//                            .build(),
//                    RC_SIGN_IN);
//        }
    }
}
