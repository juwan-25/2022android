package com.example.mirim_project_0802_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] selfId = {R.drawable.taeyong, R.drawable.winwin, R.drawable.jungwoo, R.drawable.mark,R.drawable.renjun,
            R.drawable.jeno, R.drawable.haechan,R.drawable.yangyang, R.drawable.chenle,R.drawable.jisung };
    String[] selfName = {"태용", "윈윈", "정우", "마크", "런쥔", "제노", "해찬", "양양", "천러", "지성"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Gallery gallery = findViewById(R.id.gallery);
        GalleryAdapter adapter = new GalleryAdapter(this);
        gallery.setAdapter(adapter);
    }

    public class GalleryAdapter extends BaseAdapter {
        Context context;
        public GalleryAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return selfId.length;
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
            Gallery.LayoutParams params = new Gallery.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setImageResource(selfId[i]);
            final int pos = i;
            imgv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView largeImgv = findViewById(R.id.imgv);
                    largeImgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    largeImgv.setImageResource(selfId[pos]);

                    Toast toast = new Toast(getApplicationContext());
                    View toastView = View.inflate(getApplicationContext(), R.layout.toast, null);
                    TextView toastText = toastView.findViewById(R.id.text);
                    toastText.setText(selfName[pos]);
                    toast.setView(toastView);
                    toast.show();
                    return false;
                }
            });
            return imgv;
        }
    }
}