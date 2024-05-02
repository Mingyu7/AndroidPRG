package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class menu_create1 extends AppCompatActivity {

    ConstraintLayout mainDisplay;

    Button btn01,btn02,btn03,btn04;
    String [] strFl = {"사과","바나나","망고","포도"};

    String [] strSp = {"야구","축구","배구","피구"};

    String [] arrMusic = {"클래식","재즈","팝","힙합"};

    static ArrayList<String> musicList = new ArrayList<>();
    static int spnum = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("옵션메뉴");
        mainDisplay = findViewById(R.id.mainDisplay);
        btn01 = findViewById(R.id.btn01); //기본 대화상자
        btn02 = findViewById(R.id.btn02); // 리스트 대화상자
        btn03 = findViewById(R.id.btn03); // 라디오 대화상자
        btn04 = findViewById(R.id.btn04); // 체크박스 대화상자

        //기본 대화상자
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(menu_create1.this);
                dlg.setTitle("기본 대화상자");
                dlg.setMessage("기본대화상자입니다");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(menu_create1.this, "기본대화상자", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.setNeutralButton("연기", null);
                dlg.show();

            }
        });

        // 리스트 대화상자
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(menu_create1.this);
                dlg.setTitle("가장 좋아하는 과일을 고르세요");
                dlg.setItems(strFl, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) { // i : 배열의 index를 가리킴
                        Toast.makeText(menu_create1.this, strFl[i]+"를 선택함", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setPositiveButton("확인",null);
                dlg.show();


            }
        });

        // 라디오 대화상자
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(menu_create1.this);
                dlg.setTitle("가장 좋아하는 운동?");
                dlg.setSingleChoiceItems(strSp, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        spnum=i; // 정적변수로 선택 인덱스 값 이동

                    }
                });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() { // 확인버튼 누르면  출력
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(menu_create1.this, strSp[spnum]+"를 선택함", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show();


            }
        });
        // 체크박스
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicList.clear(); // ArrayList 비우기
                AlertDialog.Builder dlg = new AlertDialog.Builder(menu_create1.this);
                dlg.setTitle("가장 좋아하는 음악을 고르세요");
                dlg.setMultiChoiceItems(arrMusic, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i, boolean isChecked) {
                        if(isChecked){
                            musicList.add(arrMusic[i]);
                        }else {
                            musicList.remove(arrMusic[i]);
                        }
                    }
                });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s = "";
                        for (int i = 0; i < musicList.size(); i++) {
                            s+= musicList.get(i)+"";
                        }
                        Toast.makeText(menu_create1.this, s+"를 선택함", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show();


            }
        });
    }



    /** 메뉴 등록후 사용 **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);

        return true;
    }

    /** 메뉴 옵션 선택 이벤트 처리 **/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.opLogin){
            Toast.makeText(this, "로그인 합니다", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.opLogout){
            Toast.makeText(this, "로그아웃 합니다", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.opRed) {
            mainDisplay.setBackgroundColor(Color.RED);
        } else if (item.getItemId()==R.id.opYellow) {
            mainDisplay.setBackgroundColor(Color.YELLOW);
        }else if (item.getItemId()==R.id.opBlue) {
            mainDisplay.setBackgroundColor(Color.BLUE);
        }else if(item.getItemId()==R.id.opHome){
            Toast.makeText(this, "홈으로", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.opSearch){
            Toast.makeText(this, "검색합니다", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}