package com.develop.art_me.app5weightswitchv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    SeekBar topSeekBar;
    Button leftButton, rightButton;

    LinearLayout.LayoutParams layoutParamsLeft, layoutParamsRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topSeekBar = (SeekBar) findViewById(R.id.seekBar);
        topSeekBar.setOnSeekBarChangeListener(this);
        leftButton = (Button) findViewById(R.id.leftButton);
        rightButton = (Button) findViewById(R.id.rightButton);

        layoutParamsLeft = (LinearLayout.LayoutParams) leftButton.getLayoutParams();
        layoutParamsRight = (LinearLayout.LayoutParams) rightButton.getLayoutParams();



    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        int leftProgress = progress;
        int rightProgress = seekBar.getMax() - progress;

        layoutParamsLeft.weight = leftProgress;
        layoutParamsRight.weight = rightProgress;

        leftButton.setText(Integer.toString(leftProgress));
        rightButton.setText(Integer.toString(rightProgress));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
