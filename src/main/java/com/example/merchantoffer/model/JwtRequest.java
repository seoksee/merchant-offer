package com.example.merchantoffer.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JwtRequest(){

    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
