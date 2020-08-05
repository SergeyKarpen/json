package com.sergeykarpen.crudconsole.model;


import java.util.Set;

public class Account {
    Developer developer;
    Long developerID;
    Set<Long> skillIDs;
    AccountStatus accountStatus;

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Long getDeveloperID() {
        return developerID;
    }

    public void setDeveloperID(Long developerID) {
        this.developerID = developerID;
    }

    public Set<Long> getSkillIDs() {
        return skillIDs;
    }

    public void setSkillIDs(Set<Long> skillIDs) {
        this.skillIDs = skillIDs;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
