package com.example.etest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.etest.R;
import com.example.etest.question.Question;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {


    ArrayList<Question> arr = new ArrayList<Question>();
    int numtrue = 0;
    int numfalse = 0;
    int nummissed = 0;
    int Score = 0;
    TextView tvnumtrue, tvnumfalse, tvmissed, tvtime, tvpoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvnumtrue = findViewById(R.id.tvnumtrue);
        tvnumfalse = findViewById(R.id.tvnumfalse);
        tvmissed = findViewById(R.id.tvmissed);
        tvtime = findViewById(R.id.tvtime);
        Intent intent = getIntent(); //Nhận dữ liệu
        arr = (ArrayList<Question>) intent.getExtras().getSerializable("arr_ques");
        checkpoint();
        tvnumtrue.setText(" " + numtrue);
        tvnumfalse.setText(" " + numfalse);
        tvmissed.setText(" " + nummissed);


    }


    public void checkpoint() {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getAnswer().equals("") == true) {
                nummissed++;

            }
            if (arr.get(i).getResult().equals(arr.get(i).getAnswer()) == true) {
                numtrue++;

            } else {
                numfalse++;
            }


        }
    }
}
