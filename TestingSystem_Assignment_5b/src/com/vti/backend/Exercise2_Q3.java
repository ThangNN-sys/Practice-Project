package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Square;

public class Exercise2_Q3 {
	private Square sq;
	private Scanner sc;

	public Exercise2_Q3() {
		sc = new Scanner(System.in);
	}

	public void question3() {
		while (true) {
			System.out.println("=========");
			System.out.println("===Lựa chọn chức năng bạn muốn sử dụng===");
			System.out.println("===1. Create Square.");
			System.out.println("===2. Tính chu vi hình vuông Mục 1.");
			System.out.println("===3. Tính diện tích hình vuông Mục 1.");
			System.out.println("===4. Exit.");
			System.out.println("=========");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Nhập vào cạnh hình vuông:");
				Float a = sc.nextFloat();
				sq = new Square(a);
				System.out.println("Bạn vừa tạo thành công hình vuông có cạnh là:" + a);
				break;
			case 2:
				System.out.println("Chu vi của hình vuông là: " + sq.tinhChuVi());
				break;
			case 3:
				System.out.println("Diện tích của hình vuông là: " + sq.tinhDienTich());
			case 4:
				return;
			default:
				System.out.println("Lựa chọn đúng số ở trên.");
				break;
			}
		}
	}
}
