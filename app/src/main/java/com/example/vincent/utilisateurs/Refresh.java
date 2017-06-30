package com.example.vincent.utilisateurs;


import java.util.ArrayList;

public class Refresh {

    private ArrayList<User> list = new ArrayList<User>();

    public Refresh(ArrayList<User> list) {

        this.list = list;
    }

    public ArrayList<User> getList() {

        return list;
    }

    public void setList(ArrayList<User> list) {

        this.list = list;
    }
}
