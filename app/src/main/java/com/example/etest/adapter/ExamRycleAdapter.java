package com.example.etest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.etest.R;
import com.example.etest.activity.ExamRycleActivity;

public class ExamRycleAdapter extends RecyclerView.Adapter<ExamRycleAdapter.ViewHoder> {


    private String[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mitemClickListener;
    private Context context;

    public ExamRycleAdapter(Context context, String[] data) {
        mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.examrycle, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        holder.mtextview.setText(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class ViewHoder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mtextview;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            mtextview = itemView.findViewById(R.id.mtextview);
            //itemView.setOnClickListener(this);
            mtextview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mitemClickListener.onItemClick(v,getAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View v) {
            if (mitemClickListener != null)
                if(v.getId() == R.id.mtextview){
                    mitemClickListener.onItemClick(v, getAdapterPosition());
                }

        }

    }


    String getItem(int id) {
        return mData[id];
    }

    public void setClickListener(ExamRycleActivity itemClickListener) {
        this.mitemClickListener = itemClickListener;

    }

    public interface ItemClickListener   {
        void onItemClick(View view, int position);
    }
}