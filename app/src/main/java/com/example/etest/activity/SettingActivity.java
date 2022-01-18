package com.example.etest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.etest.R;

public class SettingActivity extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);




    }

    public void onclickDark(View view) {
        Intent intent = new Intent(SettingActivity.this, DarkmodeActivity.class);
        startActivity(intent);

    }
}