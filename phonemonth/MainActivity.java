package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btnP, btnnotice;
    TextView txtPdata, txtMdata;
    //    int count=0;
//    Handler handler = new Handler();
    String pname, pprice, psup, mname, mprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnP = (Button) findViewById(R.id.btnP);
        btnnotice = (Button) findViewById(R.id.btnNotice);


        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pIntent = new Intent(getApplicationContext(),pdata.class);

                startActivity(pIntent);
            }
        });
        btnnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),notice.class);
                startActivity(intent);
            }
        });

    }
}