package com.example.mysimplecal;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtNum1, edtNum2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod, btnRs;
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 계산기");

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnMod = findViewById(R.id.btnMod);
        btnRs = findViewById(R.id.btnRs);
        txtResult = findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnRs.setOnClickListener(this);

        /*
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snum1 = edtNum1.getText().toString();
                String snum2 = edtNum2.getText().toString();
                int num1 = Integer.parseInt(snum1);
                int num2 = Integer.parseInt(snum2);
                int result = num1 + num2;
                txtResult.setText("결과:" + result);
            }

        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snum1 = edtNum1.getText().toString();
                String snum2 = edtNum2.getText().toString();
                int num1 = Integer.parseInt(snum1);
                int num2 = Integer.parseInt(snum2);
                int result = num1 - num2;
                txtResult.setText("결과:" + result);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snum1=edtNum1.getText().toString();
                String snum2=edtNum2.getText().toString();
                int num1=Integer.parseInt(snum1);
                int num2=Integer.parseInt(snum2);
                int result=num1*num2;
                txtResult.setText("결과:"+result);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snum1=edtNum1.getText().toString();
                String snum2=edtNum2.getText().toString();
                int num1=Integer.parseInt(snum1);
                int num2=Integer.parseInt(snum2);
                int result=num1/num2;
                txtResult.setText("결과:"+result);
            }
        });
         */
    }

    @Override
    public void onClick(View view) {
        String snum1 = edtNum1.getText().toString();
        String snum2 = edtNum2.getText().toString();
        // 하나라도 공백시 계산을 할 수 없으니 토스트메시지 출력 하고 계산x
        if (snum1.trim().isEmpty() || snum2.trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "값을 입력하지 않으면 계산할 수 없습니다",
                    Toast.LENGTH_SHORT).show();

        } else {

            int num1 = Integer.parseInt(snum1);
            int num2 = Integer.parseInt(snum2);
            int result = 0;

            if (view.getId() == R.id.btnAdd) {
                result = num1 + num2;
                txtResult.setText("결과:" + result);
            } else if (view.getId() == R.id.btnSub) {
                result = num1 - num2;
                txtResult.setText("결과:" + result);
            } else if (view.getId() == R.id.btnMul) {
                result = num1 * num2;
                txtResult.setText("결과:" + result);
            } else if (view.getId() == R.id.btnDiv) {
                // 0 으로 나눌때는 계산 안된다
                if (num2 == 0) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌수없습니다",
                            Toast.LENGTH_SHORT).show();
                } else {
                    result = num1 / num2;
                    txtResult.setText("결과:" + result);
                }
            } else if (view.getId() == R.id.btnMod) {
                result = num1 % num2;
                txtResult.setText("결과:" + result);
            } else if (view.getId() == R.id.btnRs) {
                edtNum1.setText("");
                edtNum2.setText("");
                txtResult.setText("결과(초기화):" + result);
            }
        }


    }
}