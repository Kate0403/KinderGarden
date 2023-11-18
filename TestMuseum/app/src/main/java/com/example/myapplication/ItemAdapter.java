package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<Item> itemArrayList;
    private ItemClickListener clickListener;
    //private Context context;

    public ItemAdapter(ArrayList<Item> itemArrayList, ItemClickListener clickListener){
        this.itemArrayList = itemArrayList;
        //this.context=context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_rv, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position){

        Item item = itemArrayList.get(position);
        holder.itemTitle.setText(item.getTitle());
        holder.itemCountry.setText(item.getCountry());
        holder.itemTimestampCreated.setText(item.getTimestampCreated());
        holder.itemTimestampUpdate.setText(item.getTimestampUpdate());
        Picasso.get().load(item.getImageLink()).into(holder.itemImageLink);
        holder.itemItemLink.setText(item.getItemLink());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(itemArrayList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount(){
        return itemArrayList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView itemTitle, itemCountry, itemTimestampCreated, itemTimestampUpdate, itemItemLink;
        private ImageView itemImageLink;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.idItemTitle);
            itemCountry = itemView.findViewById(R.id.idItemCountry);
            itemTimestampCreated = itemView.findViewById(R.id.idItemTimestampCreated);
            itemTimestampUpdate = itemView.findViewById(R.id.idItemTimestampUpdate);
            itemImageLink = itemView.findViewById(R.id.idItemImageLink);
            itemItemLink = itemView.findViewById(R.id.idItemLink);
        }



    }

    public interface ItemClickListener{
        public void onItemClick(Item item);
    }
}
