package com.example.kindergarden.Notification;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kindergarden.Homework.Homework;
import com.example.kindergarden.R;

import java.util.List;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationViewHolder>{
    private Context context;
    private List<Notification> dataList;

    public NotificationAdapter(Context context, List<Notification> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_notification, parent,false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        holder.recTitle.setText(dataList.get(position).getTitle());
        holder.recDesc.setText(dataList.get(position).getDescription());
        holder.recDate.setText(dataList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
class NotificationViewHolder extends RecyclerView.ViewHolder{

    TextView recTitle, recDesc, recDate;
    CardView recCard;

    public NotificationViewHolder(@NonNull View itemView){
        super(itemView);
        recCard = itemView.findViewById(R.id.recCardNotif);
        recTitle = itemView.findViewById(R.id.recTitleNotif);
        recDesc = itemView.findViewById(R.id.recDescNotif);
        recDate = itemView.findViewById(R.id.recDateNotif);


    }

}