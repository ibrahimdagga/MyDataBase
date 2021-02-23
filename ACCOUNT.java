package com.example.database;

public class ACCOUNT {

    private int id ;
    private String name;
    private String email;
    private int password;

    public ACCOUNT() {
    }

    public ACCOUNT(String name, String email, int password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public ACCOUNT(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
