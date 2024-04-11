package com.example.compoundtext;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Table_cal extends AppCompatActivity {

    EditText edtNum1, edtNum2;
//    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    Button[] butNumbers = new Button[10];
    int numbersIDs[] = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    Button btnPlus, btnSub, btnMul, btnDiv, btnMod;
    TextView txtResult;

    String snum1, snum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_cal);
        setTitle("간단계산기_테이블");

        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);

        for (int i = 0; i < 10; i++) {
            butNumbers[i] = findViewById(numbersIDs[i]);
        }

        btnPlus = findViewById(R.id.btnPlus);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnMod = findViewById(R.id.btnMod);

        txtResult = findViewById(R.id.txtResult);
        /** 누른 버튼 값 에디트텍스에 출력하기  !지역변수는 접근할수 없다! 그래서 final **/

        for (int i = 0; i < butNumbers.length; i++) {
            final int index; // 무명객체는 힙에 저장됨
            index = i;
            butNumbers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edtNum1.isFocused()) {
                        snum1 = edtNum1.getText().toString() + butNumbers[index].getText().toString();
                        edtNum1.setText(snum1);

                    } else if (edtNum2.isFocused()) {
                        snum2 = edtNum2.getText().toString() + butNumbers[index].getText().toString();
                        edtNum2.setText(snum2);
                    } else {
                        Toast.makeText(Table_cal.this, "입력할 곳에 커서를 두세요", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

        btnPlus.setOnClickListener(new MycalListener());
        btnSub.setOnClickListener(new MycalListener());
        btnMul.setOnClickListener(new MycalListener());
        btnDiv.setOnClickListener(new MycalListener());
        btnMod.setOnClickListener(new MycalListener());


    }

    class MycalListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String snum1 = edtNum1.getText().toString();
            String snum2 = edtNum2.getText().toString();
            int result = 0;

            if (snum1.trim().equals("") || snum2.trim().equals("")) {
                Toast.makeText(Table_cal.this, "값을 먼저 입력하세요", Toast.LENGTH_SHORT).show();
            } else {
                if (v.getId() == R.id.btnPlus) { // 더하기
                    result = Integer.parseInt(snum1) + Integer.parseInt(snum2);
                } else if (v.getId() == R.id.btnSub) { // 빼기
                    result = Integer.parseInt(snum1) - Integer.parseInt(snum2);
                } else if (v.getId() == R.id.btnMul) { // 곱하기
                    result = Integer.parseInt(snum1) * Integer.parseInt(snum2);
                } else if (v.getId() == R.id.btnDiv) { // 나누기
                    result = Integer.parseInt(snum1) / Integer.parseInt(snum2);
                } else if (v.getId() == R.id.btnMod) { // 나머지
                    result = Integer.parseInt(snum1) % Integer.parseInt(snum2);
                }
                txtResult.setText(result + "");
            }


        }
    }


}


