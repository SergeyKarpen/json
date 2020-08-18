package com.sergeykarpen.crudconsole.model;

import java.util.Set;

public class Developer {

    private String accountStatus;
    private Long accountId;
    private Set<Long> skillIds;
    private Account account;
    private Set<Skill> skills;

    private Long id;
    private String name;

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

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Set<Long> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(Set<Long> skillIds) {
        this.skillIds = skillIds;
    }

    @Override
    public String toString() {
        return "ID:"+id+ "; " + "NAME:"+ name + "; " + "SKILLS:" +  skillIds + "; " + "ACCOUNT ID: " + accountId + "; " + "ACCOUNT:" + account+ "; " + "ACCOUNTSTATUS:" + accountStatus +"\n";
    }
}