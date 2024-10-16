package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;

public class Ass_3_Exercise_2 {
	public static void main(String[] args) {

// Q1: tạo 1 array Account và khởi tạo 5 phần tử theo cú pháp sau
		System.out.println("+---Excercise 2---Default Value---+");
		System.out.println("+---Excercise 2---Question 1---+");
		Account[] accArray = new Account[5];
		for (int i = 0; i < accArray.length; i++) {
			Account acc = new Account();
			acc.email = "Email " + i;
			acc.userName = "User Name " + i;
			acc.fullName = "Full Name " + i;
			acc.creatDate = LocalDate.now();
			accArray[i] = acc;
			System.out.println(
					"Thông tin account " + i + ", Email: " + accArray[i].email + ", User Name: " + accArray[i].userName
							+ ", Full Name: " + accArray[i].fullName + ", Creat Date: " + accArray[i].creatDate);
		}
	}

}
