package com.vti.entity;

import com.vti.entity.enumerate.PositionName;
import com.vti.entity.enumerate.PositionNameConvert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Class quản lý các Annotation
 * Dùng để khai báo các ánh xạ tới bảng Position của DB
 */

@Entity
@Table(name = "Position", catalog = "TestingSystem")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short positionId;

	@Column(name = "PositionName", nullable = false, unique = true)
	@Convert(converter = PositionNameConvert.class)
	private PositionName positionName;

	@OneToMany(mappedBy = "position")
	private List<Account> accounts;

	public Position() {
	}

	public short getPositionId() {
		return positionId;
	}

	public void setPositionId(short id) {
		this.positionId = id;
	}

	public PositionName getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName name) {
		this.positionName = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Position { " + "ID = " + positionId + ", Name = '" + positionName + '\'' + '}';
	}

}
