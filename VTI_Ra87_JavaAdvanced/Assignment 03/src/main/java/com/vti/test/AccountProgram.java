package com.vti.test;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.repository.AccountRep;
import com.vti.utils.ScannerUtils;

import java.util.List;

/**
 * Class quản lý các chức năng CRUD
 * Dùng để xử lý các thông tin đối với bảng Account
 */

public class AccountProgram {
    public static void main(String[] args) {
        AccountRep repository = new AccountRep();
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
                case 1: // WORK
                    System.out.println("\n***********CREATE NEW ACCOUNT***********");
                    Account accCreate = new Account();
                    System.out.println("\nPLEASE ENTER EMAIL ADDRESS:");
                    String email = ScannerUtils.getEmailInput();
                    System.out.println("\nPLEASE ENTER USERNAME:");
                    String userName = ScannerUtils.getStringInput();
                    System.out.println("\nPLEASE ENTER FIRSTNAME:");
                    String firstName = ScannerUtils.getStringInput();
                    System.out.println("\nPLEASE ENTER LASTNAME:");
                    String lastName = ScannerUtils.getStringInput();
                    accCreate.setEmail(email);
                    accCreate.setUsername(userName);
                    accCreate.setFirstName(firstName);
                    accCreate.setLastName(lastName);
                    repository.createAccount(accCreate);
                    break;
                case 2: // WORK
                    System.out.println("\n***********GET ALL ACCOUNTS***********");
                    List<Account> accounts = repository.getAllAccounts();
                    for (Account account : accounts) {
//                        Department department = account.getDepartment();
//                        System.out.println(department.getName());
                        System.out.println(account.getFullName());
                    }
                    break;
                case 3: // WORK
                    System.out.println("\n***********GET ACCOUNT BY ID***********");
                    System.out.println("\nPLEASE ENTER ID:");
                    short id3 = (short) ScannerUtils.getPositiveIntInput();
                    Account accById = repository.getAccByID(id3);
                    System.out.println(accById);
                    break;
                case 4: // WORK
                    System.out.println("\n***********GET ACCOUNT BY USERNAME***********");
                    System.out.println("\nPLEASE ENTER USERNAME:");
                    String userName4 = ScannerUtils.getStringInput();
                    Account accByUserName = repository.getAccByUserName(userName4);
                    System.out.println(accByUserName);
                    break;
                case 5: // WORK
                    System.out.println("\n***********GET ACCOUNT BY FIRSTNAME***********");
                    System.out.println("\nPLEASE ENTER FIRSTNAME:");
                    String firstName5 = ScannerUtils.getStringInput();
                    List accByFirstName = repository.getAccByFirstName(firstName5);
                    for (Object account : accByFirstName) {
                        System.out.println(account);
                    }
                    break;
                case 6: // WORK
                    System.out.println("\n***********GET ACCOUNT BY LASTNAME***********");
                    System.out.println("\nPLEASE ENTER LASTNAME:");
                    String lastName6 = ScannerUtils.getStringInput();
                    List accByLastName = repository.getAccByLastName(lastName6);
                    for (Object account : accByLastName) {
                        System.out.println(account);
                    }
                    break;
                case 7: // WORK
                    System.out.println("\n***********UPDATE ACCOUNT BY ID 1***********");
                    System.out.println("\nPLEASE ENTER ID:");
                    short id7 = (short) ScannerUtils.getPositiveIntInput();
                    System.out.println("\nPLEASE ENTER FIRSTNAME:");
                    String firstName7 = ScannerUtils.getStringInput();
                    System.out.println("\nPLEASE ENTER LASTNAME:");
                    String lastName7 = ScannerUtils.getStringInput();
                    repository.updateAccount(id7, firstName7, lastName7);
                    break;
                case 8: // WORK
                    System.out.println("\n***********DELETE ACCOUNT BY ID***********");
                    System.out.println("\nPLEASE ENTER ID:");
                    short id8 = (short) ScannerUtils.getPositiveIntInput();
                    repository.deleteAccount(id8);
                    break;
                case 9: // WORK
                    System.out.println("QUIT PROGRAM SUCCESSFULLY");
                    break;
                default: // WORK
                    System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
            }
        } while (choice != 9);
    }
}
