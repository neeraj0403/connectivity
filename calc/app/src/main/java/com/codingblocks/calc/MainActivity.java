package com.codingblocks.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btn0;
    private Button btn1 ;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private  Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button add;
    private Button subtract;
    private Button multiply;
    private Button  divide;
    private Button dualzero;
    private Button dot;
    private Button equals;
    private  Button clear;
    private Button edit;
    private Button modulus;
    private TextView editText;
    Integer value1=0;
    Integer value2=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clear=findViewById(R.id.clear);
        dualzero=findViewById(R.id.dualzero);
        btn0=findViewById(R.id.zero);
        btn1=findViewById(R.id.one);
        btn2=findViewById(R.id.two);
        btn3=findViewById(R.id.three);
        btn4=findViewById(R.id.four);
        btn5=findViewById(R.id.five);
        btn6=findViewById(R.id.six);
        btn7=findViewById(R.id.seven);
        btn8=findViewById(R.id.eight);
        btn9=findViewById(R.id.nine);
        add=findViewById(R.id.plus);
        subtract=findViewById(R.id.subtract);
        divide=findViewById(R.id.divide);
        dot=findViewById(R.id.dot);
        equals=findViewById(R.id.equals);
        edit=findViewById(R.id.edit);
        modulus=findViewById(R.id.modulus);
        editText=findViewById(R.id.Textview);

        dualzero.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"00");
            }
        });
        btn0.setOnClickListener(new  View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v) {
                                        editText.setText(editText.getText()+"0");
                                    }
                                }

        );
  btn1.setOnClickListener(new View.OnClickListener()
  {
      @Override
      public void onClick(View v) {
          editText.setText(editText.getText()+"1");
      }
  });
 btn2.setOnClickListener(new View.OnClickListener()
                         {

                             @Override
                             public void onClick(View v) {
                                 editText.setText(editText.getText()+"2");
                             }
                         }  );

 btn3.setOnClickListener(new View.OnClickListener()
 {
     @Override
     public void onClick(View v) {
         editText.setText(editText.getText()+"3");
     }
 });

btn4.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v) {
                                editText.setText(editText.getText()+"4");
                            }
                        }
);
btn5.setOnClickListener(new View.OnClickListener()
                        {

                            @Override
                            public void onClick(View v) {
                                editText.setText(editText.getText()+"5");
                            }
                        }

);
btn6.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                editText.setText(editText.getText()+"6");
            }
        });

          btn7.setOnClickListener(new View.OnClickListener()
    {

        @Override
        public void onClick(View v) {
        editText.setText(editText.getText()+"7");
    }
    });

btn8.setOnClickListener(new View.OnClickListener()
        {

@Override
public void onClick(View v) {
        editText.setText(editText.getText()+"8");
        }
        });


        btn9.setOnClickListener(new View.OnClickListener()
        {

@Override
public void onClick(View v) {
        editText.setText(editText.getText()+"0");
        }
        });
        }
 add.setOnClickListener(new  View.OnClickListener()
    {
        value1=Integer.parseInt(editText.getText())
    }
         );

}
