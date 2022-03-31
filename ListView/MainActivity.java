package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView LvFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LvFruit = (ListView) findViewById(R.id.LvFruit);
        //String[] data = {"사과", "바나나", "딸기", "블루베리", "포도", "파인애플", "드래곤후르츠", "키위", "수박", "메론", "망고", "산딸기", "아보카도", "레몬", "라임", "복숭아", "망고스틴"};
        String[] data = {"01029231863","112","119"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        LvFruit.setAdapter(adapter);

        LvFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String telNum = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, telNum, Toast.LENGTH_SHORT).show();
//                Uri uri = Uri.parse("tel:"+telNum);
                Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse(("tel:"+telNum)));
                startActivity(call);
            }
        });
    }
}