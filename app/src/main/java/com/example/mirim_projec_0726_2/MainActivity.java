package com.example.mirim_projec_0726_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear = findViewById(R.id.linear);
        Button btn1 = findViewById(R.id.btn_bg);
        btn2 = findViewById(R.id.btn_btn);
        registerForContextMenu(btn1);
        registerForContextMenu(btn2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        switch (v.getId()) {
            case R.id.btn_bg:
                menu.setHeaderTitle("배경색 변경");
                inflater.inflate(R.menu.menu1, menu);
                break;
            case R.id.btn_btn:
                menu.setHeaderTitle("버튼 변경");
                inflater.inflate(R.menu.menu2, menu);
                break;

        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.item_bg_black:
                linear.setBackgroundColor(Color.BLACK);
                return true;
            case R.id.item_bg_yellow:
                linear.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.item_bg_white:
                linear.setBackgroundColor(Color.WHITE);
                return true;
            case R.id.item_rotate:
                btn2.setRotation(50);
                return true;
            case R.id.item_zoom:
                btn2.setScaleX(2);
                return true;
        }
        return false;
    }
}