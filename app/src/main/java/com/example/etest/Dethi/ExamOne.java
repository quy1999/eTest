package com.example.etest.Dethi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.etest.NavigationActivity;
import com.example.etest.R;
import com.example.etest.ViewPage.ScreenSlideActivity;
import com.example.etest.adapter.ExamAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamOne extends Fragment {

    Button btnClick;
    ExamAdapter examAdapter;
    GridView gridViewExam;
    ArrayList<Exam> arrExam = new ArrayList<Exam>();
    View view;


    public ExamOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_exam_one, container, false);
        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Trắc nghiệm Mạo từ");

        gridViewExam = view.findViewById(R.id.GridViewExam);

        arrExam.add(new Exam("Đề số 1"));
        arrExam.add(new Exam("Đề số 2"));
        arrExam.add(new Exam("Đề số 3"));
        arrExam.add(new Exam("Đề số 4"));
        arrExam.add(new Exam("Đề số 5"));



        examAdapter = new ExamAdapter(getActivity(), arrExam);
        gridViewExam.setAdapter(examAdapter);

        gridViewExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("num_exam",i+1);
                intent.putExtra("subject","english");

                startActivity(intent);
            }
        });


        return view;


    }


}
