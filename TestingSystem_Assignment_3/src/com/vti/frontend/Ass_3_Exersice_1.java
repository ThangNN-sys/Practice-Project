package com.vti.frontend;

import java.util.Random;

public class Ass_3_Exersice_1 {
	public static void main(String[] args) {

// Q1: Khai báo 2 số lương có kiểu dữ liệu là float.
//		Khởi tạo Lương của Account 1 là 5240.5 $
//		Khởi tạo Lương của Account 2 là 10970.055$
//		Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//		Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
		System.out.println("+---Excercise 1---Question 1---+");
		double salary1;
		double salary2;
		salary1 = 5240.5f;
		salary2 = 10970.055f;
		int roundsalary1 = (int) salary1;
		int roundsalary2 = (int) salary2;
		System.out.println("Lương làm tròn của account 1 là: " + roundsalary1);
		System.out.println("Lương làm tròn của account 2 là: " + roundsalary2);

// Q2: Lấy ngẫu nhiên 1 số có 5 chữ số (số có dưới 5 chữ số sẽ thêm số 0 ở đầu cho đủ 5 chữ số)		
		System.out.println(" ");
		System.out.println("+---Excercise 1---Question 2---+");
		Random random = new Random();
		int randomNumber = random.nextInt(100000);
		System.out.printf("Số ngẫu nhiên được chọn là: %05d%n", randomNumber);

// Q3: Lấy 2 số cuối kết quả của Q2 và in ra
		System.out.println(" ");
		System.out.println("+---Excercise 1---Question 3---+");
		// Cách 1: convert số đó ra String, sau đó lấy 2 số cuối
		String x = String.valueOf(randomNumber);
		System.out.println("Hai số cuối của số ngẫu nhiên là: " + x.substring(3));
		// Cách 2: chia lấy dư số đó cho 100
//		double m = randomNumber;
//		System.out.printf("%0.2f", m / 100);

// Q4: Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
		System.out.println(" ");
		System.out.println("+---Excercise 1---Question 4---+");
		Method.question4();

	}

}
