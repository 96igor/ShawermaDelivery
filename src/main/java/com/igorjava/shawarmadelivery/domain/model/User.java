package com.igorjava.shawarmadelivery.domain.model;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String telegram;
    private String address;

    @PostConstruct
    public void init(){
        System.out.println("Init method is invoked!");
        this.setTelegram("@ig0r_z1000");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Pre destroy method is invoked!");
    }

    public User() {
    }

    public User(Long id, String name, String email, String password, String telegram, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.telegram = telegram;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
