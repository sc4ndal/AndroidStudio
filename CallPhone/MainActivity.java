package com.example.callphone02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCall, btnGoogle, btnMap, btnSearch, btnMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01029231863"));
                startActivity(intentCall);
            }
        });
        btnGoogle = (Button) findViewById(R.id.btnGoogle);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGoogle = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"));
                startActivity(intentGoogle);
            }
        });
        btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMap = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:35.16634991634856, 129.07311173075632"));   //geo의 좌표로 지도 검색
                startActivity(intentMap);
            }
        });

        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSearch = new Intent(Intent.ACTION_WEB_SEARCH);
                intentSearch.putExtra(SearchManager.QUERY, "안드로이드");   //검색창에서 안드로이드 검색
                startActivity(intentSearch);
            }
        });

        btnMessage = (Button) findViewById(R.id.btnMessage);
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMessage = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01029231863"));    //smsto에 적혀있는 번호로 메세지 보냄
                intentMessage.putExtra("sms_body", "ㅎㅇ");     //메세지 입력창에 ㅎㅇ라고 먼저 적어둠
                startActivity(intentMessage);
            }
        });

    }
}