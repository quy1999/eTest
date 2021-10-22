package com.example.etest.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.etest.activity.GrammarActivity;
import com.example.etest.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onclickPlay(View view) {
        Intent intent = new Intent(MainActivity.this, GrammarActivity.class);
        startActivity(intent);


    }
}