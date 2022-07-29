package com.example.mirim_project_0729;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);
        String calc = intent.getStringExtra("calc");
        if(calc.equals("+")) result = num1+num2;
        else if(calc.equals("-")) result = num1-num2;
        else if(calc.equals("*")) result = num1*num2;
        else if(calc.equals("/")) result = num1/num2;

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(btnBackListener);
    }
    View.OnClickListener btnBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("result", result);
            setResult(RESULT_OK, intent);
            finish();
        }
    };
}