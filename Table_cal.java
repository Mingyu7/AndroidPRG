package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Table_cal extends AppCompatActivity {

    EditText edtNum1;
    Button[] butNumbers = new Button[10];
    int numbersIDs[] = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    Button btnPlus, btnSub, btnMul, btnDiv, btnMod, btnResult, btnReset;

    List<Integer> numbers = new ArrayList<>(); // 값 저장
    String strbtn = ""; //연산자 값 저장


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_cal);
        setTitle("진짜 계산기");

        edtNum1 = findViewById(R.id.edtNum1);


        for (int i = 0; i < 10; i++) {
            butNumbers[i] = findViewById(numbersIDs[i]);
        }

        btnPlus = findViewById(R.id.btnPlus);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnMod = findViewById(R.id.btnMod);

        btnResult = findViewById(R.id.btnResult);
        btnReset = findViewById(R.id.btnReset);


        /** 누른 버튼 값 에디트텍스에 출력하기  !지역변수는 접근할수 없다! 그래서 final **/

        for (int i = 0; i < butNumbers.length; i++) {
            final int index; // 무명객체는 힙에 저장됨
            index = i;
            butNumbers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edtNum1.isFocused()) {
                        String inputText = edtNum1.getText().toString() + butNumbers[index].getText().toString();
                        if (!inputText.isEmpty()) {
                            edtNum1.setText(inputText);

                        }
                    } else {
                        Toast.makeText(Table_cal.this, "입력할 곳에 커서를 두세요", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strbtn = btnPlus.getText().toString();
                inputNum();

            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strbtn = btnSub.getText().toString();
                inputNum();
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strbtn = btnMul.getText().toString();
                inputNum();
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strbtn = btnDiv.getText().toString();
                inputNum();
            }
        });
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strbtn = btnMod.getText().toString();
                inputNum();
            }
        });

        /** 입력값 초기화 **/
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtNum1.setText("");
                numbers.clear();
            }
        });
        /** 결과 출력 **/
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultPrint();
            }
        });


    }

    /**
     * 숫자 계산 로직
     **/
    private void resultPrint() {
        double sum = 0;
        if (strbtn.equals("+")) {
            relNum();
            for (int i = 0; i < numbers.size() - 1; i++) {

                sum = numbers.get(i) + numbers.get(i + 1);

            }

        } else if (strbtn.equals("-")) {
            relNum();
            for (int i = 0; i < numbers.size() - 1; i++) {

                sum = numbers.get(i) - numbers.get(i + 1);

            }

        } else if (strbtn.equals("*")) {
            relNum();
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(1) != 0) {
                    sum = numbers.get(i) * numbers.get(i + 1);
                }
            }

        } else if (strbtn.equals("/")) {
            relNum();
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(1) != 0) {
                    sum = numbers.get(i) / numbers.get(i + 1);
                }
            }


        } else if (strbtn.equals("%")) {
            relNum();
            for (int i = 0; i < numbers.size() - 1; i++) {
                if (numbers.get(1) != 0) {
                    sum = numbers.get(i) % numbers.get(i + 1);
                }
            }

        }
        edtNum1.setText("합계 :" + sum);
    }


    /**
     * 숫자 저장 로직
     **/
    private void inputNum() {
        String inputText = edtNum1.getText().toString();
        if (!inputText.isEmpty()) {
            int number = Integer.parseInt(inputText);
            numbers.add(number); // 배열에 숫자 추가
            edtNum1.setText(""); // 입력값 초기화
        }
    }

    /**
     * 연산 버튼 눌렀을때 한번더 숫자 저장
     **/
    private void relNum() {
        String inputText = edtNum1.getText().toString();
        if (!inputText.isEmpty()) {
            int number = Integer.parseInt(inputText);
            numbers.add(number); // 배열에 숫자 추가
        }
    }
}


