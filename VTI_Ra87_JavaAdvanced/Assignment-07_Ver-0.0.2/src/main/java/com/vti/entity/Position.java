package com.vti.entity;

import com.vti.entity.enumerate.PositionName;
import com.vti.entity.enumerate.PositionNameConvert;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Position của DB
 */

@Entity
@Table(name = "Position")
public class Position implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "PositionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id; // maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

    @Column(name = "PositionName", nullable = false, unique = true)
    @Convert(converter = PositionNameConvert.class)
    private PositionName name; // maps to ENUM('Dev','Test','ScrumMaster','PM') NOT NULL UNIQUE KEY

//    @OneToMany(mappedBy = "position")
//    private List<Account> accounts;

    public Position() {
    }

    public Position(short id, String newName) {
        this.id = id;
        this.name = PositionName.valueOf(newName);
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public PositionName getName() {
        return name;
    }

    public void setName(PositionName name) {
        this.name = name;
    }

//    public List<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(List<Account> accounts) {
//        this.accounts = accounts;
//    }

    @Override
    public String toString() {
        return "Position { " + "ID = " + id + ", Name = '" + name + '\'' + '}';
    }

}
