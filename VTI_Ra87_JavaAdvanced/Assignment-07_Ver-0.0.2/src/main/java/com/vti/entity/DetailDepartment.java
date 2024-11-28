package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class quản lý các Annotation
 * Khai báo các ánh xạ tới bảng DetailDepartment của DB
 */

@Entity
@Table(name = "DetailDepartment")
@PrimaryKeyJoinColumn(name = "DepartmentID")
public class DetailDepartment extends Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    @JsonIgnoreProperties("detailDepartments")
    private Address address;

    @Column(name = "EmulationPoint")
    private short emulationPoint; // TINYINT UNSIGNED

    public DetailDepartment() {

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public short getEmulationPoint() {
        return emulationPoint;
    }

    public void setEmulationPoint(short emulationPoint) {
        this.emulationPoint = emulationPoint;
    }

    @Override
    public String toString() {
        return "DetailDepartment{" +
                "address=" + address +
                ", emulationPoint=" + emulationPoint +
                '}';
    }
}
