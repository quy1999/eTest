package com.example.etest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.etest.R;
import com.example.etest.question.Question;

import java.util.ArrayList;

public class CheckAnserAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    ArrayList arrayList;

    public CheckAnserAdapter(ArrayList arrayList, Context context) {
        this.arrayList = arrayList;
    }

    public CheckAnserAdapter(LayoutInflater layoutInflater, Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question question = new Question();
        ViewHoder viewHoder;
        if (convertView == null) {
            viewHoder = new ViewHoder();
            convertView = layoutInflater.inflate(R.layout.grid_answer, null);
            viewHoder.cauhoi = convertView.findViewById(R.id.cauhoi);
            viewHoder.dapan = (TextView) convertView.findViewById(R.id.dapan);
            convertView.setTag(viewHoder);


        } else {
            viewHoder = (ViewHoder) convertView.getTag();
        }



        int i=position + 1;
        viewHoder.cauhoi.setText("Câu " + i +": ");
        viewHoder.dapan.setText(question.getResult());
        return convertView;
    }

    private static class ViewHoder {
        TextView cauhoi, dapan;


    }
}
