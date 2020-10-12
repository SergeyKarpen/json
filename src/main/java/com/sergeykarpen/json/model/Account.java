package com.sergeykarpen.json.model;


public class Account extends BasicKitModel {
    private AccountStatus accountStatus;

    @Override
    public String toString() {
        return name + "\n";
    }
}

