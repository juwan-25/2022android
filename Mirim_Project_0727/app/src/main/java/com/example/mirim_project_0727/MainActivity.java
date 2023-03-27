package com.example.mirim_project_0727;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCheck;
    String[] itemsArr = {"런쥔", "해찬", "천러"};
    boolean[] checkArr = {true, false, true};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCheck = findViewById(R.id.btn_check);
        btnCheck.setOnClickListener(btnCheckListener);
    }

    View.OnClickListener btnCheckListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("체크목록대화상자");
            dlg.setIcon(R.drawable.dialogicon);
            dlg.setMultiChoiceItems(itemsArr, checkArr, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    checkArr[i]=b;
                    btnCheck.setText("");
                    for(int j=0; j<checkArr.length; j++){
                        if(checkArr[j]) {
                            btnCheck.append(itemsArr[j]);
                        }
                    }
                    if(btnCheck.length()==0) btnCheck.setText("체크박스 목록 대화상자");
                }
            });
            dlg.setNegativeButton("닫기", null);
            dlg.show();
        }
    };
}