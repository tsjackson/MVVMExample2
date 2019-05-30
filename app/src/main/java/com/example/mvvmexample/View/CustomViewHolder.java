package com.example.mvvmexample.View;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmexample.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    CustomAdapter customAdapter;
    public TextView tv_name, tv_email;
    public CardView cardView;
    public CustomViewHolder(@NonNull View itemView, CustomAdapter adapter) {
        super(itemView);
        tv_email = itemView.findViewById(R.id.tv_email);
        tv_name = itemView.findViewById(R.id.tv_name);
        cardView = itemView.findViewById(R.id.cardView);
        customAdapter = adapter;
    }
}
