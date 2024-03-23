package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {
    Button btnPush;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPush = findViewById(R.id.btnPush);
//        btnPush.setOnClickListener(this);
//        btnPush.setOnClickListener(new MyListnener());
        MyListnener listnener = new MyListnener();
        btnPush.setOnClickListener(listnener);


    }

    class MyListnener implements View.OnClickListener { // 내부 클래스 생성
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "내이름은 안드로이드",
                    Toast.LENGTH_SHORT).show();
        }
    }

}