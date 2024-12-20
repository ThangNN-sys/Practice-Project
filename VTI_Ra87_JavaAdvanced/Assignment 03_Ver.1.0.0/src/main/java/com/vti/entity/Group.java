package com.vti.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Group`")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "GroupID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorID", nullable = false)
    private Account creator;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "Group", fetch = FetchType.EAGER)
    private List<GroupAccount> accounts;

    public Group() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<GroupAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<GroupAccount> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {

        for (GroupAccount groupAccount : accounts) {
            System.out.println(groupAccount.getAccount().getFullName());
            System.out.println(groupAccount.getJoinDate());
        }

        return "Group [id=" + id + ", name=" + name + ", creator=" + creator.getFullName() + ", createDate="
                + createDate + "]";
    }
}
