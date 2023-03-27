package com.example.mirim_project_0801;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String[] actions = {Intent.ACTION_DIAL, Intent.ACTION_VIEW, Intent.ACTION_VIEW, Intent.ACTION_WEB_SEARCH, Intent.ACTION_SENDTO, MediaStore.ACTION_IMAGE_CAPTURE};
        int[] btnIds = {R.id.btn_dial, R.id.btn_home, R.id.btn_map, R.id.btn_search, R.id.btn_text, R.id.btn_photo};
        Button[] btnArr = new Button[6];
        for(int i=0; i<btnArr.length; i++){
            btnArr[i] = findViewById(btnIds[i]);
            btnArr[i].setOnClickListener(btnArrListener);
        }
    }
    View.OnClickListener btnArrListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            Uri uri = null;
            switch (view.getId()) {
                case R.id.btn_dial:
                    uri = Uri.parse("tel:/01033337777");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    break;
                case R.id.btn_home:
                    uri = Uri.parse("https://e-mirim.hs.kr");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_map:
                    uri = Uri.parse("https://maps.google.co.kr/maps?q=37.687805,127.10445170000001&z=15");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_search:
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY,"미림여자정보과학고");
                    break;
                case R.id.btn_text:
                    uri = Uri.parse("smsto:"+Uri.encode("010-0606-0323"));
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body", "안녕하세영~ 반가워여어~!!");
                    intent.setData(uri);
                    break;
                case R.id.btn_photo:
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    break;
            }
            startActivity(intent);
        }
    };
}