package com.vti.entity;

import java.util.Comparator;

//Tạo class Department cài đặt Interface: Comparator
//Ex5 Q1 dùng đến
public class Department implements Comparator<Department> {
	public int depId;
	public String depName;

	@Override
	public String toString() {
		return "Department " + depId + " {" + "id = " + depId + ", name = " + depName + "}";
	}

	@Override // ghi đè phương thức compare của Interface Comparator
	public int compare(Department o1, Department o2) {
		return o1.depName.compareTo(o2.depName);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		Department department = (Department) o;
		if (depName.equals(department.depName)) {
			return true;
		}
		return false;
	}

}
