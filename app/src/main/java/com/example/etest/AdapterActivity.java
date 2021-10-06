package com.example.etest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.TextHolder> {


    private List<NumberText> NumberList;


    public AdapterActivity(Context context ,List<NumberText> NumberList) {

        this.NumberList = NumberList;

    }

    ;


    @NonNull
    @Override


    public TextHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { //khai báo đối tượng


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextHolder textholder, int i) {


        String epkieu =" " + String.valueOf(i).concat(" " + NumberList.get(i).text ) ;
        textholder.tvinfor.setText(epkieu);




    }

    @Override
    public int getItemCount() {
        return NumberList.size();
    } //trả về số hàng

    public static class TextHolder extends RecyclerView.ViewHolder {

        public TextView tvinfor;
        public ConstraintLayout layoutItem;


        public TextHolder(@NonNull View itemView) {
            super(itemView);
            tvinfor = itemView.findViewById(R.id.tvinfor);

        }
    }
}
