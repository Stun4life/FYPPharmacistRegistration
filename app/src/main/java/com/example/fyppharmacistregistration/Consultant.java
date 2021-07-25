package com.example.fyppharmacistregistration;

import java.io.Serializable;

public class Consultant implements Serializable {

    private int ID;
    private String name;
    private String password;

    public Consultant(String consultantName, String consultantPassword) {
        this.name = consultantName;
        this.password = consultantPassword;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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
}
