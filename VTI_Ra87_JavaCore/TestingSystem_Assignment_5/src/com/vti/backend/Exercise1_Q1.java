package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.News;

public class Exercise1_Q1 {
//	c) Tạo chương trình demo có tên là MyNews và tạo một menu lựa chọn gồm các mục sau: 
//	 Insert news 
//	 View list news 
//	 Average rate 
//	 Exit
//	( Tạo class Exercise1 để thao tác trên các list các đối tượng của class New đã tạo bên trên) 
	private Scanner sc;
	private ArrayList<News> listNews;

	public Exercise1_Q1() {
		sc = new Scanner(System.in);
		listNews = new ArrayList<News>();
	}

	public void question1() {
		loadMenu();
	}

	public void loadMenu() {
		while (true) {
			System.out.println("=========");
			System.out.println("===Lựa chọn chức năng bạn muốn sử dụng===");
			System.out.println("===1. Insert News.");
			System.out.println("===2. View List News.");
			System.out.println("===3. Average Rate.");
			System.out.println("===4. Exit.");
			System.out.println("=========");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				System.out.println("Nhập vào Title:");
				String title = sc.nextLine();
				System.out.println("Nhập vào PublishDate:");
				String publishDate = sc.nextLine();
				System.out.println("Nhập vào Author:");
				String author = sc.nextLine();
				System.out.println("Nhập vào Content:");
				String content = sc.nextLine();
				System.out.println("Nhập vào Đánh giá 1:");
				int rate1 = sc.nextInt();
				System.out.println("Nhập vào Đánh giá 2:");
				int rate2 = sc.nextInt();
				System.out.println("Nhập vào Đánh giá 3:");
				int rate3 = sc.nextInt();
				int[] rates = { rate1, rate2, rate3 };
				News news = new News(title, publishDate, author, content, rates);
				listNews.add(news);
				break;
			case 2:
				for (News news1 : listNews) {
					news1.display();
				}
				break;
			case 3:
				System.out.println("Đánh giá trung bình rate:");
				for (News news1 : listNews) {
					System.out.println("Title: " + news1.getTitle() + ", rateAVG: " + news1.calculate());
				}
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
//Nếu người dùng chọn 1 từ bàn phím thì tạo một object của 
//class News và nhập giá trị cho các thuộc tính Title, 
//PublishDate, Author, Content sau đó yêu cầu người dùng 
//nhập vào 3 đánh giá để lưu vào Rates. 
//Nếu người dùng chọn 2 từ bàn phím thì thực thi method 
//Display(). 
//Nếu người dùng chọn 3 từ bàn phím thì thực hiện method 
//Calculate() để tính đánh giá trung bình, sau đó thực thi 
//method Display(). 
//Trường hợp người dùng chọn 4 thì sẽ thoát khỏi chương 
//trình.