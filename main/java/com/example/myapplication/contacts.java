package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class contacts extends AppCompatActivity {

    private RecyclerView recycleView;
    private List<ModelData> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        recycleView = findViewById(R.id.recycleView);
        users = new ArrayList<>();

        users.add(new ModelData("Shaza AlQays", "12345", R.drawable.image1));
        users.add(new ModelData("Jhon Alba", "27495", R.drawable.image1));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(linearLayoutManager);

        recycleView.setAdapter(new RecycleViewAdapter(users, this,listener));
        recycleView.setHasFixedSize(true);


    }
    OnItemClickListener listener = new OnItemClickListener() {
        @Override public void onItemClick() {
            Intent intent = new Intent(contacts.this, opmenu.class);
            startActivity(intent);
        }
    };
    recycleView.setAdapter(new RecycleViewAdapter(users, this, listener));
}
