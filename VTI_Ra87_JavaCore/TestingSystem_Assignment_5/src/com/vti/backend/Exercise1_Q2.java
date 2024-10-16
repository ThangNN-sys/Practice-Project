package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.TuyenSinh;

public class Exercise1_Q2 {
	private TuyenSinh tuyenSinh;
	private Scanner sc;

	public Exercise1_Q2() {
		sc = new Scanner(System.in);
		tuyenSinh = new TuyenSinh();
	}

	public void question2() {
		loadMenu();
	}

	private void loadMenu() {
		while (true) {
			System.out.println("=========");
			System.out.println("===Lựa chọn chức năng bạn muốn sử dụng===");
			System.out.println("===1. Insert Contestant.");
			System.out.println("===2. View Contestant.");
			System.out.println("===3. Find by Id Number.");
			System.out.println("===4. Exit.");
			System.out.println("=========");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				tuyenSinh.addContestant();
				break;
			case 2:
				tuyenSinh.showInfoContestant();
				break;
			case 3:
				System.out.println("Nhập vào ID cần tìm kiếm:");
				int id = sc.nextInt();
				tuyenSinh.findByIdNum(id);
				break;
			case 4:
				return;
			default:
				System.out.println("Lựa chọn đúng số trên Menu:");
				break;
			}
		}
	}
}
