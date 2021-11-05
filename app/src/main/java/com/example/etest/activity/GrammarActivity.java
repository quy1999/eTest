package com.example.etest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.etest.model.NameGrammar;
import com.example.etest.R;
import com.example.etest.adapter.AdapterGrammar;

import java.util.ArrayList;
import java.util.List;

public class GrammarActivity extends AppCompatActivity {

    private RecyclerView rcvView;
    private AdapterGrammar adapterGrammar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);



        rcvView = (RecyclerView) findViewById(R.id.rcvView); //ánh xạ rcvView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvView.setLayoutManager(linearLayoutManager); //khỏi tạo
        adapterGrammar = new AdapterGrammar(this,getListName());
        rcvView.setAdapter(adapterGrammar);

    }

    private List<NameGrammar> getListName() {

        List<NameGrammar> list = new ArrayList<>();
        list.add(new NameGrammar("Các thì trong tiếng anh"));
        list.add(new NameGrammar("Các dạng thức của động từ"));
        list.add(new NameGrammar("Động từ khuyết thiếu"));
        list.add(new NameGrammar("Các loại từ"));
        list.add(new NameGrammar("So sánh câu trong Tiếng Anh"));
        list.add(new NameGrammar("Câu bị động"));
        list.add(new NameGrammar("Câu gián tiếp"));
        list.add(new NameGrammar("Sự hoà hợp giữa chủ ngữ và động từ"));
        list.add(new NameGrammar("Cấu tạo từ"));
        list.add(new NameGrammar("Đảo ngữ"));
        list.add(new NameGrammar("Sự kết hợp từ"));
        list.add(new NameGrammar("Mệnh đề"));
        list.add(new NameGrammar("Ngữ âm"));
        list.add(new NameGrammar("Câu điều kiện"));
        list.add(new NameGrammar("Câu điều ước"));
        list.add(new NameGrammar("Cụm động từ"));
        list.add(new NameGrammar("Một số động từ đặc biệt(need,dare,to be,get)"));
        list.add(new NameGrammar("Câu hỏi"));
        list.add(new NameGrammar("Lối nói phụ hoạ trong tiếng anh"));
        list.add(new NameGrammar("Câu phủ định"));
        list.add(new NameGrammar("Câu giả định"));
        list.add(new NameGrammar("Cách sử dụng một số cấu trúc"));
        list.add(new NameGrammar("Các cụm từ diễn tả số lượng"));
        list.add(new NameGrammar("Much,many,a lot of và lots of-trong một số trường hợp khác"));
        list.add(new NameGrammar("Sự phù hợp về thời gian giữa hai vế của một câu"));
        list.add(new NameGrammar("100 cụm từ thường gặp"));
        list.add(new NameGrammar("Một số cấu trúc thông dụng trong tiếng anh(phần 1)"));
        list.add(new NameGrammar("Một số cấu trúc thông dụng trong tiếng anh(phần 2)"));
        list.add(new NameGrammar("Một số cấu trúc thông dụng trong tiếng anh(phần 3)"));
        list.add(new NameGrammar("Đọc hiểu"));
        list.add(new NameGrammar("Bảng động từ bất quy tắc"));

        return list;
    }


}
