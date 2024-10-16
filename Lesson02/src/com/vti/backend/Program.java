package com.vti.backend;

public class Program {
	
	public static void main(String args[])	{
		int age = 18;
		int status = 1;
		
		// điều kiện if không có else
		if(age >= 18) {
			System.out.println("Trưởng thành");
			
		// điều kiện if có else
		if(status > 1) {
			System.out.println("User đang hoạt động");
		} else {
			System.out.println("User đang khoá");
		}
			
		// lồng 2 điều kiện if có else
		if(status > 1) {
			System.out.println("User đang hoạt động");
		
		} else if(status == 0) {
			System.out.println("User mới tạo");
		
		} else {
			System.out.println("User đang khoá");
		
		}
		
		
		for(int i = 0; i < 100; i++) {
			System.out.println("Giá trị i = " + i);
		}
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		for (String i : cars) {
			System.out.println(i);
		}
		}
	
	}
	
	

}
