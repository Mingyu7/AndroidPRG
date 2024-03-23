package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPush;
    EditText edtName;

    /* @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         btnPush = findViewById(R.id.btnPush);
         btnPush.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(getApplicationContext(),"내이름은 안드로이드",
                         Toast.LENGTH_SHORT).show();
             }
         });*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPush = findViewById(R.id.btnPush);
        edtName=findViewById(R.id.edtName);

        btnPush.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "버튼이 눌러졌습니다",
                Toast.LENGTH_SHORT).show();
    }
}