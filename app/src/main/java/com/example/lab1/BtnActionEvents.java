package com.example.lab1;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BtnActionEvents extends Activity implements View.OnClickListener {

    TextView input;
    TextView output;

    BtnActionEvents(TextView input, TextView output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void onClick(View v) {

        if ( output.getText().toString().matches(".*?=.*?") ) {
            if (!input.getText().toString().isEmpty())
            {
                output.setText(input.getText().toString());
            } else {
                output.setText("0");
            }
            input.setText("");
            return;
        }

        switch (v.getId())
        {
            case R.id.equalBtn: resultAction();
                break;
            case R.id.minusBtn: symbolAction("-");
                break;
            case R.id.plusBtn: symbolAction("+");
                break;
            case R.id.divideBtn: symbolAction("/");
                break;
            case R.id.multiplyBtn: symbolAction("*");
                break;
            case R.id.sqrtBtn: getSqrt();
                break;
            case R.id.plusToMinusBtn: tMinusEverything();
                break;
            case R.id.pointBtn: addPoint();
                break;
            case R.id.clearBtn: allClear();
                break;
            case R.id.backspaceBtn: backspaceAction();
                break;
        }
    }

    private boolean isInputEmpty() {
        String in = (String) input.getText();
        return in.isEmpty();
    }

    private void backspaceAction() {
        String in = (String) input.getText();
        if (!in.isEmpty())
            input.setText( in.substring(0, in.length()-1) );
    }

    private void allClear() {
        output.setText("");
        input.setText("");
    }

    private void getSqrt() {
        if (!isInputEmpty())
            input.setText( ( Math.sqrt( Double.parseDouble(input.getText().toString()) ) ) + "" );
    }

    private void tMinusEverything() {
        if (!isInputEmpty())
            input.setText( (Float.parseFloat(input.getText().toString()) * -1) + "" );
    }

    private void symbolAction(String symbol) {
        String out = (String) output.getText();
        String in = (String) input.getText();

        if ( out.isEmpty() && !in.isEmpty() ) {
            output.setText( in + symbol );
            input.setText("");
        } else if ( !out.isEmpty() && !in.isEmpty() ) {
            if ( out.matches("\\d+[+-/*]$") ) {
                output.setText( out + in );
            } else {
                output.setText( out + symbol + in );
            }
            input.setText("");
        }
    }

    private void resultAction() {

        String out = (String) output.getText();
        String in = (String) input.getText();

        Pattern p = Pattern.compile("[\\+\\-\\/\\*]");
        Matcher m = p.matcher(out);

        String[] actions = out.split("[\\+\\-\\/\\*]");
        int optIndex = 1;
        if ( actions[0].isEmpty() ) {
            return;
        }
        float result = Float.parseFloat( actions[0] );
        float parsedAction;
        boolean err = false;

        while (m.find()) {
            if ( !in.isEmpty() && actions.length <=1 ) {
                parsedAction = Float.parseFloat(in);
                out += in;
            } else {
                parsedAction = Float.parseFloat(actions[optIndex]);
            }
            switch ( m.toMatchResult().group() ){
                case "+": result += parsedAction;
                    break;
                case "-": result -= parsedAction;
                break;
                case "/":
                    if (parsedAction != 0.0) {
                        result /= parsedAction;
                    } else{
                        showDivideByZeroMsg();
                        output.setText("");
                        err = true;
                    }
                    break;
                case "*": result *= parsedAction;
                break;
            }
            optIndex++;
        }
        if (!err) {
            output.setText(out + "=");

            input.setText(result + "");
        }
    }

    private void showDivideByZeroMsg() {
        input.setText("Can't divide by zero");
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        input.setText("");
                    }
                },
                3000);
    }

    private void addPoint() {
        String in = (String) input.getText();
        if ( !in.matches("\\d+\\.\\d*") ) {
            input.setText(input.getText() + ".");
        }
    }
}
