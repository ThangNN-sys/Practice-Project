package com.vti.frontend;

public class Ass_3_Exercise_3 {
	public static void main(String[] args) {

		System.out.println("+---Excercise 3---Boxing & Unboxing---+");
// Q1: Khởi tạo lương có datatype là Integer có giá trị bằng 5000. 
//	Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân) 
		System.out.println(" ");
		System.out.println("+---Excercise 3---Question 1---+");
		Integer salary = 5000;
		System.out.printf("%2.2f%n", (float) salary);

// Q2: Khai báo 1 String "1234567", rồi convert String đó ra int
		System.out.println(" ");
		System.out.println("+---Excercise 3---Question 2---+");
		String number = "1234567";
		int numberInt = Integer.parseInt(number);
		System.out.println("Số đã chuyển đổi Q2: " + numberInt);

// Q3: khởi tạo 1 số Integer = "1234567", convert số trên thành datatype int
		System.out.println(" ");
		System.out.println("+---Excercise 3---Question 3---+");
		Integer number1 = 1234567;
		int numberInt1 = number1.intValue();
		System.out.println("Số đã chuyển đổi Q3: " + numberInt1);

	}

}
