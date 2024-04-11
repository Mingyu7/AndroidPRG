package com.example.compoundtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Order_cal extends AppCompatActivity {

    RadioGroup radioGr;
    RadioButton raPizza,raPasta;
    EditText edtCount;
    Button btnOrder,btnCancel;
    TextView tv_pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_cal);
        radioGr=findViewById(R.id.radioGr);

        raPizza=findViewById(R.id.raPizza);
        raPasta=findViewById(R.id.raPasta);

        edtCount=findViewById(R.id.edtCount);

        btnOrder=findViewById(R.id.btnOrder);
        btnCancel=findViewById(R.id.btnCancel);

        tv_pay=findViewById(R.id.tv_pay);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGr.clearCheck();
                edtCount.setText("");

            }
        });



    }
    /** 계산 Logic **/

    private void order(){

        String edtstr = edtCount.getText().toString();
        if(raPasta.isChecked()==false&&raPizza.isChecked()==false){
            Toast.makeText(Order_cal.this,"메뉴를 입력하세요",Toast.LENGTH_SHORT).show();
        } else if(edtstr.trim().isEmpty()) {
            Toast.makeText(Order_cal.this,"개수를 입력하세요",Toast.LENGTH_SHORT).show();
        }else{
            if (raPasta.isChecked()==true){
                int menu = Integer.parseInt(edtCount.getText().toString());
                menu*=10000;
                String smenu = String.valueOf(menu);
                tv_pay.setText(smenu);
            } else if (raPizza.isChecked()==true) {
                int menu = Integer.parseInt(edtCount.getText().toString());
                menu*=20000;
                String smenu = String.valueOf(menu);
                tv_pay.setText(smenu);
            }
        }

    }
}