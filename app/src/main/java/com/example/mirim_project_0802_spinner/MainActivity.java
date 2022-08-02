package com.example.mirim_project_0802_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String[] items = {"태용", "윈윈", "정우", "마크", "런쥔", "제노", "해찬", "양양", "천러", "지성"};
    int[] itemIds = {R.drawable.taeyong, R.drawable.winwin, R.drawable.jungwoo, R.drawable.mark, R.drawable.renjun,
            R.drawable.jeno, R.drawable.haechan, R.drawable.yangyang, R.drawable.chenle, R.drawable.jisung};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View view, int i, long id) {
                ImageView ivPoster = findViewById(R.id.imgv);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setPadding(5, 5, 5, 5);
                ivPoster.setImageResource(itemIds[i]);
            }
            public void onNothingSelected(AdapterView<?> arg0) { }
        });
    }


}