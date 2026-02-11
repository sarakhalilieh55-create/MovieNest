package com.example.movienest;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter1 extends RecyclerView.Adapter {
    public myAdapter1(FragmentActivity activity, ArrayList<Movie> list) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public void setOnItemClickListener(myAdapter1.OnItemClickListener movie) {
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
