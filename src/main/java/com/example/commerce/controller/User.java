package com.example.commerce.controller;

import java.util.List;

public class User {

    private String name;

    private String password;

    private List<String> appid;

    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAppid() {
        return appid;
    }

    public void setAppid(List<String> appid) {
        this.appid = appid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
