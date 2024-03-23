package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {


    Button btnPush;
    EditText edtName;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPush = findViewById(R.id.btnPush);
        edtName=findViewById(R.id.edtName);
        btnPush.setOnClickListener(new View.OnClickListener() { //재사용 하지 않을때 무명 객체 사용
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                Toast.makeText(getApplicationContext(), "내이름은"+name,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }


}