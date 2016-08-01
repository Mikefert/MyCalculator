package com.fert.mike.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;

import java.util.HashMap;

public class MainActivity extends Activity {
    TextView textView, textView2;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16;
    String string;
    JsEvaluator jsEvaluator;
    boolean allow_dot, operator_end = false;
    int count = 0;
    //MatchParser p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jsEvaluator = new JsEvaluator(this);


        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);

        btn10 = (Button) findViewById(R.id.button10);
        btn11 = (Button) findViewById(R.id.button11);
        btn12 = (Button) findViewById(R.id.button12);
        btn13 = (Button) findViewById(R.id.button13);
        btn14 = (Button) findViewById(R.id.button14);
        btn15 = (Button) findViewById(R.id.button15);
        btn16 = (Button) findViewById(R.id.button16);

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

        btn10.setOnLongClickListener(onLongClickListener);
    }

    View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            switch (view.getId()) {
                case R.id.button10:
                    string = textView.getText().toString();
                    operator_end = operator();
                    textView.setText("");
                    textView2.setText("");

                    allow_dot = false;
                    operator_end = false;
                    count = 0;
                    System.out.println(view.getId());
                    break;

            }
            return false;
        }
    };

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            string = textView.getText().toString();
            operator_end = operator();
            switch (view.getId()) {
                case R.id.button0:
                    textView.setText(string + "0");
                    if (count == 0)
                        allow_dot = true;
                    break;
                case R.id.button1:
                    textView.setText(string + "1");
                    if (count == 0)
                        allow_dot = true;
                    break;
                case R.id.button2:
                    textView.setText(string + "2");
                    if (count == 0)
                        allow_dot = true;
                    break;
                case R.id.button3:
                    textView.setText(string + "3");
                    if (count == 0)
                        allow_dot = true;
                    break;
                case R.id.button4:
                    textView.setText(string + "4");
                    if (count == 0)
                        allow_dot = true;
                    break;
                case R.id.button5:
                    textView.setText(string + "5");
                    if (count == 0)
                        allow_dot = true;
                    break;
                case R.id.button6:
                    textView.setText(string + "6");
                    if (count == 0)
                        allow_dot = true;
                    break;
                case R.id.button7:
                    textView.setText(string + "7");
                    if (count == 0)
                        allow_dot = true;
                    break;
                case R.id.button8:
                    textView.setText(string + "8");
                    if (count == 0)
                        allow_dot = true;
                    break;
                case R.id.button9:
                    textView.setText(string + "9");
                    if (count == 0)
                        allow_dot = true;
                    break;


                case R.id.button10:
                    if (string.length() != 0) {
                        if (string.endsWith(".")) {
                            allow_dot = true;
                            count = 0;
                        }
                        string = removeLastSymbol(string);
                        textView.setText(string);
                        operator_end = operator();

                        if (checkDecimal(string)) {
                            allow_dot = false;
                        } else if (count == 0) {
                            allow_dot = true;
                        }
                    }
                    break;


                case R.id.button11:
                    if (operator_end)
                        string = removeLastSymbol(string);
                    if (string.length() != 0) {
                        textView.setText(string + "/");
                        allow_dot = false;
                    }
                    count = 0;
                    break;
                case R.id.button12:
                    if (operator_end)
                        string = removeLastSymbol(string);
                    if (string.length() != 0) {
                        textView.setText(string + "*");
                        allow_dot = false;
                    }
                    count = 0;
                    break;
                case R.id.button13:
                    if (operator_end)
                        string = removeLastSymbol(string);
                    if (string.length() != 0) {
                        textView.setText(string + "-");
                        allow_dot = false;
                    }
                    count = 0;
                    break;
                case R.id.button14:
                    if (operator_end)
                        string = removeLastSymbol(string);
                    if (string.length() != 0) {
                        textView.setText(string + "+");
                        allow_dot = false;
                    }
                    count = 0;
                    break;
                case R.id.button15:
                    if (operator_end)
                        string = removeLastSymbol(string);
                    if (allow_dot) {
                        textView.setText(string + ".");
                        allow_dot = false;
                        count++;
                    }
                    break;
                case R.id.button16:
                    if (operator_end)
                        string = removeLastSymbol(string);
                    allow_dot = false;
                    Calculation calc;
                    calc = new Calculation(string);

                    try {

                        System.out.println(calc.start(string));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
            if (!textView.getText().toString().equals(""))
                result(textView.getText().toString());
            else
                textView2.setText("");
        }
    };


    public boolean operator() {
        String string = textView.getText().toString();
        if (string.endsWith("+") || string.endsWith("-") || string.endsWith("*") || string.endsWith("/") || string.endsWith("."))
            return true;
        return false;
    }

    public String removeLastSymbol(String string) {
        string = string.substring(0, string.length() - 1);
        return string;
    }

    public void result(String string) {
        jsEvaluator.evaluate(string, new JsCallback() {
            @Override
            public void onResult(final String result) {
                textView2.setText(result);
            }
        });
    }

    public boolean checkDecimal(String string) {
        if (string.length() != 0) {
            if (string.lastIndexOf(".") > string.lastIndexOf("+") && string.lastIndexOf(".") > string.lastIndexOf("-") && string.lastIndexOf(".") > string.lastIndexOf("*") && string.lastIndexOf(".") > string.lastIndexOf("/")) {
                return true;
            }
        }
        return false;
    }

    public String getString() {
        return string;
    }

}

