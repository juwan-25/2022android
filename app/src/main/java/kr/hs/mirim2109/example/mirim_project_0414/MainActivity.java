package kr.hs.mirim2109.example.mirim_project_0414;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    CheckBox checkStart;
    ImageView imgv;
    LinearLayout linearSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearSub = findViewById(R.id.linear_sub);
        rg = findViewById(R.id.rg);
        checkStart = findViewById(R.id.check_start);
        imgv = findViewById(R.id.imgv);
        Button btnDone = findViewById(R.id.btn_done);

        checkStart.setOnCheckedChangeListener(checkListener);


    }
    CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(checkStart.isChecked()){
                linearSub.setVisibility(View.VISIBLE);
            } else {
                linearSub.setVisibility(View.INVISIBLE);
            }
        }
    };
}