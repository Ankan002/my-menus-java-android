package com.exponents.mymenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView colorfulText;
    Button changeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.hook();
        this.useEffect();
    }

    private void hook(){
        colorfulText = findViewById(R.id.colorful_text);
        changeText = findViewById(R.id.change_text);
    }

    private void useEffect(){
        registerForContextMenu(changeText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 101, 1, "GREEN");
        menu.add(1, 102, 1, "PINK");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(1, 201, 1, "CODER");
        menu.add(1, 202, 1, "GAMER");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case 201:
                colorfulText.setText(getResources().getText(R.string.coder));
                break;
            case 202:
                colorfulText.setText(getResources().getText(R.string.gamer));
                break;
            default:
                colorfulText.setText(getResources().getText(R.string.my_color_changes_with_menu));
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case 101:
                colorfulText.setTextColor(getResources().getColor(R.color.green_text));
                break;
            case 102:
                colorfulText.setTextColor(getResources().getColor(R.color.toast_message));
                break;
            default:
                colorfulText.setTextColor(getResources().getColor(R.color.red_text));
        }

        return super.onOptionsItemSelected(item);
    }
}