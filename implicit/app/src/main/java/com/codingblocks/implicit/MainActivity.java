package com.codingblocks.implicit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 Button call,web,mail;
 EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call = findViewById(R.id.phone);
        web = findViewById(R.id.web);
        mail = findViewById(R.id.mail);
        text=findViewById(R.id.text);
        call.setOnClickListener(this);
        web.setOnClickListener(this);
        mail.setOnClickListener(this);

    }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            String  input;
            input = (text.getText().toString());
            switch(v.getId()) {

                case (R.id.web):

                    intent.setAction(intent.ACTION_VIEW);
                    if (!input.startsWith("https://") || !input.startsWith("https://")) {
                        input = "https://" + input;
                    }
                    intent.setData(Uri.parse(input));
                    startActivity(intent);

                    break;
                case (R.id.phone):
                    try {

                        if (!input.startsWith("tel")) {
                            input = "tel:" + input;
                        }

                        intent.setAction(intent.ACTION_DIAL);

                        intent.setData(Uri.parse(input));
                        if(intent.getData()!=null)
                        {
                            throw new Exception("invalid input");
                        }
                     else

                        startActivity(intent);
                    }
          catch (Exception e)
          {
              Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
          }
                    break;
                case(R.id.mail):
                    if(!input.startsWith("mailto"))
                    {
                        input="mailto:"+input;
                    }

                    intent.setAction(intent.ACTION_SENDTO);
                    intent.setData(Uri.parse(input));
                    startActivity(intent);
                    break;

            }

        }
    }

