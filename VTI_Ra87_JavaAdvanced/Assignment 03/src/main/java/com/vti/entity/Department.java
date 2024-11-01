package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Department")
// Annotation @Inheritance(strategy = InheritanceType.JOINED) trong Hibernate dùng để chỉ định chiến lược kế thừa
// cho các lớp con của một entity trong cơ sở dữ liệu, theo chiến lược JOINED. Chiến lược này lưu trữ mỗi lớp con
// trong một bảng riêng, liên kết với bảng của lớp cha thông qua khóa ngoại. Điều này phù hợp khi bạn muốn lưu trữ
// các thuộc tính chung của lớp cha trong một bảng, còn các thuộc tính riêng của từng lớp con trong các bảng con tương ứng.
@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id; // Maps to TINYINT UNSIGNED AUTO_INCREMENT

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String name; // Maps to VARCHAR(30) NOT NULL UNIQUE

    @OneToMany(mappedBy = "Department", fetch = FetchType.EAGER)
    private List<Account> accounts;

    public Department() {
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
