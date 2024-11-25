package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Department")
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String name;

    @Column(name = "TotalMember")
    private Short totalMember;

    @OneToMany(mappedBy = "department")
    @JsonIgnoreProperties("department")
    private List<Account> accounts;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(Short id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Department(Short id, String name, Short totalMember) {
        super();
        this.id = id;
        this.name = name;
        this.totalMember = totalMember;
    }

//	public Short getId() {
//		return id;
//	}
//
//	public void setId(Short id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Short getTotalMember() {
//		return totalMember;
//	}
//
//	public void setTotalMember(Short totalMember) {
//		this.totalMember = totalMember;
//	}
//
//	public List<Account> getAccounts() {
//		return accounts;
//	}
//
//	public void setAccounts(List<Account> accounts) {
//		this.accounts = accounts;
//	}

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", totalMember=" + totalMember + ", accounts=" + accounts + "]";
    }

}
