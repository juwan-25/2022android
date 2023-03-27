package com.example.mirim_project_0727_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        TextView textTitle = findViewById(R.id.text_title);
        textTitle.setText(title);
        Button btnPrev = findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(btnPrevListener);
    }

    View.OnClickListener btnPrevListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}