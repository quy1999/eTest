package com.example.etest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.etest.R;
import com.example.etest.adapter.PresentAdapter;
import com.example.etest.adapter.TypeWorksAdapter;
import com.example.etest.model.Present;
import com.example.etest.model.TypeWorks;

import java.util.ArrayList;
import java.util.List;

public class TypeWorksActivity extends AppCompatActivity {


    private RecyclerView rcvViewtypes;
    private TypeWorksAdapter typesworksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_works);

        rcvViewtypes = (RecyclerView) findViewById(R.id.rcvViewtypes); //ánh xạ rcvView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvViewtypes.setLayoutManager(linearLayoutManager); //khỏi tạo
        typesworksAdapter = new TypeWorksAdapter(this, getListNameTypes());
        rcvViewtypes.setAdapter(typesworksAdapter);


    }

    private List<TypeWorks> getListNameTypes() {

        List<TypeWorks> list = new ArrayList<>();
        list.add(new TypeWorks("Danh từ", "Nouns"));
        list.add(new TypeWorks("Đại từ", "Pronouns"));
        list.add(new TypeWorks("Động từ", "Verbs"));
        list.add(new TypeWorks("Tính từ", "Adjective"));
        list.add(new TypeWorks("Trạng từ", "Adverb"));
        list.add(new TypeWorks("Giới từ", "Preposittions"));
        list.add(new TypeWorks("Liên từ", "Conjunctions"));
        list.add(new TypeWorks("Mạo từ", "Artlcles"));


        return list;
    }
}
