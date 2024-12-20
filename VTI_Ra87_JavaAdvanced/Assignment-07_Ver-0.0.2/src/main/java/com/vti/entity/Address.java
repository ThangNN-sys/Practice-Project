package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng Address của DB
 */

@Entity
@Table(name = "Address")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "AddressID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT PRIMARY KEY
    private short id; // TINYINT UNSIGNED

    @Column(name = "AddressName", length = 100, nullable = false, unique = true)
    private String name; // VARCHAR(100) NOT NULL UNIQUE KEY

    @OneToMany(mappedBy = "address") // 1 Address to multiple DetailDepartment, DetailDepartment is owning side
    @JsonIgnoreProperties("address")
    private List<DetailDepartment> detailDepartments;

    public Address() {
    }

    public Address(short id, String name) {
        this.id = id;
        this.name = name;
    }

    public Address(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + id +
                ", addressName='" + name + '\'' +
                '}';
    }
}
