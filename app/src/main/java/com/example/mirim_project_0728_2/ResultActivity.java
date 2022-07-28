package com.example.mirim_project_0728_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        String[] imgName = intent.getStringArrayExtra("imgName");
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        TextView[] tv = new TextView[imgName.length];
        int[] textId = {R.id.text01, R.id.text02, R.id.text03, R.id.text04, R.id.text05, R.id.text06, R.id.text07, R.id.text08, R.id.text09};
        RatingBar[] rb = new RatingBar[voteCount.length];
        int[] rbId = {R.id.rating01, R.id.rating02, R.id.rating03, R.id.rating04, R.id.rating05, R.id.rating06, R.id.rating07, R.id.rating08, R.id.rating09};

        for(int i=0; i< imgName.length; i++){
            tv[i] = findViewById(textId[i]);
            rb[i] = findViewById(rbId[i]);
            tv[i].setText(imgName[i]);
            rb[i].setRating(voteCount[i]);
        }

        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}