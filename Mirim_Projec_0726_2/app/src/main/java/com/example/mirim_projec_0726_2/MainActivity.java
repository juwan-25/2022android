package com.example.mirim_projec_0726_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button btn2, btn5, btn6;
    String[] listArr = {"런쥔", "해찬", "천러"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear = findViewById(R.id.linear);
        Button btn1 = findViewById(R.id.btn_bg);
        btn2 = findViewById(R.id.btn_btn);
        registerForContextMenu(btn1);
        registerForContextMenu(btn2);
        Button btn3 = findViewById(R.id.btn_toast);
        btn3.setOnClickListener(toastListener);
        Button btn4 = findViewById(R.id.btn_dialog);
        btn4.setOnClickListener(dialogListener);
        btn5 = findViewById(R.id.btn_dialog_list);
        btn5.setOnClickListener(listDialogListener);
        btn6 = findViewById(R.id.btn_radio_list);
        btn6.setOnClickListener(radioDialogListener);
    }

    View.OnClickListener listDialogListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setIcon(R.drawable.dialogicon);
            dlg.setTitle("고양이는?");
            dlg.setItems(listArr, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    btn5.setText(listArr[i]);
                }
            });
            dlg.setNegativeButton("닫기", null);
            dlg.show();
        }
    };

    View.OnClickListener radioDialogListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setIcon(R.drawable.dialogicon);
            dlg.setTitle("고양이는?");
            dlg.setSingleChoiceItems(listArr, 0, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    btn5.setText(listArr[i]);
                }
            });
            dlg.setNegativeButton("닫기", null);
            dlg.show();
        }
    };

    View.OnClickListener toastListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast t = Toast.makeText(MainActivity.this, "토스트위치변경연습", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
    };

    View.OnClickListener dialogListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setIcon(R.drawable.dialogicon);
            dialog.setTitle("대화상자 연습");
            dialog.setMessage("여기는 대화상자가 들어갑니다");
            dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    linear.setBackgroundColor(Color.CYAN);
                }
            });
            dialog.setNegativeButton("취소", null);
            dialog.show();
        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        switch (v.getId()) {
            case R.id.btn_bg:
                menu.setHeaderTitle("배경색 변경");
                inflater.inflate(R.menu.menu1, menu);
                break;
            case R.id.btn_btn:
                menu.setHeaderTitle("버튼 변경");
                inflater.inflate(R.menu.menu2, menu);
                break;

        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.item_bg_black:
                linear.setBackgroundColor(Color.BLACK);
                return true;
            case R.id.item_bg_yellow:
                linear.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.item_bg_white:
                linear.setBackgroundColor(Color.WHITE);
                return true;
            case R.id.item_rotate:
                btn2.setRotation(50);
                return true;
            case R.id.item_zoom:
                btn2.setScaleX(2);
                return true;
            case R.id.item_return:
                btn2.setRotation(1);
                btn2.setScaleX(1);
                return true;

        }

        return false;
    }
}