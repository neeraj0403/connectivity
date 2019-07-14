package com.codingblocks.webapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
 public EditText editText;
 public Button button;
 public WebView webView;
 String url="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edit);
        button=findViewById(R.id.click);
        webView=findViewById(R.id.view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url=editText.getText().toString()webViewClient = new WebViewClientImpl(this);
                webView.setWebViewClient(webViewClient);
            }
        });
    }
}
