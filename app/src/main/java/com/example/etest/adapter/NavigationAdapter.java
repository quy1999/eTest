package com.example.etest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.etest.R;

import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.NavigationViewHoder> {
    private List<String> nameList;
    private Context context;

    public NavigationAdapter(Context context, List<String> nameList) {
        this.context = context;
        this.nameList = nameList;
    }


    @NonNull
    @Override
    public NavigationViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false); //view chính là layout_item_user
        return new NavigationAdapter.NavigationViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NavigationViewHoder holder, int position) {
        final String string = nameList.get(position);
        holder.textnavigation.setText(string);
    }


    @Override
    public int getItemCount() {
        if (nameList != null) {
            return nameList.size(); //nếu list khác rỗng thì trả về
        }
        return 0;
    }


    public class NavigationViewHoder extends RecyclerView.ViewHolder {
        TextView textnavigation;


        public NavigationViewHoder(@NonNull View itemView) {
            super(itemView);
            textnavigation = itemView.findViewById(R.id.textnavigation);
        }

    }
}
