package com.example.lab1;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class BtnEvents extends Activity implements OnClickListener {

    TextView input;

    BtnEvents(TextView input) {
        this.input = input;
    }

    BtnEvents() {

    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v.findViewById(v.getId());
        input.setText(input.getText().toString() + btn.getText());
    }
}
