package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "`Salary`")
@Setter
@Getter
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short salaryId;

    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalaryNameConverter.class)
    private SalaryName salaryName;

    @OneToMany(mappedBy = "salary")
    @JsonIgnoreProperties("salary")
    private List<Account> accounts;

    public Salary() {
    }

//	/**
//	 * @return the salaryId
//	 */
//	public short getSalaryId() {
//		return salaryId;
//	}
//
//	/**
//	 * @param salaryId the salaryId to set
//	 */
//	public void setSalaryId(short salaryId) {
//		this.salaryId = salaryId;
//	}
//
//	/**
//	 * @return the salaryName
//	 */
//	public SalaryName getSalaryName() {
//		return salaryName;
//	}
//
//	/**
//	 * @param salaryName the salaryName to set
//	 */
//	public void setSalaryName(SalaryName salaryName) {
//		this.salaryName = salaryName;
//	}


    @Override
    public String toString() {
        return "Salary [salaryId=" + salaryId + ", salaryName=" + salaryName + ", accounts=" + accounts + "]";
    }

//	/**
//	 * @return the accounts
//	 */
//	public List<Account> getAccounts() {
//		return accounts;
//	}
//
//	/**
//	 * @param accounts the accounts to set
//	 */
//	public void setAccounts(List<Account> accounts) {
//		this.accounts = accounts;
//	}


    public enum SalaryName {
        DEV("600"), TEST("700"), SCRUM_MASTER("1500"), PM("2000");

        private String salaryName;

        private SalaryName(String salaryName) {
            this.salaryName = salaryName;
        }

        public static SalaryName toEnum(String sqlSalaryName) {
            for (SalaryName item : SalaryName.values()) {
                if (item.getSalaryName().equals(sqlSalaryName)) {
                    return item;
                }
            }
            return null;
        }

        public String getSalaryName() {
            return salaryName;
        }
    }
}
