package com.develop.art_me.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView textDisplayMenuItem;
    CheckBox checkAdvancedMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDisplayMenuItem = (TextView) findViewById(R.id.textDisplayMenu);
        checkAdvancedMenu = (CheckBox) findViewById(R.id.checkAdvancedMenu);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*Hand creating menu*/
/*        menu.add(1, 0, 0, "Cat");
        menu.add(1, 1, 1, "Dog");
        menu.add(1, 2, 2, "Raccoon");
        menu.add(2, 3, 3, "Alien");
        menu.add(2, 4, 4, "Predator");
        menu.add(2, 5, 5, "Human");*/

        getMenuInflater().inflate(R.menu.mymenu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    //Обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Create toast
        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();

        //Create string for textView
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Item selected:");
        stringBuilder.append("\r\n group: " + item.getGroupId());
        stringBuilder.append("\r\n itemID: " + item.getItemId());
        stringBuilder.append("\r\n title: " + item.getTitle());

        textDisplayMenuItem.setText(stringBuilder.toString());

        return super.onOptionsItemSelected(item);
    }

    //Обновление меню, метод выполняется при вызове меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.group1, true);
        menu.setGroupVisible(R.id.group2, checkAdvancedMenu.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }
}
