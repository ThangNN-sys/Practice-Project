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

    @Column(name = "EmulationPoint")
    private String emulationPoint;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    @JsonIgnoreProperties("detailDepartment")
    private Address address;

    public DetailDepartment() {

    }

    public String getEmulationPoint() {
        return emulationPoint;
    }

    public void setEmulationPoint(String emulationPoint) {
        this.emulationPoint = emulationPoint;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DetailDepartment{" +
                "emulationPoint='" + emulationPoint + '\'' +
                ", address=" + address +
                '}';
    }
}
