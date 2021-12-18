package com.example.etest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.etest.Dethi.Exam;
import com.example.etest.R;

import java.util.ArrayList;

public class ExamAdapter extends ArrayAdapter {


    public ExamAdapter(@NonNull Context context, ArrayList<Exam> exam) {
        super(context, 0, exam);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.item_gridview_exam, null);
        }
        TextView dethi = convertView.findViewById(R.id.dethi);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        Exam p = (Exam) getItem(position);
        if (p != null) {
            dethi.setText("" + p.getName());
            //imageView.setImageResource(R.drawable.baitap);

        }


        return convertView;
    }
}
