package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;

public class Ass_4_Exc_1 {
	public static void main(String[] args) {
//Q1: Tạo constructor cho department: 
//a) Không có parameters 
//b) Có 1 parameter là nameDepartment và default id của Department = 0 
//Khởi tạo 1 Object với mỗi constructor ở trên
		System.out.println("+---Excercise 1---Question 1---+");
		Department dep1 = new Department();
		Department dep2 = new Department();
// Q2: Tạo constructor cho account:
		// a) Không có parameters
		// d) Có các parameter là id, Email, Username, FirstName, LastName (với FullName
		// = FirstName + LastName) và Position của User, createDate
		System.out.println("+---Excercise 1---Question 2---+");
		Account acc1 = new Account();
		Account acc2 = new Account(1, "acc1@gmail.com", "UserName1", "FullName1", "Position1",
				LocalDate.of(2024, 8, 25));
// Q3: Tạo constructor cho group:
		// a) Không có parameters
		// b) Có các parameter là GroupName, Creator, array Account[] accounts,
		// CreateDate
		// Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
		// Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các
		// thông tin còn lại = null).
		// Khởi tạo 1 Object với mỗi constructor ở trên
		System.out.println("+---Excercise 1---Question 3---+");
		Group gru1 = new Group();
		Group gru2 = new Group(1, "Nhóm 1", acc1, LocalDate.now(), null);
	}

}
