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
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Switch switchStart;
    ImageView imgv;
    LinearLayout linearSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearSub = findViewById(R.id.linear_sub);
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(rgListener);
        switchStart = findViewById(R.id.swtich_start);
        imgv = findViewById(R.id.imgv);
        switchStart.setOnCheckedChangeListener(switchListener);
        Button btnFinish = findViewById(R.id.btn_finish);
        btnFinish.setOnClickListener(btnListener);

    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };

    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int selected_id) {
            switch (selected_id) {
                case R.id.rb_dog:
                    imgv.setImageResource(R.drawable.dog);
                    break;
                case R.id.rb_cat:
                    imgv.setImageResource(R.drawable.cat);
                    break;
                case R.id.rb_rabbit:
                    imgv.setImageResource(R.drawable.rabbit);
                    break;

            }
        }

    };

    CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (switchStart.isChecked()) {
                linearSub.setVisibility(View.VISIBLE);
            } else {
                linearSub.setVisibility(View.INVISIBLE);
            }
        }
    };
}
