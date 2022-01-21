package com.example.etest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.etest.R;
import com.example.etest.question.Question;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {


    public static final String EXTRA_DATA = "EXTRA_DATA";
    ArrayList<Question> arr = new ArrayList<Question>();
    int numtrue = 0;
    int numfalse = 0;
    int nummissed = 0;
    double Score;
    String time;
    Button btnhistory;
    TextView tvnumtrue, tvnumfalse, tvmissed, tvtime, tvpoint,tvnote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvnumtrue = findViewById(R.id.tvnumtrue);
        tvnumfalse = findViewById(R.id.tvnumfalse);
        tvmissed = findViewById(R.id.tvmissed);
        tvtime = findViewById(R.id.tvtime);
        btnhistory = findViewById(R.id.btnhistory);
        tvpoint = findViewById(R.id.tvdiem);
        tvnote = findViewById(R.id.tvnote);
        Intent intent = getIntent(); //Nhận dữ liệu
        Bundle bundle = intent.getExtras();
        time = bundle.getString("key_time");
        arr = (ArrayList<Question>) intent.getExtras().getSerializable("arr_ques");
        checkpoint();
        tvnumtrue.setText(" " + numtrue);
        Score = numtrue * (0.3);
        tvnumfalse.setText(" " + numfalse);
        tvmissed.setText(" " + nummissed);
        tvpoint.setText("" +  Math.round(Score));
        tvtime.setText("" + time);

        if(Score >5){
            tvnote.setText("Bạn đã đạt yêu cầu");

        }else if(Score <5){
            tvnote.setText("Bạn chưa đạt yêu cầu vui lòng học thêm");

        }

        btnhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent data = new Intent();
                data.putExtra(EXTRA_DATA, "Some interesting data!");
                setResult(Activity.RESULT_OK, data);
                finish(); //đóng Activity hiện tại và trả về MainActivity

            }
        });



    }


            public void checkpoint() {
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).getAnswer().equals("")) {
                        nummissed++;

                    }
                    if (arr.get(i).getResult().equals(arr.get(i).getAnswer())) {
                        numtrue++;

                    } else {
                        numfalse++;
                    }


                }
            }
        }









