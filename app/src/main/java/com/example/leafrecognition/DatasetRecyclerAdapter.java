package com.example.leafrecognition;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DatasetRecyclerAdapter extends RecyclerView.Adapter<DatasetRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Dataset> mData;

    DatasetRecyclerAdapter(Context mContext, List<Dataset> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_dataset, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Intent intent = new Intent(mContext, DetailsActivity.class);
        Picasso.get().load(mData.get(position).getImage()).into(holder.pataImage);
        holder.title.setText(mData.get(position).getTitle());
        holder.sub_title.setText(mData.get(position).getSubTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("leaf", mData.get(position).getKey());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sub_title;
        TextView title;
        ImageView pataImage;

        MyViewHolder(View itemView) {
            super(itemView);
            pataImage = itemView.findViewById(R.id.pata_iamge);
            sub_title = itemView.findViewById(R.id.sub_title);
            title = itemView.findViewById(R.id.title);
        }
    }

}

