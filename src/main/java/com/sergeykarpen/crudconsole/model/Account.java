package com.sergeykarpen.crudconsole.model;


import java.util.List;
import java.util.Set;

public class Account {
    Developer developer;
    Long developerID;
    Set<Long> SkillID;
    AccountStatus accountStatus;

    public Long getDeveloperID() {
        return developerID;
    }

    public void setDeveloperID(Long developerID) {
        this.developerID = developerID;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Set<Long> getSkillID() {
        return SkillID;
    }

    public void setSkillID(Set<Long> skillID) {
        SkillID = skillID;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
