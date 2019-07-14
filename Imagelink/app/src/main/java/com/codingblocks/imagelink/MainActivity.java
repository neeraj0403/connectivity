package com.codingblocks.imagelink;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.net.Uri;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
   private EditText edit;
   private Button button;
   private ImageView image;
   String url="https://www.google.com/imgres?imgurl=http%3A%2F%2Fen.es-static.us%2Fupl%2F2018%2F11%2Fmars-landing-curiosity-artist-e1543073738523.jpeg&imgrefurl=https%3A%2F%2Fearthsky.org%2Fspace%2Flanding-on-mars-is-still-hard&docid=CqY3BucqKybwrM&tbnid=nFsA5paAT_9EwM%3A&vet=10ahUKEwjnl9my5LHjAhUFTI8KHQiOBKoQMwh6KAIwAg..i&w=800&h=450&bih=981&biw=1851&q=mars%20images&ved=0ahUKEwjnl9my5LHjAhUFTI8KHQiOBKoQMwh6KAIwAg&iact=mrc&uact=8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit=findViewById(R.id.link);
        button=findViewById(R.id.click);
        image=findViewById(R.id.image);
        edit.setText("data:image/jpeg;base64,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");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               url=edit.getText().toString();
                Picasso.with(MainActivity.this).load(url).fit().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(image);

            }

        });

        }

}
