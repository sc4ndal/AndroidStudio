package com.example.namecard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button btnSave, btnSearch, btnUpdate, btnDelete, btnAllSearch;
    EditText etname, ettelNo, etEmail;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnAllSearch = (Button) findViewById(R.id.btnAllSearch);

        etname = (EditText) findViewById(R.id.etname);
        ettelNo = (EditText) findViewById(R.id.ettelNo);
        etEmail = (EditText) findViewById(R.id.etEmail);

        Handler handler = new Handler();
        ListView searchList = (ListView) findViewById(R.id.searchList);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etname.getText().toString();
                String telNo = ettelNo.getText().toString();
                String Email = etEmail.getText().toString();

                dataInsert(name, telNo, Email);
            }


        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {dataSearch();}
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etname.getText().toString();
                String telNo = ettelNo.getText().toString();
                String Email = etEmail.getText().toString();
                dataUpdate(name,telNo,Email);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {dataDelete();}
        });
        btnAllSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {dataAllSearch();}
        });

    }


    void dataInsert(String name, String telNo, String Email) {
        new Thread() {
            public void run() {
                String emulaterIP = "Http://10.0.2.2/";
                try {
                    String fileName = "insert.php";
                    URL setURL = new URL("http://10.0.2.2/insert.php/");
                    HttpURLConnection http = (HttpURLConnection) setURL.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST"); //포스트방법으로 보냄
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(name).append("/").append(telNo).append("/").append(Email).append("/");
                    OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "utf-8");
                    outStream.write(buffer.toString());
                    outStream.flush();
                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "utf-8");
                    final BufferedReader reader = new BufferedReader(tmp);
                    while (reader.readLine() != null) {
                        System.out.println(reader.readLine());
                    }
                } catch (Exception e) {
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "DB 입력 에러", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }.start();
        Toast.makeText(this, "데이터 저장", Toast.LENGTH_SHORT).show();
    }

    public void dataSearch() {
        count++;
        Handler handler = new Handler();
        final ListViewAdapter adapter = new ListViewAdapter();
        final ListView searchList = (ListView) findViewById(R.id.searchList);

            new Thread() {
                public void run() {
                    try {
                        String name = etname.getText().toString();
                        URL url = new URL("Http://10.0.2.2/search.php/");
                        HttpURLConnection http = (HttpURLConnection) url.openConnection();
                        http.setDefaultUseCaches(false);
                        http.setDoInput(true);
                        http.setRequestMethod("POST");
                        http.setRequestProperty("content-type", "application/x-www-form-urlencoded");

                        StringBuffer buffer = new StringBuffer();
                        buffer.append("name").append("=").append(name);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
                        outputStreamWriter.write(buffer.toString());
                        outputStreamWriter.flush();
                        InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "UTF-8");
                        BufferedReader reader = new BufferedReader(tmp);
                        StringBuilder builder = new StringBuilder();

                        String str;
                        while ((str = reader.readLine()) != null) {
                            builder.append(str + "\n");
                        }
                        String resultData = builder.toString();
                        final String[] sResult = resultData.split("/");
                        Log.e("데이터 확인!!!!1 : " , sResult[1]);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
//                            etname.setText(sResult[0].toTring());
                                Toast toast1 = Toast.makeText(MainActivity.this, "아이디번호:" + sResult[0], Toast.LENGTH_SHORT);
                                toast1.show();
                                handler.postDelayed(toast1::cancel, 1000);

                                ettelNo.setText(sResult[1].toString());
                                etEmail.setText(sResult[2].toString());
//--------------------------------------------어댑터 추가 미완성-----------------------------
//                                String ItemName = etname.getText().toString();
//                                String ItemTel = ettelNo.getText().toString();
//                                String ItemEmail = etEmail.getText().toString();
//                                Log.e("이메일확인 : ",ItemEmail);

//                                for(int i=0; i<count; i++) {
//                                    adapter.addItem(ItemName, ItemTel, ItemEmail);
//                                }
//                                searchList.setAdapter(adapter);
//
//                                adapter.notifyDataSetChanged();
//----------------------------------------------------------------------------------------
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
//            Toast toast = Toast.makeText(this, "이름으로 데이터 검색", Toast.LENGTH_SHORT);
//            toast.show();
//            handler.postDelayed(toast::cancel, 1000);
    }

    public void dataAllSearch() {
        Handler handler = new Handler();
        final ListView searchList = (ListView) findViewById(R.id.searchList);
        final ListViewAdapter adapter = new ListViewAdapter();

        new Thread() {
            public void run() {
                try {
                    String name = etname.getText().toString();
                        URL url = new URL("Http://10.0.2.2/allsearch.php/");
                        HttpURLConnection http = (HttpURLConnection) url.openConnection();
                        http.setDefaultUseCaches(false);
                        http.setDoInput(true);
                        http.setRequestMethod("POST");
                        http.setRequestProperty("content-type", "application/x-www-form-urlencoded");

                        StringBuffer buffer = new StringBuffer();
                        buffer.append("name").append("=").append(name);
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(http.getOutputStream(), "UTF-8");
                        outputStreamWriter.write(buffer.toString());
                        outputStreamWriter.flush();
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
                                    adapter.addItem(item[0],item[1],item[2]);
                                }
                            } catch (Exception e){
//                                adapter.addItem("x","x","x"); 비어있으면 어댑터 값에 x를 넣어줌
                            }
                            searchList.setAdapter(adapter);
                        }
                    });
                } catch (Exception e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "DB 입력 에러", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }.start();
        Toast toast = Toast.makeText(this, "데이터베이스 모두 검색 완료", Toast.LENGTH_SHORT);
        toast.show();
        handler.postDelayed(toast::cancel, 1000);

    }

    void dataUpdate(String name, String telNo, String Email) {
        new Thread() {
            public void run() {
                try {
                    URL setURL = new URL("http://10.0.2.2/update.php/");
                    HttpURLConnection http = (HttpURLConnection) setURL.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST"); //포스트방법으로 보냄
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(name).append("/").append(telNo).append("/").append(Email);
                    OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "utf-8");
                    outStream.write(buffer.toString());
                    outStream.flush();
                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "utf-8");
                    final BufferedReader reader = new BufferedReader(tmp);
                    while (reader.readLine() != null) {
                        System.out.println(reader.readLine());
                    }
                } catch (Exception e) {
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "DB 입력 에러", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }.start();
        Toast.makeText(this, "데이터 수정", Toast.LENGTH_SHORT).show();
    }

    public void dataDelete(){
        new Thread() {
            public void run() {
                try {
                    String name = etname.getText().toString();
                    URL setURL = new URL("http://10.0.2.2/delete.php/");
                    HttpURLConnection http = (HttpURLConnection) setURL.openConnection();
                    http.setDefaultUseCaches(false);
                    http.setDoInput(true);
                    http.setRequestMethod("POST"); //포스트방법으로 보냄
                    http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name").append("=").append(name);
                    OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "utf-8");
                    outStream.write(buffer.toString());
                    outStream.flush();

                    InputStreamReader tmp = new InputStreamReader(http.getInputStream(), "utf-8");
                    final BufferedReader reader = new BufferedReader(tmp);
                    StringBuilder builder = new StringBuilder();
                    String rs = builder.toString();
                    final String[] result = rs.split("/");

                    while (reader.readLine() != null) {
                        System.out.println(reader.readLine());
                    }
                } catch (Exception e) {
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "DB 입력 에러", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }.start();
        Toast.makeText(this, etname.getText().toString()+" 데이터 삭제됨", Toast.LENGTH_SHORT).show();
    }



}


