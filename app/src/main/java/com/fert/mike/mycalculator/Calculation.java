package com.fert.mike.mycalculator;

import android.util.Log;
class Result{
    double num;
    String rest;
    Result(double num,String rest){
        this.num=num;
        this.rest =rest;
    }
}
 class Calculation {
    String s;
    Calculation(String s){
        this.s=s;
    }

    double start(String s){
        Result result=plusMinus(s);
        return result.num;
    }

    Result plusMinus(String s){
        Result result=multDiv(s);
        double number=result.num;

        while(result.rest.length()>0) {
            if (!(result.rest.charAt(0)=='+' || result.rest.charAt(0) == '-'))
                break;
            char sign=result.rest.charAt(0);
            String next=result.rest.substring(1);
            result=multDiv(next);

            if(sign == '+')
                number+=result.num;
            else
                number-=result.num;
        }
        return new Result(number,result.rest);
    }

    Result multDiv(String s) {
        Result result = brackets(s);

        double number = result.num;
        while (true) {
            if (result.rest.length() == 0) {
                return result;
            }
            char sign = result.rest.charAt(0);
            if ((sign != '*' && sign != '/')) return result;

            String next = result.rest.substring(1);
            Result right = brackets(next);

            if (sign == '*') {
                number *= right.num;
            } else {
                number /= right.num;
            }

            result = new Result(number, right.rest);
        }
    }

    Result brackets(String s){
        char zeroChar = s.charAt(0);
        if (zeroChar == '(') {
            Result result = plusMinus(s.substring(1));
            if (!result.rest.isEmpty() && result.rest.charAt(0) == ')') {
                result.rest = result.rest.substring(1);
            } else {
                Log.e("ERROR","Brackets should be closed!");
            }
            return result;
        }
        return number(s);
    }

    Result number(String s){
        int i=0;
        double number;
        boolean negative=false;
        if( s.charAt(0) == '-' ){
            negative = true;
            s = s.substring( 1 );
        }
        while(i<s.length()&&(Character.isDigit(s.charAt(i))||s.charAt(i)=='.')){
            i++;
        }
        number =Double.parseDouble(s.substring(0, i));
        if(negative){
            number=-number;
        }
        String rest=s.substring(i);
        return new Result(number,rest);

    }
}
