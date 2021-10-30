package com.example.etest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.etest.R;
import com.example.etest.adapter.AdapterGrammar;
import com.example.etest.adapter.PresentAdapter;
import com.example.etest.model.NameGrammar;
import com.example.etest.model.Present;

import java.util.ArrayList;
import java.util.List;

public class PresentActivity extends AppCompatActivity {


    private RecyclerView rcvViewpresent;
    private PresentAdapter presentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present);

        rcvViewpresent = (RecyclerView) findViewById(R.id.rcvViewpresent); //ánh xạ rcvView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvViewpresent.setLayoutManager(linearLayoutManager); //khỏi tạo
        presentAdapter= new PresentAdapter(this,getListNameVN());
        rcvViewpresent.setAdapter(presentAdapter);

    }


        private List<Present> getListNameVN() {

            List<Present> list = new ArrayList<>();
            list.add(new Present("Thì hiện tại đơn","Simple present"));
            list.add(new Present("Thì hiện tại tiếp diễn","Present Continuous"));
            list.add(new Present("Thì hiện tại hoàn thành","Present Perfect"));
            list.add(new Present("Thì hiện tại hoàn thành tiếp diễn ","Present Perfect Continuous"));
            list.add(new Present("Thì quá khứ đơn","Past Simple"));
            list.add(new Present("Thì quá khứ tiếp diễn","Past Continuous"));
            list.add(new Present("Thì quá khứ hoàn thành","Pass Perfect"));
            list.add(new Present("Thì quá khứ hoàn thành tiếp diễn","Pass Perfect"));
            list.add(new Present("Thì tương lai đơn","Pass Perfect  Continuous"));
            list.add(new Present("Thì tương lai tiếp diễn","Future Continuous"));
            list.add(new Present("Thì tương lai hoàn thành","Future Perfect"));
            list.add(new Present("Thì tương lai hoàn thành tiếp diễn","Future Perfect Continuous"));


           return list;
        }
    }

