package com.example.elegantmedia;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    LayoutInflater inflater;
    List<Item> items;

    public Adapter(Context ctx, List<Item> items){
        this.inflater = LayoutInflater.from(ctx);
        this.items = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_listview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind the data
        holder.itemTitle.setText(items.get(position).getTitle());
        holder.itemAddress.setText(items.get(position).getAddress());
       // Picasso.get().load(items.get(position).getImages().getSmall()).into(holder.itemCoverImage);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView itemTitle, itemAddress, itemDescription;
        ImageView itemCoverImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemAddress = itemView.findViewById(R.id.itemAddress);
            itemCoverImage = itemView.findViewById(R.id.coverImage);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Item ID: " + getLayoutPosition(), Toast.LENGTH_SHORT).show();

            //Option1. pass the items object to detailView

            //Option2. pass the clicked Item id to detailView (Long Way)
            for(int i=0; i<items.size(); i++){
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("itemList", getLayoutPosition());
                v.getContext().startActivity(intent);
            }
        }
    }
}
