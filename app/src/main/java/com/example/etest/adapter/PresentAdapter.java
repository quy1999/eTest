package com.example.etest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.etest.R;
import com.example.etest.WebViewActivity;
import com.example.etest.WebViewPrisentActivity;
import com.example.etest.model.NameGrammar;
import com.example.etest.model.Present;

import java.util.List;

public class PresentAdapter extends RecyclerView.Adapter<PresentAdapter.PresentViewHolder>{

    private List<Present> presentList; //thêm lish danh sách cách name
    private Context mcontext;

    public PresentAdapter(Context context, List<Present> presentList) {
        this.presentList = presentList;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public PresentViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.present, parent, false); //view chính là layout_item_user
        return new PresentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PresentViewHolder holder, int position) {
        final Present present= presentList.get(position);
        holder.vnpresent.setText(present.getNameVN());
        holder.enpresent.setText(present.getNameEnglish());

        holder.layoutpresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoOoView(present);
            }
        });
    }

    private void onClickGoOoView(Present present) {
        Intent intent = new Intent(mcontext, WebViewPrisentActivity.class);
        intent.putExtra("name",present.getNameVN());
        mcontext.startActivity(intent);




    }
    @Override
    public int getItemCount() {
        if (presentList != null) {
            return presentList.size(); //nếu list khác rỗng thì trả về
        }
        return 0;
    }


    public class PresentViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout layoutpresent;
        private TextView vnpresent;
        private TextView enpresent;

        public PresentViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutpresent=itemView.findViewById(R.id.layout_present);
            vnpresent=itemView.findViewById(R.id.vnpresent);
            enpresent=itemView.findViewById(R.id.enpresent);
        }
    }
}
