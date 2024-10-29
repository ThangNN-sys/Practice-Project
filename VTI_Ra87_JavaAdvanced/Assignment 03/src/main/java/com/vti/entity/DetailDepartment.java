package com.vti.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "DetailDepartment")
public class DetailDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToOne // 1-1 Relationship with Department.DepartmentID
    @JoinColumn(name = "DepartmentID", referencedColumnName = "id")
    @Id
    private Department department;

    @OneToOne // 1-1 Relationship with Address.AddressID
    @JoinColumn(name = "AddressID", referencedColumnName = "id")
    private Address address;

    @Column(name = "EmulationPoint")
    private short emulationPoint; // Maps to TINYINT UNSIGNED

    public DetailDepartment() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
                "department=" + department +
                ", address=" + address +
                ", emulationPoint=" + emulationPoint +
                '}';
    }
}
