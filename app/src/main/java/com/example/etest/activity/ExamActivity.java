package com.example.etest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.etest.NavigationActivity;
import com.example.etest.R;

public class ExamActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

    }

    public void onclickPlayExam(View view) {
        Intent intent = new Intent(ExamActivity.this, NavigationActivity.class);
        startActivity(intent);

    }
}