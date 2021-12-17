package com.example.etest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.etest.NavigationActivity;
import com.example.etest.R;
import com.example.etest.adapter.ExamRycleAdapter;

public class ExamRycleActivity extends AppCompatActivity implements ExamRycleAdapter.ItemClickListener {

    private RecyclerView rcvView;
    private ExamRycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_rycle);

        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};

        rcvView = (RecyclerView) findViewById(R.id.rcvViewExam);
        int numberOfColumns = 3;
        rcvView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new ExamRycleAdapter(this, data);
        adapter.setClickListener(this);
        rcvView.setAdapter(adapter);


    }


    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, NavigationActivity.class);
        intent.putExtra("Name", position); //truyền dữ liệu qua lại giữa các activity
        this.startActivity(intent);
    }
}
