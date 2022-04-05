package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gvPost;
    ImageAdapter imageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvPost = (GridView) findViewById(R.id.gvPost);
        gvPost.setAdapter(new ImageAdapter(this));


    }
}