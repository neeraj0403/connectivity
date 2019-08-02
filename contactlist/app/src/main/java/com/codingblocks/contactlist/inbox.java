package com.codingblocks.contactlist;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class inbox extends AppCompatActivity {
EditText sendto;
TextInputEditText msg;
Button send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox_layout);
        sendto=findViewById(R.id.To);
        msg=findViewById(R.id.content);
        send=findViewById(R.id.msg1);
        final Intent intent1=getIntent();
        final String input=getIntent().getStringExtra("name");
        sendto.setText(input);
         final String text=sendto.getText().toString();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

//Get the SmsManager instance and call the sendTextMessage method to send message
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(text, null, msg.getText().toString(),pi,null);
            }
        });
    }
}
