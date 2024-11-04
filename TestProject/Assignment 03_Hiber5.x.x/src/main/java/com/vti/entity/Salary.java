package com.vti.entity;

import com.vti.entity.enumerate.SalaryName;
import com.vti.entity.enumerate.SalaryNameConvert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Salary")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalaryNameConvert.class)
    private SalaryName name;

    @OneToMany(mappedBy = "Salary")
    private List<Account> accounts;

    public Salary() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public SalaryName getName() {
        return name;
    }

    public void setName(SalaryName name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", name=" + name +
                ", accounts=" + accounts +
                '}';
    }
}
