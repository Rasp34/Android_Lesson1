package com.develop.art_me.calculator_v01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1, editText2;
    Button button_pls, button_min, button_mux, button_div;
    TextView text_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.edit_text_1);
        editText2 = (EditText) findViewById(R.id.edit_text_2);
        button_pls = (Button) findViewById(R.id.button_plus);
        button_min = (Button) findViewById(R.id.button_minus);
        button_mux = (Button) findViewById(R.id.button_mux);
        button_div = (Button) findViewById(R.id.button_div);
        text_result = (TextView) findViewById(R.id.text_result);

        button_pls.setOnClickListener(this);
        button_min.setOnClickListener(this);
        button_mux.setOnClickListener(this);
        button_div.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        float num1 = 0;
        float num2 = 0;
        float res  = 0;

        String operation = "";

        if (TextUtils.isEmpty(editText1.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString())){
            return;
        }

        num1 = Float.parseFloat(editText1.getText().toString());
        num2 = Float.parseFloat(editText2.getText().toString());

        switch (v.getId()){
            case R.id.button_plus:
                res = num1 + num2;
                operation = "+";
                break;
            case R.id.button_minus:
                res = num1 - num2;
                operation = "-";
                break;
            case R.id.button_mux:
                res = num1*num2;
                operation = "*";
                break;
            case  R.id.button_div:
                res = num1/num2;
                operation = "-";
                break;
            default:
                break;
        }

        // Output string with result
        text_result.setText( num1 + " " + operation + " " + num2 + " = " + res );

    }
}
