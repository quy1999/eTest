package com.example.etest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GrammarActivity extends AppCompatActivity {


    private RecyclerView rcvGrammar;
    private List<NumberText> NumberList;
    private AdapterActivity adapterActivity;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);

        rcvGrammar = (RecyclerView) findViewById(R.id.rcvGrammar);
        NumberList = new ArrayList<>();
        NumberList.add(new NumberText("Các thì trong tiếng anh"));
        NumberList.add(new NumberText("Các dạng thức của động từ"));
        NumberList.add(new NumberText("Động từ khuyết thiếu"));
        NumberList.add(new NumberText("Các loại từ"));
        NumberList.add(new NumberText("So sánh các câu trong tiếng anh"));
        NumberList.add(new NumberText("Câu bị động "));
        NumberList.add(new NumberText("Câu gián tiếp"));
        NumberList.add(new NumberText("Câu giả định"));
        NumberList.add(new NumberText("Đảo ngữ"));








        rcvGrammar.setHasFixedSize(true);
        adapterActivity = new AdapterActivity(NumberList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GrammarActivity.this);


        rcvGrammar.setLayoutManager(linearLayoutManager);
        rcvGrammar.setAdapter(adapterActivity);


    }
    public void onclickPlay(View view) {
        Intent intent = new Intent(GrammarActivity.this, DefineActivity.class);
        startActivity(intent);

    }


}
