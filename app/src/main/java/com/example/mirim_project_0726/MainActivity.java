package com.example.mirim_project_0726;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.img);
        editText = findViewById(R.id.edit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.itemrotate:
                imageView.setRotation(Float.parseFloat(editText.getText().toString()));
                return true;
            case R.id.item_renjun:
                item.setChecked(true);
                imageView.setImageResource(R.drawable.renjun);
                return true;
            case R.id.item_haechan:
                item.setChecked(true);
                imageView.setImageResource(R.drawable.haechan);
                return true;
            case R.id.item_chenle:
                item.setChecked(true);
                imageView.setImageResource(R.drawable.chenle);
                return true;
        }
        return false;
    }
}