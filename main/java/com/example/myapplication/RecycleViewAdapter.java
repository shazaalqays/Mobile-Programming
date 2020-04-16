package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<ModelData> users;
    private Context context;
    private OnItemClickListener listener;

    public RecycleViewAdapter(List<ModelData> users, Context context, OnItemClickListener listener){
        this.users = users;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.activity_contacts, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ModelData user = users.get(position);
        holder.nomeUser.setText(user.getName());
        holder.password.setText(user.getPassword());
        holder.userImage.setImageResource(user.getUserImage());
        holder.nomeUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeUser;
        private TextView password;
        private ImageView userImage;

        public ViewHolder(View itemView) {
            super(itemView);
            nomeUser = itemView.findViewById(R.id.nomeText);
            password = itemView.findViewById(R.id.password);
            userImage = itemView.findViewById(R.id.imageView);
            context = itemView.getContext();
        }

    }
}