package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "position_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short positionId;

	@Column(name = "position_name", nullable = false, unique = true)
	@Convert(converter = PositionNameConverter.class)
	private PositionName positionName;
	
	@OneToMany(mappedBy = "position")
	private List<Account> accounts;

	public Position() {
	}

	public short getPositionId() {
		return positionId;
	}

	public void setPositionId(short positionId) {
		this.positionId = positionId;
	}

	public PositionName getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}

	/**
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + ", accounts=" + accounts + "]";
	}

	public enum PositionName {
		DEV("Dev"), TEST("Test"), SCRUMMASTER("ScrumMaster"), PM("PM");

		private String name;

		private PositionName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public static PositionName toEnum(String sqlStatus) {
			for (PositionName item : PositionName.values()) {
				if (item.getName().equals(sqlStatus)) {
					return item;
				}
			}
			return null;
		}
	}
}
