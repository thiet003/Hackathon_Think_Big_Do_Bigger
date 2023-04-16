package com.example.demochat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Message> mList;
    private MessageAdapter messageAdapter;
    private EditText edtSend;
    private ImageView btnSend;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        recyclerView = findViewById(R.id.mes_rcv);
        edtSend = findViewById(R.id.edt_send);
        btnSend = findViewById(R.id.btn_send);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mList = new ArrayList<>();
        messageAdapter = new MessageAdapter();
        SubMess subMess = new SubMess("","","");
        mList.add(new Message("","Chào bạn, bạn cần trợ giúp gì","","",subMess));
        messageAdapter.setData(mList);
        int lastItemPosition = messageAdapter.getItemCount() - 1;
        recyclerView.scrollToPosition(lastItemPosition);
        recyclerView.setAdapter(messageAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String request = edtSend.getText().toString();
                if(!edtSend.getText().toString().isEmpty())
                {
                    SubMess subMess = new SubMess("","","");
                    mList.add(new Message("","",edtSend.getText().toString(),"",subMess));
                    if(edtSend.getText().toString().toLowerCase().trim().contains("i want to transfer money for my friend"))
                    {
                        SubMess subMess2 = new SubMess("Choose Bank name","1. MB Bank\n2. VietcomBank\n3. TPBank\n4. VP Bank","Otherwise, type or voice...");
                        mList.add(new Message(date(),"","","",subMess2));
                    }
                    else
                    {
                        request1(request);
                        request2(request);
                        request3(request);
                        request4(request);
                        request5(request);
                        request6(request);
                    }





                    messageAdapter.setData(mList);
                    int lastItemPosition = messageAdapter.getItemCount() - 1;
                    recyclerView.scrollToPosition(lastItemPosition);
                    messageAdapter.notifyDataSetChanged();
                    edtSend.setText("");


                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    View vieww = getCurrentFocus();
                    if (vieww != null) {
                        imm.hideSoftInputFromWindow(vieww.getWindowToken(), 0);
                    }
                }
            }
        });

    }
    private String date()
    {
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
        if (formattedTime==null) formattedTime="";
        return formattedTime;
    }
    private void request1(String request)
    {
        Message message = mList.get(mList.size()-2);
        if(message.getSubMess().getName().compareTo("Choose Bank name")==0)
        {
            SubMess subMess2 = new SubMess("Choose Bank Account","1. 0976134251\n2. 0963765189\n3. 0963439807","Otherwise, type or voice...");
            mList.add(new Message(date(),"","","",subMess2));
        }
    }
    private void request2(String request)
    {
        Message message = mList.get(mList.size()-2);
        if(message.getSubMess().getName().compareTo("Choose Bank Account")==0)
        {
            SubMess subMess2 = new SubMess("Choose amount of money","1. 100$\n2. 500$\n3. 1000$","Otherwise, type or voice...");
            mList.add(new Message(date(),"","","",subMess2));
        }
    }
    private void request3(String request)
    {
        Message message = mList.get(mList.size()-2);
        if(message.getSubMess().getName().compareTo("Choose amount of money")==0)
        {
            SubMess subMess2 = new SubMess("","","");
            mList.add(new Message(date(),"Wanna say something before transferring money?","","",subMess2));
        }
    }
    private void request4(String request)
    {
        Message message = mList.get(mList.size()-2);
        if(message.getMessageBot().compareTo("Wanna say something before transferring money?")==0)
        {
            SubMess subMess2 = new SubMess("","","");
            mList.add(new Message(date(),"OK, i will send this to your friend.","","",subMess2));
            mList.add(new Message(date(),"Now, please type your PIN password","","",subMess2));
        }
    }
    private void request5(String request)
    {
        Message message = mList.get(mList.size()-2);
        if(message.getMessageBot().compareTo("Now, please type your PIN password")==0)
        {
            if(request.compareTo("999999")==0)
            {
                SubMess subMess2 = new SubMess("","","");
                mList.add(new Message(date(),"OK, successful transaction!","","",subMess2));
            }
            else
            {
                SubMess subMess2 = new SubMess("","","");
                mList.add(new Message(date(),"Oh no, your PIN password is incorrect!","","",subMess2));
            }
        }
    }
    private void request6(String request)
    {
        Message message = mList.get(mList.size()-2);
        if(message.getMessageBot().compareTo("Oh no, your PIN password is incorrect!")==0)
        {
            if(request.compareTo("999999")==0)
            {
                SubMess subMess2 = new SubMess("","","");
                mList.add(new Message(date(),"OK, successful transaction!","","",subMess2));
            }
            else
            {
                SubMess subMess2 = new SubMess("","","");
                mList.add(new Message(date(),"Oh no, your PIN password is incorrect!","","",subMess2));
            }
        }
    }
}