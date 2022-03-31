package com.example.simplecal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button btnPlus, btnMinus, btnMultiply, btnDivision;
    TextView Result;
    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단한 계산기");


        Integer[] numBtnIds = {R.id.Num0, R.id.Num1, R.id.Num2,
                R.id.Num3, R.id.Num4, R.id.Num5,
                R.id.Num6, R.id.Num7, R.id.Num8, R.id.Num9};
        final String numBtn[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivision = (Button) findViewById(R.id.btnDivision);

        Result = (TextView) findViewById(R.id.Result);



        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                Result.setText("결과 : " + result.toString());
                Toast.makeText(MainActivity.this, "계산결과 : " + result + "", Toast.LENGTH_SHORT).show();
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                Result.setText("결과 : " + result.toString());
                Toast.makeText(MainActivity.this, "계산결과 : " + result + "", Toast.LENGTH_SHORT).show();
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                Result.setText("계산결과 : " + result.toString());
                Toast.makeText(MainActivity.this, "계산결과 : " + result + "", Toast.LENGTH_SHORT).show();
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                final double result = Double.parseDouble(num1) / Double.parseDouble(num2);
                Result.setText("계산결과 : " + result + "");
                Toast.makeText(MainActivity.this, "계산결과 : " + result + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}