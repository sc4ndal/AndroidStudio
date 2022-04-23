package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4,txt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (TextView)findViewById(R.id.txt5);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                if (pos == 0){
                    Toast toast = Toast.makeText(MainActivity.this, "월요일", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(toast::cancel, 1000);
                    txt1.setVisibility(View.VISIBLE);
                    txt2.setVisibility(View.INVISIBLE);
                    txt3.setVisibility(View.INVISIBLE);
                    txt4.setVisibility(View.INVISIBLE);
                    txt5.setVisibility(View.INVISIBLE);
                }

                if (pos == 1){
                    Toast toast = Toast.makeText(MainActivity.this, "화요일", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(toast::cancel, 1000);
                    txt1.setVisibility(View.INVISIBLE);
                    txt2.setVisibility(View.VISIBLE);
                    txt3.setVisibility(View.INVISIBLE);
                    txt4.setVisibility(View.INVISIBLE);
                    txt5.setVisibility(View.INVISIBLE);
                }
                if (pos == 2){
                    Toast toast = Toast.makeText(MainActivity.this, "수요일", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(toast::cancel, 1000);
                    txt1.setVisibility(View.INVISIBLE);
                    txt2.setVisibility(View.INVISIBLE);
                    txt3.setVisibility(View.VISIBLE);
                    txt4.setVisibility(View.INVISIBLE);
                    txt5.setVisibility(View.INVISIBLE);
                }
                if (pos == 3){
                    Toast toast = Toast.makeText(MainActivity.this, "목요일", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(toast::cancel, 1000);
                    txt1.setVisibility(View.INVISIBLE);
                    txt2.setVisibility(View.INVISIBLE);
                    txt3.setVisibility(View.INVISIBLE);
                    txt4.setVisibility(View.VISIBLE);
                    txt5.setVisibility(View.INVISIBLE);
                }
                if (pos == 4){
                    Toast toast = Toast.makeText(MainActivity.this, "금요일", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(toast::cancel, 1000);
                    txt1.setVisibility(View.INVISIBLE);
                    txt2.setVisibility(View.INVISIBLE);
                    txt3.setVisibility(View.INVISIBLE);
                    txt4.setVisibility(View.INVISIBLE);
                    txt5.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}