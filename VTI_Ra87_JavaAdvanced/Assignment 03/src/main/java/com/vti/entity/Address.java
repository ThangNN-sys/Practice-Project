package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AddressID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short addressId; // Maps to TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY

    @Column(name = "AddressName", length = 100, nullable = false, unique = true)
    private String addressName; // Maps to VARCHAR(100) NOT NULL UNIQUE KEY

    // Trường Address ở class DetailDepartment đang là chủ sở hữu của mối quan hệ (owning side)
    // và trường department trong entity hiện tại là phía bị ánh xạ (inverse side)
    // Address không sở hữu mối quan hệ này mà DetailDepartment mới là chủ sở hữu

    @OneToOne(mappedBy = "Address") // mapped by another field in the DetailDepartment class named Address

    // Khai báo một trường kiểu DetailDepartment, đại diện cho một thực thể DetailDepartment được ánh xạ (mapped) tới thực thể Address
    private DetailDepartment department;

    public Address() {
    }

    public short getAddressId() {
        return addressId;
    }

    public void setAddressId(short id) {
        this.addressId = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String name) {
        this.addressName = name;
    }

    public DetailDepartment getDepartment() {
        return department;
    }

    public void setDepartment(DetailDepartment department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + addressId +
                ", name='" + addressName + '\'' +
                ", department=" + department +
                '}';
    }
}
