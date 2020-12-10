package com.server;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Integer []> list;

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer[]> getList() {
        return list;
    }

    public void setList(ArrayList<Integer[]> list) {
        this.list = list;
    }
}
