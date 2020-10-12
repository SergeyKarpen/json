package com.sergeykarpen.json.model;

import java.util.Set;

public class Developer extends BasicKitModel{

    private String accountStatus;
    private Long accountId;
    private Set<Long> skillIds;
    private Account account;
    private Set<Skill> skills;

     public void setSkills(Set<Skill> skills) {
        this.skills = skills;
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
        return name;
    }
}