package com.example.leafrecognition;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class PataAdapter extends RecyclerView.Adapter<PataAdapter.MyViewHolder> {

    private Context mContext;
    private List<Pata> mData;
    private MainActivity mainActivity;

    PataAdapter(MainActivity mainActivity, Context mContext, List<Pata> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_pata, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        final String path = mData.get(position).getPath();
        Log.e("path", "onBindViewHolder: " + path);
        Picasso.get().load(new File(path)).into(holder.pataImage);

        holder.pataImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.passPath(path);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView pataImage;

        MyViewHolder(View itemView) {
            super(itemView);
            pataImage = itemView.findViewById(R.id.pata_iamge);
        }
    }

}
