package com.vti.frontend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import com.vti.entity.Account;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Ass2_Program {
	public static void main(String[] args) {

// Tạo dữ liệu để thực thi
		Department dep1 = new Department();
		dep1.depId = 1;
		dep1.depName = "Hành Chính";

		Department dep2 = new Department();
		dep2.depId = 2;
		dep2.depName = "Bảo Vệ";

		Department dep3 = new Department();
		dep3.depId = 3;
		dep3.depName = "Tài Chính";

		Position pos1 = new Position();
		pos1.posId = 1;
		pos1.posName = PositionName.Dev;

		Position pos2 = new Position();
		pos2.posId = 2;
		pos2.posName = PositionName.Test;

		Position pos3 = new Position();
		pos3.posId = 3;
		pos3.posName = PositionName.Scrum_Master;

		Position pos4 = new Position();
		pos4.posId = 4;
		pos4.posName = PositionName.PM;

		Account acc1 = new Account();
		acc1.accId = 1;
		acc1.email = "acc1@gmail.com";
		acc1.userName = "UserNameAcc1";
		acc1.fullName = "Full Name Acc1";
		acc1.department = dep1;
		acc1.position = pos1;
		acc1.createDate = LocalDate.now();

		Account acc2 = new Account();
		acc2.accId = 2;
		acc2.email = "acc2@gmail.com";
		acc2.userName = "UserNameAcc2";
		acc2.fullName = "Full Name Acc2";
		acc2.department = dep2;
		acc2.position = pos2;
		acc2.createDate = LocalDate.now();

		Account acc3 = new Account();
		acc3.accId = 3;
		acc3.email = "acc3@gmail.com";
		acc3.userName = "UserNameAcc3";
		acc3.fullName = "Full Name Acc3";
		acc3.department = dep3;
		acc3.position = pos3;
		acc3.createDate = LocalDate.now();

		Group gru1 = new Group();
		gru1.groupId = 1;
		gru1.groupName = "Group1";
		gru1.creatorAcc = acc1;
		gru1.createDate = LocalDate.now();

		Group gru2 = new Group();
		gru2.groupId = 2;
		gru2.groupName = "Group2";
		gru2.creatorAcc = acc2;
		gru2.createDate = LocalDate.now();

		Group gru3 = new Group();
		gru3.groupId = 3;
		gru3.groupName = "Group3";
		gru3.creatorAcc = acc2;
		gru3.createDate = LocalDate.now();

		GroupAccount gra1 = new GroupAccount();
		gra1.groupAccId = gru1.groupId;
		gra1.accountId = acc1;
		gra1.joinDate = LocalDate.now();

		GroupAccount gra2 = new GroupAccount();
		gra2.groupAccId = gru2.groupId;
		gra2.accountId = acc2;
		gra2.joinDate = LocalDate.now();

		GroupAccount gra3 = new GroupAccount();
		gra3.groupAccId = gru3.groupId;
		gra3.accountId = acc3;
		gra3.joinDate = LocalDate.now();

		CategoryQuestion cqu1 = new CategoryQuestion();
		cqu1.categoryQuestionId = 1;
		cqu1.categoryQuestionName = "Java Question";

		CategoryQuestion cqu2 = new CategoryQuestion();
		cqu2.categoryQuestionId = 2;
		cqu2.categoryQuestionName = ".NET Question";

		CategoryQuestion cqu3 = new CategoryQuestion();
		cqu3.categoryQuestionId = 3;
		cqu3.categoryQuestionName = "SQL Question";

		Exam exa1 = new Exam();
		exa1.examId = 1;
		exa1.examCode = "EXAM001";
		exa1.examTitle = "Exam No.01";
		exa1.categoryQuestion = cqu1;
		exa1.duration = 60;
		exa1.creatorAcc = acc1;
		exa1.createDate = LocalDate.now();

		Exam exa2 = new Exam();
		exa2.examId = 2;
		exa2.examCode = "EXAM002";
		exa2.examTitle = "Exam No.02";
		exa2.categoryQuestion = cqu2;
		exa2.duration = 60;
		exa2.creatorAcc = acc2;
		exa2.createDate = LocalDate.now();

		Exam exa3 = new Exam();
		exa3.examId = 3;
		exa3.examCode = "EXAM003";
		exa3.examTitle = "Exam No.03";
		exa3.categoryQuestion = cqu3;
		exa3.duration = 90;
		exa3.creatorAcc = acc3;
		exa3.createDate = LocalDate.now();

		/*
		 * Question 1: Kiểm tra account thứ 2 Nếu không có phòng ban (tức là department
		 * == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban" Nếu không thì sẽ
		 * in ra text "Phòng ban của nhân viên này là: ..."
		 */
		System.out.println("+---Excercise 2---Question 1---+");
		System.out.println("Kiểm tra phòng ban của account 2");
		if (acc2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là: " + acc2.department.depName);
		}

		/*
		 * Question 2: Kiểm tra account thứ 2 Nếu không có group thì sẽ in ra text
		 * "Nhan viên này chưa có group" Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra
		 * text "Group của nhân viên này là Java Fresher, C#
		 * Fresher" Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
		 * quan trọng, tham gia nhiều
		 * group" Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
		 * người hóng chuyện, tham gia tất cả các group"
		 */

		System.out.println("+---Excercise 2---Question 2---+");
		if (acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else if (acc2.groups.length == 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} else if (acc2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}

// Question 3: Sử dụng toán tử tennary để làm Question 1
		System.out.println("+---Excercise 2---Question 3---+");
		System.out.println(acc2.department == null ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là: " + acc2.department.depName);

// Question 4: Sử dụng toán tử tennary để kiểm tra position của account thứ 1
		System.out.println("+---Excercise 2---Question 4---+");
		System.out.println(
				acc1.position.posName == PositionName.Dev ? "Đấy là Developer" : "Người này không phải là Developer");

// Question 5: Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format
		System.out.println("+---Excercise 2---Question 5---+");
		if (gra1.accounts == null) {
			System.out.println("Nhóm này chưa có thành viên");
		} else {
			switch (gra1.accounts.length) {
			case 1:
				System.out.println("Nhóm có một thành viên");
				break;
			case 2:
				System.out.println("Nhóm có hai thành viên");
				break;
			case 3:
				System.out.println("Nhóm có ba thành viên");
				break;
			default:
				System.out.println("Nhóm có nhiều thành viên");
				break;
			}

		}

// Question 6: Sử dụng switch case để làm lại Question 2
		System.out.println("+---Excercise 2---Question 6---+");
		if (acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else {
			switch (acc2.groups.length) {
			case 2:
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
				break;
			case 3:
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
				break;
			default:
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
				break;
			}
		}

		// Question 7: Sử dụng switch case để làm lại Question 4
		System.out.println("+---Excercise 2---Question 7---+");
		if (acc1.position == null) {
			System.out.println("Nhân viên này chưa có chức danh");
		} else {
			switch (acc1.position.posName) {
			case Dev:
				System.out.println("Đấy là Developer");
				break;
			default:
				System.out.println("Người này không phải là Developer");
				break;
			}
		}

// Question 8: in ra thông tin các account bao gồm: Email, fullname và tên phòng ban của họ
		System.out.println("+---Excercise 2---Question 8---+");
		Account[] accArray = { acc1, acc2, acc3 };
		for (Account account : accArray) {
			System.out.println("Email: " + account.email + ", " + "Full Name: " + account.fullName + ", "
					+ "Tên phòng ban của người này là: " + account.department.depName);
		}
// Question 9: In ra thông tin các phòng ban bao gồm id và name		
		System.out.println("+---Excercise 2---Question 9---+");
		Department[] depArray = { dep1, dep2, dep3 };
		for (Department department : depArray) {
			System.out.println(
					"Department ID: " + department.depId + ", " + "Tên của phòng ban là: " + department.depName);
		}
// Q10: In ra thông tin các account bao gồm: Email, Fullname và tên phòng ban của họ
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 10---+");
		Account[] accArray1 = { acc1, acc2 };
		for (int i = 0; i < accArray1.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("FullName: " + accArray1[i].fullName);
			System.out.println("Tên phòng ban: " + accArray1[i].department.depName);
		}
// Q11: In ra thông tin các phòng ban bao gồm: Id và name
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 11---+");
		Department[] depArray1 = { dep1, dep2, dep3 };
		for (int i = 0; i < depArray1.length; i++) {
			System.out.println("Thông tin phòng ban thứ " + (i + 1) + " là");
			System.out.println("ID: " + depArray1[i].depId);
			System.out.println("Tên phòng ban: " + depArray1[i].depName);
		}
// Q12: Chỉ in ra thông tin 2 department đầu tiên như định dạng của Q10
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 12---+");
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin phòng ban thứ " + (i + 1) + " là");
			System.out.println("ID: " + depArray1[i].depId);
			System.out.println("Tên phòng ban: " + depArray1[i].depName);
		}
// Q13: In ra thông tin tất cả account ngoại trừ account thứ 2
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 13---+");
		Account[] accArray2 = { acc1, acc2, acc3 };
		for (int i = 0; i < accArray2.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accArray2[i].email);
				System.out.println("FullName: " + accArray2[i].fullName);
				System.out.println("Tên phòng ban: " + accArray2[i].department.depName);
			}
		}
//Q14: In ra thông tin tất cả các account có id < 4
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 14---+");
		Account[] accArray3 = { acc1, acc2, acc3 };
		for (int i = 0; i < accArray3.length; i++) {
			if (accArray3[i].accId < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("ID: " + accArray3[i].accId);
				System.out.println("Email: " + accArray3[i].email);
				System.out.println("FullName: " + accArray3[i].fullName);
				System.out.println("Tên phòng ban: " + accArray3[i].department.depName);
			}

		}
// Q15: In ra các số chẵn <= 20
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 15---+");
		for (int i = 0; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");

			}
		}
// Q16: làm lại Q10 bằng while kết hợp break, continue
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 16/10---+");
		int i = 0;
		while (i < accArray1.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("FullName: " + accArray1[i].fullName);
			System.out.println("Tên phòng ban: " + accArray1[i].department.depName);
			i++;
		}
// Q16: làm lại Q11 bằng while kết hợp break, continue
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 16/11---+");
		int j = 0;
		while (j < depArray1.length) {
			System.out.println("Thông tin phòng ban thứ " + (j + 1) + " là");
			System.out.println("ID: " + depArray1[j].depId);
			System.out.println("Tên phòng ban: " + depArray1[j].depName);
			j++;
		}
// Q16: làm lại Q12 bằng while kết hợp break, continue
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 16/12---+");
		int k = 0;
		while (k < 2) {
			System.out.println("Thông tin phòng ban thứ " + (k + 1) + " là");
			System.out.println("ID: " + depArray1[k].depId);
			System.out.println("Tên phòng ban: " + depArray1[k].depName);
			k++;
		}
// Q16: làm lại Q13 bằng while kết hợp break, continue
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 16/13---+");
		int l = 0;
		while (l < accArray2.length) {
			if (l != 1) {
				System.out.println("Thông tin account thứ " + (l + 1) + " là:");
				System.out.println("Email: " + accArray2[l].email);
				System.out.println("FullName: " + accArray2[l].fullName);
				System.out.println("Tên phòng ban: " + accArray2[l].department.depName);
			}
			l++;
		}
// Q16: làm lại Q14 bằng while kết hợp break, continue
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 16/14---+");
		int m = 0;
		while (m < accArray3.length) {
			if (accArray3[m].accId < 4) {
				System.out.println("Thông tin account thứ " + (m + 1) + " là:");
				System.out.println("ID: " + accArray3[m].accId);
				System.out.println("Email: " + accArray3[m].email);
				System.out.println("FullName: " + accArray3[m].fullName);
				System.out.println("Tên phòng ban: " + accArray3[m].department.depName);
			}
			m++;
		}

		/*
		 * Q17: làm lại Q10 bằng do-while kết hợp break, continue In ra thông tin các
		 * account bao gồm: Email, Fullname và tên phòng ban của họ
		 */
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 17/10---+");
		int p = 0;
		do {
			System.out.println("Thông tin account thứ " + (p + 1) + " là:");
			System.out.println("Email: " + accArray1[p].email);
			System.out.println("FullName: " + accArray1[p].fullName);
			System.out.println("Tên phòng ban: " + accArray1[p].department.depName);
			p++;
		} while (p < accArray1.length);
		/*
		 * Q17: làm lại Q11 bằng do-while kết hợp break, continue In ra thông tin các
		 * phòng ban bao gồm: Id và name
		 */
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 17/11---+");
		int q = 0;
		do {
			System.out.println("Thông tin phòng ban thứ " + (q + 1) + " là");
			System.out.println("ID: " + depArray1[q].depId);
			System.out.println("Tên phòng ban: " + depArray1[q].depName);
			q++;
		} while (q < depArray1.length);
// Q17: làm lại Q12 bằng do-while kết hợp break, continue Chỉ in ra thông tin 2 department đầu tiên như định dạng của Q10
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 17/12---+");
		int r = 0;
		do {
			System.out.println("Thông tin phòng ban thứ " + (r + 1) + " là");
			System.out.println("ID: " + depArray1[r].depId);
			System.out.println("Tên phòng ban: " + depArray1[r].depName);
			r++;
		} while (r < 2);
// Q17: làm lại Q13 bằng do-while kết hợp break, continue In ra thông tin tất cả account ngoại trừ account thứ 2
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 17/13---+");
		int s = 0;
		do {
			System.out.println("Thông tin account thứ " + (s + 1) + " là:");
			System.out.println("Email: " + accArray2[s].email);
			System.out.println("FullName: " + accArray2[s].fullName);
			System.out.println("Tên phòng ban: " + accArray2[s].department.depName);
			s++;
		} while (s != 1);
// Q17: làm lại Q14 bằng do-while kết hợp break, continue In ra thông tin tất cả các account có id < 4
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 17/14---+");
		int t = 0;
		do {
			if (accArray3[t].accId < 4) {
				System.out.println("Thông tin account thứ " + (t + 1) + " là:");
				System.out.println("ID: " + accArray3[t].accId);
				System.out.println("Email: " + accArray3[t].email);
				System.out.println("FullName: " + accArray3[t].fullName);
				System.out.println("Tên phòng ban: " + accArray3[t].department.depName);
			}
			t++;
		} while (t < accArray3.length);
// Q17: làm lại Q15 bằng do-while kết hợp break, continue In ra các số chẵn <= 20
		System.out.println(" ");
		System.out.println("+---Excercise 2---Question 17/15---+");
		int u = 0;
		do {
			if (u % 2 == 0) {
				System.out.print(u + " ");
			}
			u++;
		} while (u <= 20);
		System.out.println(" ");
// Excercise 2 - Optional - System out printf
// Q1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
		System.out.println(" ");
		System.out.println("+---Excercise 2---Optional---Question 1---+");
		int optionQ1 = 5;
		System.out.printf("%d%n", optionQ1);
// Q2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000 
		System.out.println(" ");
		System.out.println("+---Excercise 2---Optional---Question 2---+");
		int optionQ2 = 1000000000;
		System.out.printf(Locale.US, "%,d%n", optionQ2);
// Q3: Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau 
		System.out.println(" ");
		System.out.println("+---Excercise 2---Optional---Question 3---+");
		double optionQ3 = 5.567098f;
		System.out.printf("%5.4f%n", optionQ3);
// Q4: Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
// Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
// Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		System.out.println(" ");
		System.out.println("+---Excercise 2---Optional---Question 4---+");
		String optionQ4 = "Nguyễn Văn A";
		System.out.printf("Tên tôi là \"" + optionQ4 + "\" và tôi đang độc thân%n");
// Q5: Lấy thời gian bây giờ và in ra theo định dạng sau: 24/04/2020 11h:16p:20s  
		System.out.println(" ");
		System.out.println("+---Excercise 2---Optional---Question 5---+");
		String optionQ5 = "dd:MM:yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(optionQ5);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
// Q6: In ra thông tin account (như Question 8 phần FOREACH) theo định dạng	table (giống trong Database) 

// Excercise 3 - Optional - Date Format
// Q1: In ra thông tin Exam thứ 1 và property create date sẽ được format theo định dạng vietnamese 
//		System.out.println(" ");
//		System.out.println("+---Excercise 3---Optional---Question 1---+");
//		Locale locale = new Locale("vn", "VN"); 
//		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale); 
//		String date1 = dateformat.format(exa1.createDate);  
//		System.out.println(exa1.examCode + ": " + date1);

// Excercise 4 - Optional - Random number
// Q1: In ngẫu nhiên ra 1 số nguyên  
		System.out.println(" ");
		System.out.println("+---Excercise 4---Optional---Question 1---+");
		Random random = new Random();
		int optionE4Q1 = random.nextInt();
		System.out.println("Số nguyên ngẫu nhiên là: " + optionE4Q1);
// Q2: In ngẫu nhiên ra một số thực
		System.out.println(" ");
		System.out.println("+---Excercise 4---Optional---Question 2---+");
		Random random2 = new Random();
		float optionE4Q2 = random2.nextFloat();
		System.out.println("Số thực ngẫu nhiên là: " + optionE4Q2);
//Q3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
		System.out.println(" ");
		System.out.println("+---Excercise 4---Optional---Question 3---+");
		String[] arrDanhSach = { "Mai", "Trung", "Quân", "Nghĩa", "Tín" };
		Random random3 = new Random();
		int optionE4Q3 = random3.nextInt(arrDanhSach.length);
		System.out.println("Tên 1 bạn ngẫu nhiên trong lớp là: " + arrDanhSach[optionE4Q3]);
//Q4: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995 
		System.out.println(" ");
		System.out.println("+---Excercise 4---Optional---Question 4---+");
		// lấy ra số ngày nhỏ nhất tính từ 01/01/1970
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		// lấy ra số ngày lớn nhất tính từ 01/01/1970
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
//		System.out.println("Min day:" + minDay);
//		System.out.println("Max day:" + maxDay);
		// lấy ra số ngày ngẫu nhiên trong khoảng thời gian cần lấy
		long randomDayInt = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomDay = LocalDate.ofEpochDay(randomDayInt);
		System.out.println("Ngày ngẫu nhiên là: " + randomDay);
//Q5: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
		System.out.println(" ");
		System.out.println("+---Excercise 4---Optional---Question 5---+");
		int now = (int) LocalDate.now().toEpochDay();
		int randomDate = now - random.nextInt(365);
		LocalDate resultDate = LocalDate.ofEpochDay(randomDate);
		System.out.println("Ngày ngẫu nhiên là: " + resultDate);
//Q6: Lấy ngẫu nhiên 1 ngày trong quá khứ 
		System.out.println(" ");
		System.out.println("+---Excercise 4---Optional---Question 6---+");
		int maxDay1 = (int) LocalDate.now().toEpochDay();
		long randomDay1 = random.nextInt(maxDay1);
		LocalDate resultDate1 = LocalDate.ofEpochDay(randomDay1);
		System.out.println("Ngày ngẫu nhiên là: " + resultDate1);
//Q7: Lấy ngẫu nhiên 1 số có 3 chữ số
		System.out.println(" ");
		System.out.println("+---Excercise 4---Optional---Question 7---+");
		int randomNum3 = random.nextInt(999 - 100 + 1) + 100;
		// công thức lấy số ngẫu nhiên có 3 chữ số: (số max - số min + 1) + số min
		// (Số max - số min + 1) = số chữ số có trong khoảng từ số min đến số max
		System.out.println("Số ngẫu nhiên có 3 chữ số là: " + randomNum3);
//Excercise 5 - Input from Console
//Q1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
		System.out.println(" ");
		System.out.println("+---Excercise 5---Question 1---+");
//		Scanner scE5Q1 = new Scanner(System.in);
//		System.out.println("Mời bạn nhập vào 3 số nguyên");
//		System.out.println("Số thứ nhất là: ");
//		int e5q11 = scE5Q1.nextInt();
//		System.out.println("Số thứ hai là: ");
//		int e5q12 = scE5Q1.nextInt();
//		System.out.println("Số thư ba là: ");
//		int e5q13 = scE5Q1.nextInt();
//		System.out.println("Các số bạn đã nhập là: " + e5q11 + ", " + e5q12 + ", " + e5q13);
//Q2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình 
		System.out.println(" ");
		System.out.println("+---Excercise 5---Question 2---+");
//		Scanner scE5Q2 = new Scanner(System.in);
//		System.out.println("Mời bạn nhập vào 3 số thực");
//		System.out.println("Số thứ nhất là: ");
//		float e5q21 = scE5Q2.nextFloat();
//		System.out.println("Số thứ hai là: ");
//		float e5q22 = scE5Q2.nextFloat();
//		System.out.println("Số thư ba là: ");
//		float e5q23 = scE5Q2.nextFloat();
//		System.out.println("Các số bạn đã nhập là: " + e5q21 + ", " + e5q22 + ", " + e5q23);
//Q3: Viết lệnh cho phép người dùng nhập họ và tên
		System.out.println(" ");
		System.out.println("+---Excercise 5---Question 3---+");
//		Scanner scE5Q3 = new Scanner(System.in);
//		System.out.println("Mời bạn nhập vào họ");
//		System.out.println("Họ của bạn là: ");
//		String e5q31 = scE5Q3.next();
//		System.out.println("Tên của bạn là: ");
//		String e5q32 = scE5Q3.next();
//		System.out.println("Họ và tên của bạn là: " + e5q31 + " " + e5q32);
//Q4: Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
		System.out.println(" ");
		System.out.println("+---Excercise 5---Question 4---+");
//		Scanner scE5Q4 = new Scanner(System.in);
//		System.out.println("Mời bạn nhập vào ngày sinh nhật");
//		System.out.println("Năm sinh:");
//		int year = scE5Q4.nextInt();
//		System.out.println("Tháng sinh");
//		int month = scE5Q4.nextInt();
//		System.out.println("Ngày sinh");
//		int day = scE5Q4.nextInt();
//		LocalDate dateBirth = LocalDate.of(year, month, day);
//		System.out.println("Sinh nhật của bạn là: " + dateBirth);
//Q5: Viết lệnh cho phép người dùng tạo account (viết thành method)
// Đối với property Position, Người dùng nhập vào 1 2 3 4 và vào
// chương trình sẽ chuyển thành Position.Dev, Position.Test,
// Position.ScrumMaster, Position.PM
		System.out.println(" ");
		System.out.println("+---Excercise 5---Question 5---+");
		Scanner scE5Q5 = new Scanner(System.in);
		System.out.println("Mời bạn nhập thông tin account cần tạo:");
		Account acc4 = new Account();
		System.out.println("Nhập ID:");
		acc4.accId = scE5Q5.nextInt();
		System.out.println("Nhập Email:");
		acc4.email = scE5Q5.next();
		System.out.println("Nhập Username:");
		acc4.userName = scE5Q5.next();
		System.out.println("Nhập Fullname:");
		acc4.fullName = scE5Q5.next();
		System.out.println("Nhập Position (Nhập các số từ 1 đến 4 tương ứng với 1.Dev 2.Test 3.Scrum_Master 4.PM");
		int positonNum = scE5Q5.nextInt();
		switch (positonNum) {
		case 1:
			acc4.position = pos1;
			break;
		case 2:
			acc4.position = pos2;
			break;
		case 3:
			acc4.position = pos3;
			break;
		case 4:
			acc4.position = pos4;
			break;
		}
		System.out.println("Thông tin acc vừa nhập: ID: " + acc4.accId + ", Email: " + acc4.email + ", Username: "
				+ acc4.userName + ", Fullname:" + acc4.fullName + ", Position: " + acc4.position.posName);
	}
}
