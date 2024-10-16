package com.vti.frontend;

public class Ass_3_Exercise_4 {
	public static void main(String[] args) {

		System.out.println("+---Excercise 4---String---+");
// Q1: Nhập 1 chuỗi ký tự, đếm các từ trong ký tự đó
//		System.out.println("+---Excercise 4---Question 1---+");
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Nhập chuỗi ký tự: ");
//		String q1 = scanner.nextLine();
//		System.out.println("Số ký tự của chuỗi: " + q1.length());
//		scanner.close(); //trong 1 file class, chỉ đóng scanner một lần duy nhất
// Q2: Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
//		System.out.println(" ");
//		System.out.println("+---Excercise 4---Question 2---+");
//		Scanner scanner2 = new Scanner(System.in);
//		System.out.println("Nhập chuỗi ký tự s1: ");
//		String s1 = scanner2.nextLine();
//		System.out.println("Nhập chuỗi ký tự s2: ");
//		String s2 = scanner2.nextLine();
//		System.out.println("Chuỗi ký tự s1 và s2 sau khi gộp là: " + s1 + s2);
//		scanner2.close();
//Q3: Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chưa viết hoa chữ cái đầu thì viết hoa lên
//		System.out.println(" ");
//		System.out.println("+---Excercise 4---Question 3---+");
//		Scanner scanner3 = new Scanner(System.in);
//		System.out.println("Mời nhập tên: ");
//		String nameQ3 = scanner3.next();
//		String firstCharacterQ3 = nameQ3.substring(0, 1).toUpperCase();
//		String leftCharacterQ3 = nameQ3.substring(1);
//		nameQ3 = firstCharacterQ3 + leftCharacterQ3;
//		System.out.println("Tên của bạn là: " + nameQ3);
//		scanner3.close();
// Q4: Viết chương trình để người dùng nhập vào tên và in từng ký tự trong tên của người dùng ra 
//		System.out.println(" ");
//		System.out.println("+---Excercise 4---Question 4---+");
//		Scanner scanner4 = new Scanner(System.in);
//		System.out.println("Mời nhập tên: ");
//		String nameQ4 = scanner4.next();
//		String firstCharacterQ4 = nameQ4.substring(0, 1).toUpperCase();
//		String leftCharacterQ4 = nameQ4.substring(1);
//		nameQ4 = firstCharacterQ4 + leftCharacterQ4;
//		for (int j = 0; j < nameQ4.length(); j++) {
//			System.out.println("Ký tự thứ " + (j + 1) + " là: " + nameQ4.charAt(j));
//		}
//		scanner4.close();
//Q5: Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
//		System.out.println(" ");
//		System.out.println("+---Excercise 4---Question 5---+");
//		Scanner scanner5 = new Scanner(System.in);
//		System.out.println("Mời nhập họ: ");
//		String lastNameQ5 = scanner5.next();
//		System.out.println("Mời nhập tên: ");
//		String firstNameQ5 = scanner5.next();
//		System.out.println("Họ tên đầy đủ là: " + lastNameQ5 + " " + firstNameQ5);
//		scanner5.close();
// Q6: Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ thống sẽ tách ra họ, tên , tên đệm 
//		System.out.println(" ");
//		System.out.println("+---Excercise 4---Question 6---+");
//		String fullNameQ6;
//		String lastNameQ6 = "", middleNameQ6 = "", firstNameQ6 = "";
//		Scanner scanner6 = new Scanner(System.in);
//		System.out.println("Nhập họ tên đầy đủ: ");
//		fullNameQ6 = scanner6.nextLine();
//		fullNameQ6 = fullNameQ6.trim();
//		String[] words = fullNameQ6.split(" ");
//		lastNameQ6 = words[0];
//		firstNameQ6 = words[words.length - 1];
//		for (int i = 0; i <= words.length - 2; i++) {
//			middleNameQ6 = words[i] + " ";
//		}
//		System.out.println("Họ là: " + lastNameQ6);
//		System.out.println("Đệm là: " + middleNameQ6);
//		System.out.println("Tên là: " + firstNameQ6);
////		scanner6.close();
// Q7: Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa họ và tên của họ như sau: 
//	a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào 
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "nguyễn văn nam" 
//	b) Viết hoa chữ cái mỗi từ của người dùng 
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "Nguyễn Văn Nam"
//		System.out.println(" ");
//		System.out.println("+---Excercise 4---Question 6---+");
//		String fullNameQ7;
//		String firstCharacterQ7;
//		String leftCharacterQ7;
//		Scanner scanner7 = new Scanner(System.in);
//		System.out.println("Nhập họ tên đầy đủ:");
//		fullNameQ7 = scanner7.nextLine();
//		fullNameQ7 = fullNameQ7.trim();
//		fullNameQ7 = fullNameQ7.replaceAll("\\s+", " ");
//		System.out.println("Họ tên đầy đủ: " + fullNameQ7);
//		String[] wordsQ7 = fullNameQ7.split(" ");
//		fullNameQ7 = "";
//		for (String wordQ7 : wordsQ7) {
//			firstCharacterQ7 = wordQ7.substring(0, 1).toUpperCase();
//			leftCharacterQ7 = wordQ7.substring(1);
//			wordQ7 = firstCharacterQ7 + leftCharacterQ7;
//			fullNameQ7 += wordQ7 + " ";
//		}
//		System.out.println("Họ tên sau khi chuẩn hóa: " + fullNameQ7);
//		scanner7.close();
// Q8: In ra tất cả các group có chứa chữ "Java" UNCHECK
//		System.out.println(" ");
//		System.out.println("+---Excercise 4---Question 8---+");
//		String[] groupNamesQ8 = { "Java with VTI", "Cách qua môn Java", "Học gia va có khó không" };
//		for (String groupNameQ8 : groupNamesQ8) {
//			if (groupNameQ8.contains("Java")) {
//				System.out.println("Group có chứa Java: " + groupNameQ8);
//			}
//		}
// Q9: In ra tất cả các group Java UNCHECK
//		System.out.println(" ");
//		System.out.println("+---Excercise 4---Question 9---+");
//		String[] groupNamesQ9 = { "Java", "C#", "C++" };
//		for (String groupNameQ9 : groupNamesQ9) {
//			if (groupNameQ9.equals(groupNameQ9)) {
//				System.out.println("Các group Java: " + groupNameQ9);
//			}
//		}
// Q10 Option Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không. Nếu có xuất ra “OK” ngược lại “KO”. UNCHECK
//	Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau. 
//		Scanner scannerQ10 = new Scanner(System.in);
//		String s1Q10, s2Q10, reverseS1Q10 = "";
//		System.out.println("Nhập chuỗi 1:");
//		s1Q10 = scannerQ10.nextLine();
//		System.out.println("Nhập chuỗi 2:");
//		s2Q10 = scannerQ10.nextLine();
//		scannerQ10.close();
//		for (int i = s1Q10.length() - 1; i >= 0; i++) {
//			reverseS1Q10 += s1Q10.substring(i, i + 1);
//		}
//		if (s2Q10.equals(reverseS1Q10)) {
//			System.out.println("Đây là chuỗi đảo ngược");
//		} else {
//			System.out.println("Đây không phải chuỗi đảo ngược");
//		}
// Q11: Count special Character - Tìm số lần xuất hiện ký tự "a" trong chuỗi 
//		Scanner scannerQ11 = new Scanner(System.in);
//		String strQ11;
//		System.out.println("Mời bạn nhập vào một chuỗi:");
//		strQ11 = scannerQ11.nextLine();
//		scannerQ11.close();
//		int countQ11 = 0;
//		for (int i = 0; i < strQ11.length(); i++) {
//			if ('a' == strQ11.charAt(i)) {
//				countQ11++;
//			}
//			System.out.println(countQ11);
//		}
// Q12: Reverse String - Đảo ngược chuỗi sử dụng vòng lặp
//		Scanner scannerQ12 = new Scanner(System.in);
//		String s1Q12, reverseS1Q12 = "";
//		System.out.println("Nhập chuỗi:");
//		s1Q12 = scannerQ12.nextLine();
//		for (int i = s1Q12.length() - 1; i >= 0; i--) {
//			reverseS1Q12 += s1Q12.charAt(i);
//		}
//		System.out.println(reverseS1Q12);
//		scannerQ12.close();
// Q13: String not contains digit - Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược lại true. 
//		Ví dụ: 
//		"abc" => true 
//		"1abc", "abc1", "123", "a1bc", null => false 
//		Scanner scannerQ13 = new Scanner(System.in);
//		String strQ13;
//		System.out.println("Mời nhập chuỗi:");
//		strQ13 = scannerQ13.nextLine();
//		scannerQ13.close();
//		for (int i = 0; i < strQ13.length(); i++) {
//			if (Method.checkKeyNumber(strQ13.charAt(i))) {
//				System.out.println("False");
//				return;
//			}
//		}
//		System.out.println("True");
// Q14: Replace character - Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác cho trước. 
//		Ví dụ: 		"VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my" 
//		Scanner scannerQ14 = new Scanner(System.in);
//		String strQ14;
//		char ch1Q14, ch2Q14;
//		System.out.println("Nhập chuỗi:");
//		strQ14 = scannerQ14.nextLine();
//		System.out.println("Nhập ký tự muốn chuyển:");
//		ch1Q14 = scannerQ14.nextLine().toCharArray()[0]; // chuyển một mảng string sang array char, sau đó lấy phần tử
//															// thứ 0
//		System.out.println("Nhập ký tự sẽ chuyển:");
//		ch2Q14 = scannerQ14.nextLine().toCharArray()[0];
//		scannerQ14.close();
//		for (int i = 0; i < strQ14.length(); i++) {
//			if (strQ14.charAt(i) == ch1Q14) {
//				strQ14 = strQ14.replace(ch1Q14, ch2Q14);
//			}
//		}
//		System.out.println("Chuỗi sau khi chuyển: " + strQ14);
// Q15: Revert string by word - Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng thư viện. 
//		Ví dụ: " I am developer " => "developer am I". 
//		Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách. 
//		Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt chuỗi theo dấu cách
//		Scanner scannerQ15 = new Scanner(System.in);
//		String strQ15;
//		System.out.println("Mời nhập chuỗi:");
//		strQ15 = scannerQ15.nextLine();
//		scannerQ15.close();
//		strQ15 = strQ15.trim();
//		strQ15 = strQ15.replaceAll("\\s+", " ");
//		String[] wordQ15 = strQ15.split(" ");
//		for (int i = wordQ15.length - 1; i >= 0; i--) {
//			System.out.println(wordQ15[i] + " ");
//		}
// Q16: Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn hình “KO”.
//		Scanner scannerQ16 = new Scanner(System.in);
//		String strQ16;
//		int nQ16;
//		System.out.println("Chuỗi: ");
//		strQ16 = scannerQ16.nextLine();
//		System.out.println("Nhập n: ");
//		nQ16 = scannerQ16.nextInt();
//		scannerQ16.close();
//		if (strQ16 == null || strQ16.isEmpty() || strQ16.length() % nQ16 != 0) {
//			System.out.println("NO");
//			return;
//		}
//		for (int i = 0; i < strQ16.length(); i += nQ16) {
//			System.out.println(strQ16.substring(i, i + nQ16));
//		}

	}

}
