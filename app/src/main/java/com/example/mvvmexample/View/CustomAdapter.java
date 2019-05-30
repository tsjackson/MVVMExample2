package com.example.mvvmexample.View;

import android.graphics.ImageDecoder;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmexample.Model.ContractsPojo;
import com.example.mvvmexample.Model.PhonePojoResult;
import com.example.mvvmexample.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    ImageDecoder.OnHeaderDecodedListener callback;
    private List<ContractsPojo> dataSet = new ArrayList<ContractsPojo>();
    CustomViewHolder cardView;
    Listener listener;

    public void setDataSet(PhonePojoResult dataSet) {
        this.dataSet = dataSet.contacts;
        notifyDataSetChanged();
    }

    public
    @NonNull
    @Override
    CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false), this);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_name.setText(dataSet.get(position).name);
        holder.tv_email.setText(dataSet.get(position).email);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(dataSet.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
    public interface Listener {
        void onClick(ContractsPojo contractsPojo);
    }

    public CustomAdapter(Listener listener) {
        this.listener = listener;
    }
}
