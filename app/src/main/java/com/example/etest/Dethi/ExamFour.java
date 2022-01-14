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
 * Use the {@link ExamFour#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExamFour extends Fragment {

    Button btnClick;
    ExamAdapter examAdapter;
    GridView gridViewExam;
    ArrayList<Exam> arrExam = new ArrayList<Exam>();
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExamFour() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExamFour.
     */
    // TODO: Rename and change types and number of parameters
    public static ExamFour newInstance(String param1, String param2) {
        ExamFour fragment = new ExamFour();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_exam_four, container, false);
        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Bộ đề ngẫu nhiên");
        gridViewExam = view.findViewById(R.id.GridViewFour);

        arrExam.add(new Exam("Đề số 1"));
        arrExam.add(new Exam("Đề số 2"));
        arrExam.add(new Exam("Đề số 3"));
        arrExam.add(new Exam("Đề số 4"));
        arrExam.add(new Exam("Đề số 5"));
        arrExam.add(new Exam("Đề số 6"));
        arrExam.add(new Exam("Đề số 7"));
        arrExam.add(new Exam("Đề số 8"));
        arrExam.add(new Exam("Đề số 9"));
        arrExam.add(new Exam("Đề số 10"));
        arrExam.add(new Exam("Đề số 11"));
        arrExam.add(new Exam("Đề số 12"));
        arrExam.add(new Exam("Đề số 13"));
        arrExam.add(new Exam("Đề số 14"));
        arrExam.add(new Exam("Đề số 15"));

        examAdapter = new ExamAdapter(getActivity(), arrExam);
        gridViewExam.setAdapter(examAdapter);


        gridViewExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long i) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("num",i+1);
                intent.putExtra("sub","de thi A2");

                startActivity(intent);
            }
        });


        return view;
    }
}