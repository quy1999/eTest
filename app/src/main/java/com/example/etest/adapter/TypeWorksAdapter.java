package com.example.etest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.etest.R;
import com.example.etest.WebViewPrisentActivity;
import com.example.etest.WebViewTypesNameActivity;
import com.example.etest.model.Present;
import com.example.etest.model.TypeWorks;

import java.io.Serializable;
import java.util.List;

import javax.crypto.SecretKey;

public class TypeWorksAdapter extends RecyclerView.Adapter<TypeWorksAdapter.TypesViewHolder> {


    private List<TypeWorks> typesList; //thêm lish danh sách cách name
    private Context mcontext;

    public TypeWorksAdapter(Context context, List<TypeWorks> typesList) {
        this.typesList = typesList;
        this.mcontext = context;
    }


    @NonNull
    @Override
    public TypesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.typeworks, parent, false); //view chính là layout_item_user
        return new TypesViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull TypesViewHolder holder, int position) {
        final TypeWorks typeWorks = typesList.get(position);
        holder.typesvnname.setText(typeWorks.getNameVNTypes());
        holder.typesenname.setText(typeWorks.getNameENTypes());
        holder.layouttypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoOoView(typeWorks);
            }
        });
    }

    private void onClickGoOoView(TypeWorks typeWorks) {
        Intent intent = new Intent(mcontext, WebViewTypesNameActivity.class);
        intent.putExtra("NAME1", typeWorks.getNameVNTypes());
        mcontext.startActivity(intent);


    }


    @Override
    public int getItemCount() {
        if (typesList != null) {
            return typesList.size(); //nếu list khác rỗng thì trả về
        }
        return 0;
    }

    public class TypesViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout layouttypes;
        private TextView typesvnname;
        private TextView typesenname;

        public TypesViewHolder(@NonNull View itemView) {
            super(itemView);
            layouttypes = itemView.findViewById(R.id.layout_types);
            typesvnname = itemView.findViewById(R.id.typesvnname);
            typesenname = itemView.findViewById(R.id.typesenname);
        }
    }
}

