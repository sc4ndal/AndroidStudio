package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class result extends AppCompatActivity {

    Button btnHome,btnmsup,btnmsel,btnMC,btnPC;
    TextView txtpname,txtpprice,txtmname,txtmprice,txtresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        btnHome = (Button) findViewById(R.id.btnHome);
        btnmsup = (Button) findViewById(R.id.btnmsup);
        btnmsel = (Button) findViewById(R.id.btnmsel);
        btnMC = (Button) findViewById(R.id.btnMC);
        btnPC = (Button) findViewById(R.id.btnPC);
        txtpname = (TextView) findViewById(R.id.txtpname);
        txtpprice = (TextView) findViewById(R.id.txtpprice);
        txtmname = (TextView) findViewById(R.id.txtmname);
        txtmprice = (TextView) findViewById(R.id.txtmprice);
        txtresult = (TextView) findViewById(R.id.txtresult);

        Intent rsintent = getIntent();

        String pname = rsintent.getStringExtra("pname");
        Integer pprice = Integer.parseInt(rsintent.getStringExtra("pprice"));
        Integer psup = Integer.parseInt(rsintent.getStringExtra("psup"));

        String mname = rsintent.getStringExtra("mname");
        Integer mprice = Integer.parseInt(rsintent.getStringExtra("mprice"));

        txtpname.setText(pname);
        txtpprice.setText("출고가 : "+pprice.toString()+" 원");
        txtmname.setText(mname);
        txtmprice.setText("월(月) : "+mprice.toString()+" 원");

        Integer rs1 = ((pprice-psup)/24)+mprice;
        Integer rs2 = (pprice/24)+(mprice-(mprice/4));
        Handler handler = new Handler();
        btnmsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtresult.setText("공시지원금 | "+rs1+" 원");
                if(rs1<rs2){
                    Toast toast = Toast.makeText(result.this, "공시지원금이 더 저렴하네요", Toast.LENGTH_SHORT);
                    toast.show();
                    handler.postDelayed(toast::cancel,1000);
                }else if(rs1.equals(rs2)){
                    Toast toast = Toast.makeText(result.this, "공시/선택 가격이 똑같네요", Toast.LENGTH_SHORT);
                    toast.show();
                    handler.postDelayed(toast::cancel,1000);
                }
            }
        });
        btnmsel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtresult.setText("선택약정 | "+rs2+" 원");
                if(rs1>rs2){
                    Toast toast = Toast.makeText(result.this, "선택약정이 더 저렴하네요", Toast.LENGTH_SHORT);
                    toast.show();
                    handler.postDelayed(toast::cancel,1000);
                }else if(rs1.equals(rs2)){
                    Toast toast = Toast.makeText(result.this, "공시/선택 가격이 똑같네요", Toast.LENGTH_SHORT);
                    toast.show();
                    handler.postDelayed(toast::cancel,1000);
                }
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),pdata.class);
                startActivity(intent);
                finish();
            }
        });
        btnMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}