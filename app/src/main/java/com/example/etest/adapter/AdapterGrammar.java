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

import com.example.etest.WebViewActivity;
import com.example.etest.activity.PresentActivity;
import com.example.etest.model.NameGrammar;
import com.example.etest.R;
import com.example.etest.model.Present;

import java.util.List;

public class AdapterGrammar extends RecyclerView.Adapter<AdapterGrammar.NameViewHolder> {

    private List<NameGrammar> nameGrammarList; //thêm lish danh sách cách name
    private Context mcontext;


    public AdapterGrammar(Context context, List<NameGrammar> nameGrammarList) {
        this.nameGrammarList = nameGrammarList;
        this.mcontext = context;
    }



    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false); //view chính là layout_item_user
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) { // đây là hàm bìn dữ liệu lên list
        final NameGrammar nameGrammar = nameGrammarList.get(position);
        if (nameGrammar != null) {
            holder.tvName.setText(nameGrammar.getNameGrammar());
        }

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoOoView(nameGrammar);
            }
        });
    }

    private void onClickGoOoView(NameGrammar nameGrammar) {
        Intent intent = new Intent(mcontext, WebViewActivity.class);
        intent.putExtra("NAME",nameGrammar.getNameGrammar());
        mcontext.startActivity(intent);




    }


    @Override
    public int getItemCount() {
        if (nameGrammarList != null) {
            return nameGrammarList.size(); //nếu list khác rỗng thì trả về
        }
        return 0;

    }


    public class NameViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private LinearLayout layoutItem;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            layoutItem = itemView.findViewById(R.id.layout_item);


        }
    }

}
