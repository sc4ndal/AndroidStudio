package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
        ListView Phonebook;
        ListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Phonebook = (ListView) findViewById(R.id.Phonebook);
        adapter = new ListViewAdapter();

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.tree),"사람1","010-1234-5671");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.sakura01),"사람2","010-1234-5672");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.sakura02),"사람3","010-1234-5673");
        //adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie4),"사람4","010-1234-5674");
        //adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie5),"사람5","010-1234-5675");
        //adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie6),"사람6","010-1234-5676");
        //adapter.addItem(ContextCompat.getDrawable(this, R.drawable.movie7),"사람7","010-1234-5677");

        Phonebook.setAdapter(adapter);
        Phonebook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String tel;
                ListViewItem item = (ListViewItem) adapterView.getItemAtPosition(position);
                tel = (String)item.getTelNo();
                Uri uri = Uri.parse("tel:" + tel);
                Intent telIntent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(telIntent);


            }
        });
    }

}