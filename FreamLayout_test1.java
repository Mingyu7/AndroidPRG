package com.example.compoundtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FreamLayout_test1 extends AppCompatActivity {

    Button btnM1,btnM2,btnM3;
    LinearLayout layout1,layout2,layout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fream_layout_test1);

        btnM1 = findViewById(R.id.btnM1);
        btnM2 = findViewById(R.id.btnM2);
        btnM3 = findViewById(R.id.btnM3);

        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);

        btnM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setVisibility(View.VISIBLE); // 레이아웃 보이기
                layout2.setVisibility(View.INVISIBLE); // 레이아웃 숨기기
                layout3.setVisibility(View.INVISIBLE);
            }
        });

        btnM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setVisibility(View.INVISIBLE);
                layout2.setVisibility(View.VISIBLE);
                layout3.setVisibility(View.INVISIBLE);

            }
        });

        btnM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setVisibility(View.INVISIBLE);
                layout2.setVisibility(View.INVISIBLE);
                layout3.setVisibility(View.VISIBLE);

            }
        });
    }
}