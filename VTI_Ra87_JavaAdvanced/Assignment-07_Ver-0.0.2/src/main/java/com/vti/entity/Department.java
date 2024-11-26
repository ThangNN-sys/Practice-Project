package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Department của DB
 */

@Entity
@Table(name = "Department")
public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "TotalMember")
    private short totalMember; // maps to TINYINT UNSIGNED

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String name; // maps to NVARCHAR(30) NOT NULL UNIQUE KEY

    public Department() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(short totalMember) {
        this.totalMember = totalMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", totalMember=" + totalMember +
                ", name='" + name + '\'' +
                '}';
    }
}
