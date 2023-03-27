package com.example.mirim_project_0519_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Chronometer timer;
    RadioGroup rg;
    TimePicker time;
    DatePicker date;
    TextView text_result;
    int selectedYear, selectedMonth, selectedDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.timer);
        rg=findViewById(R.id.rg);
        time = findViewById((R.id.time));
        date = findViewById(R.id.date);
        text_result = findViewById(R.id.text_result);

        rg.setOnCheckedChangeListener(rgListener);

        time.setVisibility(View.INVISIBLE);
        date.setVisibility(View.INVISIBLE);
        rg.setVisibility(View.INVISIBLE);

        timer.setOnClickListener(timerListener);
        text_result.setOnLongClickListener(textListener);
        date.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                selectedYear = year;
                selectedMonth = month+1;
                selectedDay = day;
            }
        });

    }

    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            time.setVisibility(View.INVISIBLE);
            date.setVisibility(View.INVISIBLE);
            switch (checkedId) {
                case R.id.radio_date:
                    date.setVisibility((View.VISIBLE));
                    break;
                case R.id.radio_time:
                    time.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener timerListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            rg.setVisibility(View.VISIBLE);
            timer.setBase(SystemClock.elapsedRealtime());
            timer.start();
            timer.setTextColor(Color.RED);
        }
    };

    View.OnLongClickListener textListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            timer.stop();
            timer.setTextColor(Color.BLUE);
            text_result.setText(selectedYear+"년 "+selectedMonth+"월 "+selectedDay+"일 ");
            text_result.append(time.getCurrentHour()+"시 "+time.getCurrentMinute()+"분 예약 완료됨");
            return true;
        }
    };

}