package com.example.mirim_project_0519;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear_ty, linear_rj, linear_win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear_ty = findViewById(R.id.linear_ty);
        linear_rj = findViewById(R.id.linear_rj);
        linear_win = findViewById(R.id.linear_win);

        Button btn_yellow = findViewById(R.id.btn_ty);
        Button btn_green = findViewById(R.id.btn_rj);
        Button btn_blue = findViewById(R.id.btn_win);

        btn_green.setOnClickListener(btnListener);
        btn_yellow.setOnClickListener(btnListener);
        btn_blue.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //안 보이게 하기
            linear_ty.setVisibility(View.INVISIBLE);
            linear_rj.setVisibility(View.INVISIBLE);
            linear_win.setVisibility(View.INVISIBLE);

            switch (view.getId()){
                case R.id.btn_ty:
                    linear_ty.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_rj:
                    linear_rj.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_win:
                    linear_win.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}