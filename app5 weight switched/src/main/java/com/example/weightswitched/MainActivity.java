package com.example.weightswitched;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar seekBarWeight;
    Button buttonLeft;
    Button buttonRight;

    LinearLayout.LayoutParams layoutParams1;
    LinearLayout.LayoutParams layoutParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarWeight = (SeekBar) findViewById(R.id.seekBarWeight);
        buttonLeft = (Button) findViewById(R.id.buttonLeft);
        buttonRight = (Button) findViewById(R.id.buttonRight);

        layoutParams1 = (LinearLayout.LayoutParams) buttonLeft.getLayoutParams();
        layoutParams2 = (LinearLayout.LayoutParams) buttonRight.getLayoutParams();

        seekBarWeight.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

//        Установим значения для кнопок
        int leftWeight = progress;
        int rightWeight =  seekBar.getMax() - progress;

//        Установим значения для LayoutParams каждой кнопки
        layoutParams1.weight = leftWeight;
        layoutParams2.weight = rightWeight;

//        Необходимые методы для перерисовки Layout, иначе кнопки не изменят размера
//        В методе setText ниже он вызывается незаметно
        buttonLeft.requestLayout();
        buttonRight.requestLayout();

//        Установим текст
        String volume = Integer.valueOf(leftWeight).toString();
        buttonLeft.setText(volume);
        volume = Integer.valueOf(rightWeight).toString();
        buttonRight.setText(volume);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
