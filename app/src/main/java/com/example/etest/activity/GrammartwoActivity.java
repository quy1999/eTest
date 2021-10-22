package com.example.etest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.etest.R;

public class GrammartwoActivity extends AppCompatActivity {
    private RecyclerView rcvViewtwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammartwo2);

        rcvViewtwo=(RecyclerView)findViewById(R.id.rcvViewtwo);
    }
}
