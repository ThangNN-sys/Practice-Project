package com.vti.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "DetailDepartment")
@PrimaryKeyJoinColumn(name = "DepartmentID")
public class DetailDepartment extends Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "EmulationPoint")
	private short emulationPoint;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
	private Address address;

	public DetailDepartment() {
	}

	/**
	 * @return the emulationPoint
	 */
	public short getEmulationPoint() {
		return emulationPoint;
	}

	/**
	 * @param emulationPoint the emulationPoint to set
	 */
	public void setEmulationPoint(short emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		String addressName = address != null ? address.getAddressName() : "";
		return "DetailDepartment [emulationPoint=" + emulationPoint + ", address=" + addressName + ", getDepartmentName="
				+ getDepartmentName() + "]";
	}
	
	
}
