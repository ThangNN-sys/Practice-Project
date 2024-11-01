package com.vti.test;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.repository.AccountRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

/**
 * Class quản lý các chức năng CRUD
 * Dùng để xử lý các thông tin đối với bảng Account
 */

public class AccountProgram {
    public static void main(String[] args) {
        AccountRepository repository = new AccountRepository();
        int choice;
        do {
            // %: Bắt đầu một định dạng, -: Căn trái (left-aligned), 48: Độ rộng tối thiểu là 48 ký tự,
            // s: Định dạng chuỗi (string), |: Ký tự này sẽ được thêm vào trước và sau chuỗi in ra, chiếm một ô trong bảng
            // %n: Thay thế cho ký tự xuống dòng (newline) phù hợp với hệ điều hành đang chạy (Windows, Linux, v.v.)
            String leftAlignFormat = "|%-48s|%n";
            System.out.format("+------------------------------------------------+%n");
            System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
            System.out.format("+------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. CREATE NEW ACCOUNT");
            System.out.format(leftAlignFormat, "2. GET ALL ACCOUNTS");
            System.out.format(leftAlignFormat, "3. GET ACCOUNT BY ID");
            System.out.format(leftAlignFormat, "4. GET ACCOUNT BY USERNAME");
            System.out.format(leftAlignFormat, "5. GET ACCOUNT BY FIRSTNAME");
            System.out.format(leftAlignFormat, "6. GET ACCOUNT BY LASTNAME");
            System.out.format(leftAlignFormat, "7. UPDATE ACCOUNT");
            System.out.format(leftAlignFormat, "8. DELETE ACCOUNT");
            System.out.format(leftAlignFormat, "9. EXIT");
            System.out.format("+------------------------------------------------+%n");

            choice = ScannerUtils.getPositiveIntInput();

            switch (choice) {
                case 1:
                    System.out.println("\n***********CREATE NEW ACCOUNT***********");

                    break;

                case 2:
                    System.out.println("\n***********GET ALL ACCOUNTS***********");
                    List<Account> Accounts = repository.getAllAccounts();

                    for (Account account : Accounts) {
                        Department department = account.getDepartment();
                        System.out.println(department.getName());
                        System.out.println(account.getFullName());
                    }
                    break;

                case 3:
                    System.out.println("\n***********GET ACCOUNT BY ID***********");

                    break;

                case 4:
                    System.out.println("\n***********GET ACCOUNT BY USERNAME***********");

                    break;

                case 5:
                    System.out.println("\n***********GET ACCOUNT BY FIRSTNAME***********");

                    break;

                case 6:
                    System.out.println("\n***********GET ACCOUNT BY LASTNAME***********");

                    break;

                case 7:
                    System.out.println("\n***********UPDATE ACCOUNT BY ID 1***********");

                    break;

                case 8:
                    System.out.println("\n***********DELETE ACCOUNT BY ID***********");

                    break;

                case 9:
                    System.out.println("QUIT PROGRAM SUCCESSFULLY");
                    break;
                default:
                    System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
            }
        } while (choice != 9);
    }
}
