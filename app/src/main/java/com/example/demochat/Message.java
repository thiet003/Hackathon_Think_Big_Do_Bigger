package com.example.demochat;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Message {

    private String time;

    public Message(String time, String messageBot, String messageUser, String imgBot, SubMess subMess) {
        this.time = time;
        this.messageBot = messageBot;
        this.messageUser = messageUser;
        this.imgBot = imgBot;
        this.subMess = subMess;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessageBot() {
        return messageBot;
    }

    public void setMessageBot(String messageBot) {
        this.messageBot = messageBot;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public String getImgBot() {
        return imgBot;
    }

    public void setImgBot(String imgBot) {
        this.imgBot = imgBot;
    }

    public SubMess getSubMess() {
        return subMess;
    }

    public void setSubMess(SubMess subMess) {
        this.subMess = subMess;
    }

    private String messageBot;
    private String messageUser;
    private String imgBot;
    private SubMess subMess;
}
