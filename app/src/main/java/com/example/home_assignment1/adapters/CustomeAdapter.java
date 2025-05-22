package com.example.home_assignment1.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home_assignment1.R;
import com.example.home_assignment1.models.Data;
import com.example.home_assignment1.activitys.DetailActivity;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.myViewHolder> {

    private ArrayList<Data> arr;

    public CustomeAdapter(ArrayList<Data> arr) {
        this.arr = arr;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView description;
        ImageView imageViewItem;

        public myViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            description = itemView.findViewById(R.id.textDescription);
            imageViewItem = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview , parent , false ) ;
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.myViewHolder holder, int position) {
        Data data = arr.get(position);

        holder.name.setText(data.getName());
        holder.description.setText(data.getDescription());
        holder.imageViewItem.setImageResource(data.getImage());


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra("title", data.getName());
            intent.putExtra("description", data.getDescription());
            intent.putExtra("image", data.getImage());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }
}
