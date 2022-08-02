package com.example.mirim_project_0802;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    int[] selfIds = {R.drawable.taeyong, R.drawable.winwin, R.drawable.jungwoo, R.drawable.mark,R.drawable.renjun,
            R.drawable.jeno, R.drawable.haechan,R.drawable.yangyang, R.drawable.chenle,R.drawable.jisung,
            R.drawable.taeyong, R.drawable.winwin, R.drawable.jungwoo, R.drawable.mark,R.drawable.renjun,
            R.drawable.jeno, R.drawable.haechan,R.drawable.yangyang, R.drawable.chenle,R.drawable.jisung,
            R.drawable.taeyong, R.drawable.winwin, R.drawable.jungwoo, R.drawable.mark,R.drawable.renjun,
            R.drawable.jeno, R.drawable.haechan,R.drawable.yangyang, R.drawable.chenle,R.drawable.jisung};
    String[] selfName = {"태용", "윈윈", "정우", "마크", "런쥔", "제노", "해찬", "양양", "천러", "지성",
            "태용", "윈윈", "정우", "마크", "런쥔", "제노", "해찬", "양양", "천러", "지성",
            "태용", "윈윈", "정우", "마크", "런쥔", "제노", "해찬", "양양", "천러", "지성"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("엔시티 셀카 모음");
        gridView = findViewById(R.id.gridv);
        SelfAdapter adapter = new SelfAdapter(this);
        gridView.setAdapter(adapter);

    }

    public class SelfAdapter extends BaseAdapter {
        Context context;
        public SelfAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return selfIds.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);

            GridView.LayoutParams params = new GridView.LayoutParams(200,300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setPadding(5, 5, 5, 5);
            imgv.setImageResource(selfIds[i]);
            final int pos = i;
            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle(selfName[pos]);
                    dlg.setIcon(selfIds[pos]);
                    View dlgView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    ImageView dlgImg = dlgView.findViewById(R.id.img_dlg);
                    dlgImg.setImageResource(selfIds[pos]);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return imgv;
        }
    }
}