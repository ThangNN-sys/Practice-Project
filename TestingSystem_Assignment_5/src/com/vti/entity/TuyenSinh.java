package com.vti.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {
	private ArrayList<Contestant> listContestants;
	private Scanner sc;

	public TuyenSinh() {
		listContestants = new ArrayList<Contestant>();
		sc = new Scanner(System.in);
	}

	@Override // a) thêm mới thí sinh
	public void addContestant() {
		System.out.println("Nhập tên thí sinh:");
		String name = sc.nextLine();
		System.out.println(" ");
		System.out.println("Nhập địa chỉ thí sinh:");
		String address = sc.nextLine();
		System.out.println(" ");
		System.out.println("Nhập mức ưu tiên thí sinh:");
		int priority = sc.nextInt();
		System.out.println(" ");
		System.out.println("Nhập vào khối thí sinh- Chọn các khối A, B, C: ");
		String block = sc.next();
		System.out.println(" ");
		Contestant contestant = new Contestant(name, address, priority, new Block(block));
		listContestants.add(contestant);
	}

	@Override // b) hiển thị thông tin của thí sinh và khối thi
	public void showInfoContestant() {
		for (Contestant contestant : listContestants) {
			System.out.println(contestant);
		}
	}

	@Override // c) tìm kiếm theo số báo danh
	public void findByIdNum(int idNum) {
		for (Contestant contestant : listContestants) {
			if (contestant.getIdNum() == idNum) {
				System.out.println(contestant);
			}
		}
	}
}
