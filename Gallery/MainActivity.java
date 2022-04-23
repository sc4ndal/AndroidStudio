package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Gallery galflag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int imgIDs[] = {R.drawable.korea,
                R.drawable.mexico, R.drawable.poland, R.drawable.saudi_arabia,
                R.drawable.canada, R.drawable.france, R.drawable.korea,
                R.drawable.mexico, R.drawable.poland, R.drawable.saudi_arabia,
                R.drawable.canada, R.drawable.france, R.drawable.korea,
                R.drawable.mexico, R.drawable.poland, R.drawable.saudi_arabia,
                R.drawable.canada, R.drawable.france, R.drawable.korea,
                R.drawable.mexico, R.drawable.poland, R.drawable.saudi_arabia,
                R.drawable.canada, R.drawable.france, R.drawable.korea,
                R.drawable.mexico, R.drawable.poland, R.drawable.saudi_arabia,
        };
        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, imgIDs);
        galflag = (Gallery) findViewById(R.id.galflag);
        galflag.setAdapter(adapter);
        final ImageView iv = (ImageView)findViewById(R.id.imageView1);
        galflag.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                iv.setImageResource(imgIDs[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}