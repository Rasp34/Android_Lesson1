package com.develop.art_me.createobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroupPlacement;
    TextView textNumberObjects;
    Button buttonCreateObject;
    Button buttonClearAll;
    LinearLayout layoutMain;
    String str;

    int iNumberObject = 0;
    int wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupPlacement = (RadioGroup) findViewById(R.id.radioGroup);
        textNumberObjects = (TextView) findViewById(R.id.textNumberObjects);
        buttonCreateObject = (Button) findViewById(R.id.buttonCreateObject);
        buttonClearAll = (Button) findViewById(R.id.buttonClearDisplay);
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);

        buttonCreateObject.setOnClickListener(this);
        buttonClearAll.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Log.d("Debug", "Invoke listener");

        switch (v.getId()) {

            case R.id.buttonCreateObject :

                Log.d("Debug", "buttonCreateObject" );

                Log.d("Debug", "Create LayoutParams" );

//                Создаем LayoutParams со значениями высоты и ширины
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);

                Log.d("Debug", "Gravity set" );

//                Выравнивание внутри Layout
                int buttonPlacement = Gravity.START;

//                Определим выбранное значение в RadioGroup
                switch (radioGroupPlacement.getCheckedRadioButtonId()){


                    case R.id.radioButtonLeft :
                        buttonPlacement = Gravity.START;
                        break;
                    case R.id.radioButtonCenter :
                        buttonPlacement = Gravity.CENTER;
                        break;
                    case R.id.radioButtonRight :
                        buttonPlacement = Gravity.END;
                        break;

                }

                Log.d("Debug", "Counter button" );
//                Увеличим счетчик кнопок
                iNumberObject++;
                str = Integer.valueOf(iNumberObject).toString();
                textNumberObjects.setText(str);

                Log.d("Debug", "Create new Button" );
//                Присвоим выбранное значение размещения
                layoutParams.gravity = buttonPlacement;

//                Создадим кнопку
                Button createdButton = new Button(this);
                str = "btn" + (Integer.valueOf(iNumberObject).toString());
                createdButton.setText(str);

                Log.d("Debug", "Add new button" );

//                Добавим кнопку с параметрами на Layout
                layoutMain.addView(createdButton, layoutParams);

                break;

//            Очистка дисплея
            case R.id.buttonClearDisplay :

                Log.d("Debug", "Clear display" );

                layoutMain.removeAllViews();
                Toast.makeText(this, "Clear display", Toast.LENGTH_SHORT).show();
                iNumberObject = 0;
                str = Integer.valueOf(iNumberObject).toString();
                textNumberObjects.setText(str);
                break;

        }



    }
}
