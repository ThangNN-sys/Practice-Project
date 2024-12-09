package com.vti.entity;

import com.vti.entity.enumerate.SalaryName;
import com.vti.entity.enumerate.SalaryNameConvert;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Salary của DB
 */

@Entity
@Table(name = "Salary")
public class Salary implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalaryNameConvert.class)
    private SalaryName name; // maps to ENUM('600','700','1500','2000') NOT NULL UNIQUE KEY

    @OneToMany(mappedBy = "salary")
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
        return "Salary { " + "ID = " + id + ", Name = '" + name.getValue() + '\'' + '}';
    }

}
