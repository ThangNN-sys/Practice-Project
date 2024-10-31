package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "DetailDepartment")
@PrimaryKeyJoinColumn(name = "DepartmentID") // 1-1 Relationship with Department.DepartmentID
public class DetailDepartment extends Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToOne (cascade = CascadeType.ALL) // 1-1 Relationship with Address.AddressID
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    private Address address;

    @Column(name = "EmulationPoint")
    private short emulationPoint; // Maps to TINYINT UNSIGNED

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
        System.out.println(super.toString());
        return "DetailDepartment{" +
                "address=" + address +
                ", emulationPoint=" + emulationPoint +
                '}';
    }
}
