package com.example.kindergarden;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatViewHolder extends RecyclerView.ViewHolder{

    TextView chat_name_tv;

    public ChatViewHolder(@NonNull View itemView){
        super (itemView);
        chat_name_tv = itemView.findViewById(R.id.message_user);

    }


}
