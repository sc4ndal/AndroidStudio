package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class pdata extends AppCompatActivity{


    ListView plist;
    pAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdata);

        adapter = new pAdapter();
        Search();
        plist = (ListView) findViewById(R.id.plist);
        Button btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        plist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent pIntent = new Intent(getApplicationContext(), mdata.class);
                pIntent.putExtra("pname", adapter.list.get(position).getTxtPname());
                pIntent.putExtra("pprice", adapter.list.get(position).getTxtPprice());
                pIntent.putExtra("psup", adapter.list.get(position).getTxtPsup());
                startActivity(pIntent);
            }
        });

    }

        public void Search() {
        Handler handler = new Handler();
        new Thread() {
            public void run() {
                try {
                    URL url = new URL("http://10.0.2.2/psearch.php/");
                    HttpURLConnection http = (HttpURLConnection) url.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST");
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");

                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuilder builder = new StringBuilder();
                    String str;
                    while ((str = reader.readLine()) != null) {
                        builder.append(str + "\n");
                    }
                    String rs = builder.toString();
                    final String[] sR1 = rs.split("#");

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                for (String sR2 : sR1){
                                    String[] item = sR2.split("/");
                                    adapter.paddItem(item[0],item[1],item[2]);
                                }
                            } catch (Exception e){
                            }
                            plist.setAdapter(adapter);
                        }
                    });
                } catch (Exception e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(pdata.this, "DB 입력 에러", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }.start();
    }
}