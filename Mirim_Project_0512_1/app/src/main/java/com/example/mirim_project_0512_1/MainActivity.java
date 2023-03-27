package com.example.mirim_project_0512_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    int[] btnNumsId = {R.id.btn, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    Button[] btnNums = new Button[btnNumsId.length];
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        textResult = findViewById(R.id.result);
        Button btnPlus = findViewById(R.id.plus);
        Button btnMinus = findViewById(R.id.minus);
        Button btnMulti = findViewById(R.id.multi);
        Button btndivide = findViewById(R.id.div);

        for(int i=0; i< btnNums.length; i++){
            final int index = i;
            btnNums[i] = findViewById(btnNumsId[i]);
            btnNums[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = "";
                    if(edit1.isFocused()){
                        s = edit1.getText().toString() + btnNums[index].getText();
                        edit1.setText(s);
                    } else if(edit2.isFocused()){
                        s = edit2.getText().toString() + btnNums[index].getText();
                        edit2.setText(s);
                    } else {
                        Toast.makeText(getApplicationContext(), "EditText에 포커스가 없습니다", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnPlus.setOnClickListener(btnListener);
        btnMinus.setOnClickListener(btnListener);
        btnMulti.setOnClickListener(btnListener);
        btndivide.setOnClickListener(btnListener);


    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int num1 = Integer.parseInt(edit1.getText().toString());
            int num2 = Integer.parseInt(edit2.getText().toString());

            int  result =0;
            switch (view.getId()){
                case R.id.plus:
                    result = num1+num2;
                    break;
                case R.id.minus:
                    result= num1-num2;
                    break;
                case  R.id.multi:
                    result = num1*num2;
                    break;
                case  R.id.div:
                    result = num1/num2;
                    break;
            }
            textResult.setText("결과 : "+result);
        }
    };
}