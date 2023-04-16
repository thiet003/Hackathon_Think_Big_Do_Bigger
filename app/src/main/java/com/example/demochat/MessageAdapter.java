package com.example.demochat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    List<Message> mList;

    public void setData(List<Message> list)
    {
        mList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messitem,parent,false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = mList.get(position);
        SubMess subMess = message.getSubMess();
        if(!subMess.getDetail().isEmpty())
        {
            holder.massagBot.setVisibility(View.GONE);
            holder.massageUser.setVisibility(View.GONE);
            holder.subMess.setVisibility(View.VISIBLE);
            holder.subMessName.setText(subMess.getName());
            holder.subMessDetail.setText(subMess.getDetail());
            holder.subMessRequest.setText(subMess.getRequest());
        }
        else if(!message.getMessageUser().isEmpty())
        {
            holder.time.setVisibility(View.GONE);
            holder.subMess.setVisibility(View.GONE);
            holder.img.setVisibility(View.GONE);
            holder.massagBot.setVisibility(View.GONE);
            holder.massageUser.setVisibility(View.VISIBLE);
            holder.massageUser.setText(message.getMessageUser());
        }
        else
        {
            holder.subMess.setVisibility(View.GONE);
            holder.img.setVisibility(View.VISIBLE);
            holder.massagBot.setVisibility(View.VISIBLE);
            holder.massageUser.setVisibility(View.GONE);
            LocalDateTime now = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                now = LocalDateTime.now();
            }

            // Định dạng lại chuỗi thời gian
            DateTimeFormatter formatter = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                formatter = DateTimeFormatter.ofPattern("HH:mm");
            }
            String formattedTime = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                formattedTime = now.format(formatter);
            }
            if(formattedTime!=null) holder.time.setText(formattedTime);
            holder.massagBot.setText(message.getMessageBot());
        }

    }

    @Override
    public int getItemCount() {
        if(mList!=null)
        {
            return mList.size();
        }
        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView time;
        private TextView massagBot;
        private TextView massageUser;
        private LinearLayout subMess;
        private TextView subMessName,subMessDetail,subMessRequest;
        private ImageView img;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.messTime);
            massagBot = itemView.findViewById(R.id.messContentBot);
            massageUser  = itemView.findViewById(R.id.messContentUser);
            img = itemView.findViewById(R.id.imgBot);
            subMess = itemView.findViewById(R.id.subMess);
            subMessName = itemView.findViewById(R.id.subMess_name);
            subMessDetail = itemView.findViewById(R.id.subMess_detail);
            subMessRequest = itemView.findViewById(R.id.subMess_request);
        }
    }
}
