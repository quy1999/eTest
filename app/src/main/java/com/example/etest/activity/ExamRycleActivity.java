package com.example.etest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.etest.R;
import com.example.etest.adapter.ExamRycleAdapter;

public class ExamRycleActivity extends AppCompatActivity {

    private RecyclerView rcvView;
    private ExamRycleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_rycle);

        String[] data = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" , "12"  , "13" , "14" , "15" };

        rcvView=(RecyclerView)findViewById(R.id.rcvViewExam);
        int numberOfColumns = 3;
        rcvView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new ExamRycleAdapter(this, data);
        adapter.setClickListener(this);
        rcvView.setAdapter(adapter);


    }
}
