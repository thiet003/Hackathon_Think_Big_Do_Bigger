package com.example.demochat;

import java.util.List;

public class SubMess {
    public SubMess(String name, String detail, String request) {
        this.name = name;
        this.detail = detail;
        this.request = request;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    private String name;
    private String detail;
    private String request;
}
