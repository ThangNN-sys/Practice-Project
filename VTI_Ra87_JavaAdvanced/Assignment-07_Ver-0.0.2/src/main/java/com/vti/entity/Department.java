package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Department của DB
 */

@Entity
@Table(name = "Department")
@Inheritance(strategy = InheritanceType.JOINED)

public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT PRIMARY KEY
    private short departmentId; // TINYINT UNSIGNED

    @Column(name = "TotalMember")
    private short totalMember; // TINYINT UNSIGNED

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String departmentName; // NVARCHAR(30) NOT NULL UNIQUE KEY

    @OneToMany(mappedBy = "department") // 1 Department to multiple Account, Account is owning side
    @JsonIgnoreProperties("department")
    private List<Account> accounts;

    public Department() {
    }

    public Department(short departmentId, short totalMember, String departmentName) {
        this.departmentId = departmentId;
        this.totalMember = totalMember;
        this.departmentName = departmentName;
    }

    public short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(short id) {
        this.departmentId = id;
    }

    public short getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(short totalMember) {
        this.totalMember = totalMember;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String name) {
        this.departmentName = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + departmentId +
                ", totalMember=" + totalMember +
                ", name='" + departmentName + '\'' +
                '}';
    }
}
