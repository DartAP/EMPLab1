package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListeners();
    }

    public void addListeners() {
        final TextView input = (TextView) findViewById(R.id.inputField);
        final TextView output = (TextView) findViewById(R.id.outputField);

        final Button btn0 = (Button) findViewById(R.id.zeroBtn);
        final Button btn1 = (Button) findViewById(R.id.oneBtn);
        final Button btn2 = (Button) findViewById(R.id.twoBtn);
        final Button btn3 = (Button) findViewById(R.id.threeBtn);
        final Button btn4 = (Button) findViewById(R.id.fourBtn);
        final Button btn5 = (Button) findViewById(R.id.fiveBtn);
        final Button btn6 = (Button) findViewById(R.id.sixBtn);
        final Button btn7 = (Button) findViewById(R.id.sevenBtn);
        final Button btn8 = (Button) findViewById(R.id.eightBtn);
        final Button btn9 = (Button) findViewById(R.id.nineBtn);

        final Button btnPlus = (Button) findViewById(R.id.plusBtn);
        final Button btnEqual = (Button) findViewById(R.id.equalBtn);
        final Button btnMinus = (Button) findViewById(R.id.minusBtn);
        final Button btnMulti = (Button) findViewById(R.id.multiplyBtn);
        final Button btnDiv = (Button) findViewById(R.id.divideBtn);
        final Button btnPoint = (Button) findViewById(R.id.pointBtn);
        final Button btnTMinus = (Button) findViewById(R.id.plusToMinusBtn);
        final Button btnSqrt = (Button) findViewById(R.id.sqrtBtn);
        final Button btnClear = (Button) findViewById(R.id.clearBtn);
        final Button btnBack = (Button) findViewById(R.id.backspaceBtn);

        btn0.setOnClickListener(new BtnEvents(input));
        btn1.setOnClickListener(new BtnEvents(input));
        btn2.setOnClickListener(new BtnEvents(input));
        btn3.setOnClickListener(new BtnEvents(input));
        btn4.setOnClickListener(new BtnEvents(input));
        btn5.setOnClickListener(new BtnEvents(input));
        btn6.setOnClickListener(new BtnEvents(input));
        btn7.setOnClickListener(new BtnEvents(input));
        btn8.setOnClickListener(new BtnEvents(input));
        btn9.setOnClickListener(new BtnEvents(input));

        btnPlus.setOnClickListener(new BtnActionEvents(input, output));
        btnEqual.setOnClickListener(new BtnActionEvents(input, output));
        btnMinus.setOnClickListener(new BtnActionEvents(input, output));
        btnMulti.setOnClickListener(new BtnActionEvents(input, output));
        btnDiv.setOnClickListener(new BtnActionEvents(input, output));
        btnPoint.setOnClickListener(new BtnActionEvents(input, output));
        btnTMinus.setOnClickListener(new BtnActionEvents(input, output));
        btnSqrt.setOnClickListener(new BtnActionEvents(input, output));
        btnClear.setOnClickListener(new BtnActionEvents(input, output));
        btnBack.setOnClickListener(new BtnActionEvents(input, output));
    }

}
