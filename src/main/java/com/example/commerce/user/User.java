package com.example.commerce.user;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;



@Data
public class User {
    public Integer getName;
    // private final User Users;
//    @Autowired
//    public User(User users){
//        this.Users = users;
//    }

    public User(Integer id, String name, Date joinDate) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
    }

    private Integer id;
    private String name;
    private String address;
    private Date joinDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
