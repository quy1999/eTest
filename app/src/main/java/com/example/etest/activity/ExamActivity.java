package com.example.etest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.etest.R;
import com.example.etest.main.MainActivity;

public class ExamActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

    }

    public void onclickPlayExam(View view) {
        Intent intent = new Intent(ExamActivity.this, ExamRycleActivity.class);
        startActivity(intent);

    }
}