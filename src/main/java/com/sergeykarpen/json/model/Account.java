package com.sergeykarpen.json.model;


public class Account extends BasicKitModel {
    private AccountStatus accountStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "\n";
    }
}

