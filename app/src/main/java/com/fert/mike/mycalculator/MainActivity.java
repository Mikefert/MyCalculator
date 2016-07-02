package com.fert.mike.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
    double result;
    double first_number;
    double second_number;
    boolean decimal = false,flag=false,sum=false,sub=false,div=false,mult=false,dec=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        btn0=(Button) findViewById(R.id.button0);
        btn1=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button2);
        btn3=(Button) findViewById(R.id.button3);
        btn4=(Button) findViewById(R.id.button4);
        btn5=(Button) findViewById(R.id.button5);
        btn6=(Button) findViewById(R.id.button6);
        btn7=(Button) findViewById(R.id.button7);
        btn8=(Button) findViewById(R.id.button8);
        btn9=(Button) findViewById(R.id.button9);

        btn10=(Button) findViewById(R.id.button10);
        btn11=(Button) findViewById(R.id.button11);
        btn12=(Button) findViewById(R.id.button12);
        btn13=(Button) findViewById(R.id.button13);
        btn14=(Button) findViewById(R.id.button14);
        btn15=(Button) findViewById(R.id.button15);
        btn16=(Button) findViewById(R.id.button16);

        btn0.setOnClickListener(onClickListener);
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
        btn9.setOnClickListener(onClickListener);

        btn10.setOnClickListener(onClickListener);
        btn11.setOnClickListener(onClickListener);
        btn12.setOnClickListener(onClickListener);
        btn13.setOnClickListener(onClickListener);
        btn14.setOnClickListener(onClickListener);
        btn15.setOnClickListener(onClickListener);
        btn16.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            int i=view.getId();
            String string=textView.getText().toString();
            switch(i){
                case R.id.button0:
                    textView.setText(string+"0");
                    break;
                case R.id.button1:
                    textView.setText(string+"1");
                    break;
                case R.id.button2:
                    textView.setText(string+"2");
                    break;
                case R.id.button3:
                    textView.setText(string+"3");
                    break;
                case R.id.button4:
                    textView.setText(string+"4");
                    break;
                case R.id.button5:
                    textView.setText(string+"5");
                    break;
                case R.id.button6:
                    textView.setText(string+"6");
                    break;
                case R.id.button7:
                    textView.setText(string+"7");
                    break;
                case R.id.button8:
                    textView.setText(string+"8");
                    break;
                case R.id.button9:
                    textView.setText(string+"9");
                    break;


                case R.id.button10:
                    textView.setText("");
                    decimal=false;
                    break;
                case R.id.button15:
                    textView.setText(string+".");
                    decimal=true;
                    break;
                case R.id.button11:
                    if(div!=true)
                    textView.setText(string+"/");
                    div=true;
                    break;
                case R.id.button12:
                    if(mult!=true)
                    textView.setText(string+"*");
                    mult=true;
                    break;
                case R.id.button13:
                    if (sub!=true)
                    textView.setText(string+"-");
                    sub=true;
                    break;
                case R.id.button14:
                    if(sum!=true)
                    textView.setText(string+"+");
                    sum=true;
                    break;
                case R.id.button16:
                    if(dec!=true)
                    textView.setText(string+".");
                    dec=true;
                    break;
            }
        }
    };





    public double sum(double first,double second){
        result = first+second;
        return  result;
    }
    public double substitution(double first,double second){
        result = first-second;
        return  result;
    }
    public double multiplication(double first,double second){
        result = first*second;
        return  result;
    }
    public double division(double first,double second){
        result = first/second;
        return  result;
    }
}
