package com.example.mirim_project_0803_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLClientInfoException;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    EditText editName, editMember, editResultName, editResultMember;
    Button btnSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInit = findViewById(R.id.btn_init);
        Button btnInsert = findViewById(R.id.btn_insert);
        btnSelect = findViewById(R.id.btn_select);
        Button btnUpdate = findViewById(R.id.btn_update);
        Button btnDelete = findViewById(R.id.btn_delete);

        btnInit.setOnClickListener(btnListener);
        btnSelect.setOnClickListener(btnListener);
        btnInsert.setOnClickListener(btnListener);
        btnUpdate.setOnClickListener(btnListener);
        btnDelete.setOnClickListener(btnListener);

        editName = findViewById(R.id.edit_name);
        editMember = findViewById(R.id.edit_member);
        editResultName = findViewById(R.id.edit_result_name);
        editResultMember = findViewById(R.id.edit_result_member);

        dbHelper = new DBHelper(this);

    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        SQLiteDatabase db;
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_init:
                    db = dbHelper.getWritableDatabase();
                    //초기화하려면 버전 업그레이드
                    dbHelper.onUpgrade(db, 1, 2);
                    break;
                case R.id.btn_insert:
                    db = dbHelper.getWritableDatabase();
                    db.execSQL("INSERT INTO idolTBL VALUES('"+editName.getText().toString()+"',"+editMember.getText().toString()+");");                    db.close();
                    Toast.makeText(getApplicationContext(), "새로운 idol 정보 추가 완료", Toast.LENGTH_SHORT).show();
                    editName.setText("");
                    editMember.setText("");
                    break;
                case R.id.btn_select:
                    db = dbHelper.getReadableDatabase();
                    Cursor c = db.rawQuery("SELECT * FROM idolTbl;",null);

                    String strName = "아이돌명\r\n__________\r\n";
                    String strMember = "인원수\r\n__________\r\n";

                    while (c.moveToNext()){
                        strName += c.getString(0) +"\r\n";
                        strMember += c.getString(1) +"\r\n";
                    }

                    editResultName.setText(strName);
                    editResultMember.setText(strMember);

                    c.close();
                    db.close();
                    break;
                case R.id.btn_update:
                    db = dbHelper.getWritableDatabase();
                    db.execSQL("UPDATE idolTbl SET cnt = "+editMember.getText().toString() +" where name = '"+editName.getText().toString()+"';");
                    editName.setText("");
                    editMember.setText("");
                    btnSelect.callOnClick();
                    db.close();
                    break;
                case R.id.btn_delete:
                    db = dbHelper.getWritableDatabase();
                    db.execSQL("DELETE FROM idolTbl WHERE name = '"+editName.getText().toString()+"';");
                    editName.setText("");
                    editMember.setText("");
                    btnSelect.callOnClick();
                    db.close();
                    break;
            }
        }
    };

    public class DBHelper extends SQLiteOpenHelper {

        //DB 생성
        public DBHelper(Context context) {
            //버전 올리면 데이터 사라짐
            super(context, "idolDB", null, 1);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table idolTbl(name char(30) primary key,"+"cnt integer);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists idolTbl");
            onCreate(db);
        }
    }
}