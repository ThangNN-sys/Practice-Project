package com.vti.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class GroupAccountKey implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "GroupID", nullable = false)
    private int groupID;

    @Column(name = "AccountID")
    private int accountID;

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
