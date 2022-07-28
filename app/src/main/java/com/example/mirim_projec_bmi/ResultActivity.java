package com.example.mirim_projec_bmi;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView textName = findViewById(R.id.text_name);
        textName.setText(name);
        double height = parseDouble(intent.getStringExtra("height"));
        double weight = parseDouble(intent.getStringExtra("weight"));
        Double BMI = weight / Math.pow(height/100, 2);
        TextView textBMI = findViewById(R.id.text_bmi);
        textBMI.setText(String.format("%.3f",BMI));

        TextView textWeight = findViewById(R.id.text_weight);
        ImageView imgBMI = findViewById(R.id.img_bmi);
        if(BMI<=18.5) {
            textWeight.setText("저체중");
            imgBMI.setImageResource(R.drawable.chenle3);
        } else if(BMI<=22.9) {
            textWeight.setText("정상체중");
            imgBMI.setImageResource(R.drawable.chenle4);
        } else if(BMI<=24.9) {
            textWeight.setText("과체중");
            imgBMI.setImageResource(R.drawable.chenle);
        } else {
            textWeight.setText("비만");
            imgBMI.setImageResource(R.drawable.chenle5);
        }

        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(btnHomeListener);

    }
    View.OnClickListener btnHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
