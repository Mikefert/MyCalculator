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
                    MatchParser p;
                    p = new MatchParser();
                    try {
                        System.out.println(p.Parse(string));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
            if (!textView.getText().toString().equals(""))
                result(textView.getText().toString());
            else
                textView2.setText("");
           /* try {
                MatchParser p;
                p = new MatchParser();
                System.out.println(p.Parse(string));
            } catch (Exception e) {
                e.printStackTrace();
            }*/
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

class Result {

    public double acc;
    public String rest;

    public Result(double v, String r) {
        this.acc = v;
        this.rest = r;
    }
}

class MatchParser {
    private HashMap<String, Double> variables;

    public MatchParser() {
        variables = new HashMap<String, Double>();
    }

    public void setVariable(String variableName, Double variableValue) {
        variables.put(variableName, variableValue);
    }

    public Double getVariable(String variableName) {
        if (!variables.containsKey(variableName)) {
            System.err.println("Error: Try get unexists variable '" + variableName + "'");
            return 0.0;
        }
        return variables.get(variableName);
    }

    public double Parse(String s) throws Exception {
        Result result = PlusMinus(s);
        if (!result.rest.isEmpty()) {
            System.err.println("Error: can't full parse");
            System.err.println("rest: " + result.rest);
        }
        return result.acc;
    }

    private Result PlusMinus(String s) throws Exception {
        Result current = MulDiv(s);
        double acc = current.acc;

        while (current.rest.length() > 0) {
            if (!(current.rest.charAt(0) == '+' || current.rest.charAt(0) == '-')) break;

            char sign = current.rest.charAt(0);
            String next = current.rest.substring(1);

            current = MulDiv(next);
            if (sign == '+') {
                acc += current.acc;
            } else {
                acc -= current.acc;
            }
        }
        return new Result(acc, current.rest);
    }

    private Result Bracket(String s) throws Exception {
        char zeroChar = s.charAt(0);
        if (zeroChar == '(') {
            Result r = PlusMinus(s.substring(1));
            if (!r.rest.isEmpty() && r.rest.charAt(0) == ')') {
                r.rest = r.rest.substring(1);
            } else {
                System.err.println("Error: not close bracket");
            }
            return r;
        }
        return FunctionVariable(s);
    }

    private Result FunctionVariable(String s) throws Exception {
        String f = "";
        int i = 0;
        // ищем название функции или переменной
        // имя обязательно должна начинаться с буквы
        while (i < s.length() && (Character.isLetter(s.charAt(i)) || (Character.isDigit(s.charAt(i)) && i > 0))) {
            f += s.charAt(i);
            i++;
        }
        if (!f.isEmpty()) { // если что-нибудь нашли
            if (s.length() > i && s.charAt(i) == '(') { // и следующий символ скобка значит - это функция
                Result r = Bracket(s.substring(f.length()));
                return processFunction(f, r);
            } else { // иначе - это переменная
                return new Result(getVariable(f), s.substring(f.length()));
            }
        }
        return Num(s);
    }

    private Result MulDiv(String s) throws Exception {
        Result current = Bracket(s);

        double acc = current.acc;
        while (true) {
            if (current.rest.length() == 0) {
                return current;
            }
            char sign = current.rest.charAt(0);
            if ((sign != '*' && sign != '/')) return current;

            String next = current.rest.substring(1);
            Result right = Bracket(next);

            if (sign == '*') {
                acc *= right.acc;
            } else {
                acc /= right.acc;
            }

            current = new Result(acc, right.rest);
        }
    }

    private Result Num(String s) throws Exception {
        int i = 0;
        int dot_cnt = 0;
        boolean negative = false;
        // число также может начинаться с минуса
        if (s.charAt(0) == '-') {
            negative = true;
            s = s.substring(1);
        }
        // разрешаем только цифры и точку
        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
            // но также проверям, что в числе может быть только одна точка!
            if (s.charAt(i) == '.' && ++dot_cnt > 1) {
                throw new Exception("not valid number '" + s.substring(0, i + 1) + "'");
            }
            i++;
        }
        if (i == 0) { // что-либо похожее на число мы не нашли
            throw new Exception("can't get valid number in '" + s + "'");
        }

        double dPart = Double.parseDouble(s.substring(0, i));
        if (negative) dPart = -dPart;
        String restPart = s.substring(i);

        return new Result(dPart, restPart);
    }

    // Тут определяем все нашие функции, которыми мы можем пользоватся в формулах
    private Result processFunction(String func, Result r) {
        if (func.equals("sin")) {
            return new Result(Math.sin(Math.toRadians(r.acc)), r.rest);
        } else if (func.equals("cos")) {
            return new Result(Math.cos(Math.toRadians(r.acc)), r.rest);
        } else if (func.equals("tan")) {
            return new Result(Math.tan(Math.toRadians(r.acc)), r.rest);
        } else {
            System.err.println("function '" + func + "' is not defined");
        }
        return r;
    }
}
