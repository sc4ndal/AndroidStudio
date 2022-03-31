package com.example.picvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VoteResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_result);

        Intent receiveVote = getIntent();       //Intent 받은걸 찾아서 receiveVote에 넣음
        int[] voteCount = receiveVote.getIntArrayExtra("vc");   //receiveVote에 vc의 이름으로 온 Intent 안에 있는 값을 voteCount에 넣음

        String[] imgName = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀", "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서"};
        RatingBar[] rBar = new RatingBar[imgName.length];
        TextView[] txtV = new TextView[imgName.length];

        int[] txtId = {R.id.txtV1, R.id.txtV2, R.id.txtV3, R.id.txtV4, R.id.txtV5, R.id.txtV6, R.id.txtV7, R.id.txtV8, R.id.txtV9};
        Integer[] rBarId = {R.id.rB1, R.id.rB2, R.id.rB3, R.id.rB4, R.id.rB5, R.id.rB6, R.id.rB7, R.id.rB8, R.id.rB9};


        for(int i=0; i<voteCount.length; i++){
            rBar[i] = (RatingBar)findViewById(rBarId[i]);
            rBar[i].setRating((float) voteCount[i]);  //setRating에서 .5 값도 받기 위해 int 정수로 받아온 값을 float 실수로 변환해줌
            txtV[i] = (TextView)findViewById(txtId[i]);    //txtId 가져옴
            txtV[i].setText(imgName[i]);       //imgName에 있는 것을 txtId에 맞춰 텍스트를 넣음

        }
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();    //현재 엑티비티 종료 메인 엑티비티로 이동
            }
        });
    }
}