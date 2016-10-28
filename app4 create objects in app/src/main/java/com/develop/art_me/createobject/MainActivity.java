package com.develop.art_me.createobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroupPlacement;
    TextView textNumberObjects;
    Button buttonCreateObject;
    Button buttonClearAll;

    int iNumberObject = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupPlacement = (RadioGroup) findViewById(R.id.radioGroup);
        textNumberObjects = (TextView) findViewById(R.id.textNumberObjects);
        buttonCreateObject = (Button) findViewById(R.id.buttonCreateObject);
        buttonClearAll = (Button) findViewById(R.id.buttonClearDisplay);

    }

    @Override
    public void onClick(View v) {

    }
}
