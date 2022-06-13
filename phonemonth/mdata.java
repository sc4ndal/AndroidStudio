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
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class mdata extends AppCompatActivity{


    ListView mlist;
    mAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdata);

        adapter = new mAdapter();
        Search();

        mlist = (ListView) findViewById(R.id.mlist);
        Button btnBack = (Button) findViewById(R.id.btnBack);

        Intent pintent = getIntent();
        String pname = pintent.getStringExtra("pname");
        String pprice = pintent.getStringExtra("pprice");
        String psup = pintent.getStringExtra("psup");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent pIntent = new Intent(getApplicationContext(), result.class);
                pIntent.putExtra("pname",pname);
                pIntent.putExtra("pprice",pprice);
                pIntent.putExtra("psup",psup);

                pIntent.putExtra("mname", adapter.list.get(position).getTxtMname());
                pIntent.putExtra("mprice", adapter.list.get(position).getTxtMprice());
                startActivity(pIntent);
            }
        });

    }

    public void Search() {
        mlist = (ListView) findViewById(R.id.mlist);
        Handler handler = new Handler();
        new Thread() {
            public void run() {
                try {
                    URL url = new URL("http://10.0.2.2/msearch.php/");
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
                                    adapter.maddItem(item[0],item[1]);
                                }
                            } catch (Exception e){
//                                adapter.addItem("x","x","x"); 비어있으면 어댑터 값에 x를 넣어줌
                            }
                            mlist.setAdapter(adapter);
                        }
                    });
                } catch (Exception e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mdata.this, "DB 입력 에러", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }.start();
    }
}