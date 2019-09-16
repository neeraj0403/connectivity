package com.codingblocks.iosd;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    private EditText signupmail,signuppass,signupvalidpass,number;
    private Button register;
    private TextView login;
    private FirebaseAuth mauth;
    private  FirebaseAuth.AuthStateListener mAuthListener;
    FrameLayout signuppage;
   private ProgressBar  progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);
        signupmail=findViewById(R.id.signupemail);
        signuppass=findViewById(R.id.signuppass);
        signupvalidpass=findViewById(R.id.signupvalidpass);
        register=findViewById(R.id.registerbutton);
        login=findViewById(R.id.memberlogin);
       number=findViewById(R.id.signupcontact);
        mauth= FirebaseAuth.getInstance();
        signuppage=findViewById(R.id.signupframe);
        progressBar=findViewById(R.id.progress_barsignup);

     register.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ///progressBar.setVisibility(View.VISIBLE);
            final String mail = signupmail.getText().toString();
            String pass1 = signuppass.getText().toString();
            String pass2 = signupvalidpass.getText().toString();
          //  String contact=number.getText().toString();
            if (TextUtils.isEmpty(mail)) {
                Toast.makeText(signup.this, "please enter your email", Toast.LENGTH_SHORT).show();
                signupmail.requestFocus();
                return;
              //  progressBar.setVisibility(View.INVISIBLE);

            }
//            else if(contact.length()!=10)
//            {
//
//                Toast.makeText(signup.this,"please enter a vallid 10 digit no phone no",Toast.LENGTH_SHORT).show();
//                number.requestFocus();
//            }
           else  if (TextUtils.isEmpty(pass1)) {
                Toast.makeText(signup.this, "please enter your password", Toast.LENGTH_SHORT).show();
                signuppass.requestFocus();

                //progressBar.setVisibility(View.INVISIBLE);
            }
         else    if (TextUtils.isEmpty(pass2)) {
                Toast.makeText(signup.this, "password does not match", Toast.LENGTH_SHORT).show();
                //progressBar.setVisibility(View.INVISIBLE);
                signupvalidpass.requestFocus();

            }

           else  if (!pass1.equals(pass2)) {
                Toast.makeText(signup.this, "sorry,password does not match", Toast.LENGTH_SHORT).show();
               // progressBar.setVisibility(View.INVISIBLE);
            }
           else if (pass1.length() < 6) {
                Toast.makeText(signup.this, "pleasee enter a password of more than 4 alphabets", Toast.LENGTH_SHORT).show();
                //progressBar.setVisibility(View.INVISIBLE);
                signuppass.requestFocus();

            }
          else  if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
           {
               Toast.makeText(signup.this,"please enter a valid email address",Toast.LENGTH_SHORT).show();



           }
                   else {

                mauth.createUserWithEmailAndPassword(mail, pass1).addOnCompleteListener(signup.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                          sendVerificationEmail();
                            Toast.makeText(signup.this, "registration succesfull", Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                        }

                    }


                });


//        PhoneAuthProvider.getInstance().verifyPhoneNumber(number.getText().toString(),
//                60,
//                TimeUnit.SECONDS,
//                getActivity(),
//                mCallbacks);



            }
        }


    });
     login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(signup.this,login_page.class));


         }
     });
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    // NOTE: this Activity should get onpen only when the user is not signed in, otherwise
                    // the user will receive another verification email.
                   sendVerificationEmail();
                } else {
                    // User is signed out

                }
                // ...

            }
        };

    }

    public void onBackPressed() {
        super.onBackPressed();
       startActivity(new Intent(signup.this,login_page.class));
    }


    private void sendVerificationEmail() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // email sent


                            // after email is sent just logout the user and finish this activity
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(signup.this, login_page.class));
                            finish();
                        }
                        else
                        {
                            // email not sent, so display message and restart the activity or do whatever you wish to do

                            //restart this activity
                            overridePendingTransition(0, 0);
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());

                        }
                    }
                });
    }


}
