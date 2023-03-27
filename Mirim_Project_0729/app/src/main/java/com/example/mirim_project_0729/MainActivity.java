package com.example.mirim_project_0729;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPlus = findViewById(R.id.btn_plus);
        btnPlus.setOnClickListener(btnPlusListener);
        rg = findViewById(R.id.rg);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            int result = data.getIntExtra("result", 0);
            Toast.makeText(getApplicationContext(), "계산결과 : "+result, Toast.LENGTH_LONG).show();
        }
    }

    View.OnClickListener btnPlusListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            switch (rg.getCheckedRadioButtonId()){
                case R.id.rb1 :
                    intent.putExtra("calc", "+");
                    break;
                case R.id.rb2 :
                    intent.putExtra("calc", "-");
                    break;
                case R.id.rb3 :
                    intent.putExtra("calc", "*");
                    break;
                case R.id.rb4 :
                    intent.putExtra("calc", "/");
                    break;

            }
            intent.putExtra("num1", Integer.parseInt(edit1.getText().toString()));
            intent.putExtra("num2", Integer.parseInt(edit2.getText().toString()));
            startActivityForResult(intent, 0);
        }
    };
}