package com.codingblocks.trythriw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2 ;
    Button btn ;
    TextView txt1  ;


.    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.num1 ) ;
        et2 = findViewById(R.id.num2) ;
        btn = findViewById(R.id.res) ;
        txt1 = findViewById(R.id.answer) ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {

                    int num1 = Integer.parseInt(et1.getText().toString())  ;
                    int num2 = Integer.parseInt(et2.getText().toString())  ;


                    if(num2==0)
                        throw new Exception("NUmber is divided b 0")   ;
                    else
                        txt1.setText("hello");

                }
                catch ( Exception e )
                {

                        Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
