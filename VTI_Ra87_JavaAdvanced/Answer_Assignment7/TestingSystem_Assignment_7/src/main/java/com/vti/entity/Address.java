package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Address")
@Setter
@Getter
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AddressID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short addressId;

    @Column(name = "AddressName", length = 100, nullable = false, unique = true)
    private String addressName;

    @OneToMany(mappedBy = "address")
    @JsonIgnoreProperties("address")
    private List<DetailDepartment> detailDepartment;

    public Address() {
    }

    public Address(short id, String name) {
        this.addressId = id;
        this.addressName = name;
    }

//	/**
//	 * @return the addressId
//	 */
//	public short getAddressId() {
//		return addressId;
//	}
//
//	/**
//	 * @param addressId the addressId to set
//	 */
//	public void setAddressId(short addressId) {
//		this.addressId = addressId;
//	}
//
//	/**
//	 * @return the addressName
//	 */
//	public String getAddressName() {
//		return addressName;
//	}
//
//	/**
//	 * @param addressName the addressName to set
//	 */
//	public void setAddressName(String addressName) {
//		this.addressName = addressName;
//	}
//
//	/**
//	 * @return the detailDepartment
//	 */
//	public List<DetailDepartment> getDetailDepartment() {
//		return detailDepartment;
//	}
//
//	/**
//	 * @param detailDepartment the detailDepartment to set
//	 */
//	public void setDetailDepartment(List<DetailDepartment> detailDepartment) {
//		this.detailDepartment = detailDepartment;
//	}

    @Override
    public String toString() {
        return "Address [addressId=" + addressId + ", addressName=" + addressName + ", detailDepartment="
                + detailDepartment + "]";
    }

}
