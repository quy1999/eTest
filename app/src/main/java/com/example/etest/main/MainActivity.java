package com.example.etest.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.etest.R;
import com.example.etest.activity.ExamActivity;
import com.example.etest.activity.GrammarActivity;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ImageView imageView;
    String TAD="quy";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void onclickPlay(View view) {
        Intent intent = new Intent(MainActivity.this, GrammarActivity.class);
        startActivity(intent);


    }
    public void onclickPlaybt(View view){
        Intent intent=new Intent(MainActivity.this, ExamActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAD,"onCreat");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAD,"onCreat");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAD,"onCreat");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAD,"onCreat");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAD,"onCreat");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAD,"onCreat");
    }
}