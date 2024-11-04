package com.vti.test;


import com.vti.entity.Address;
import com.vti.repository.AddressRep;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class AddressProgram {
    public static void main(String[] args) {
        AddressRep repository = new AddressRep();
        int choice;
        do {
            // %: Bắt đầu một định dạng, -: Căn trái (left-aligned), 48: Độ rộng tối thiểu là 48 ký tự,
            // s: Định dạng chuỗi (string), |: Ký tự này sẽ được thêm vào trước và sau chuỗi in ra, chiếm một ô trong bảng
            // %n: Thay thế cho ký tự xuống dòng (newline) phù hợp với hệ điều hành đang chạy (Windows, Linux, v.v.)
            String leftAlignFormat = "|%-48s|%n";
            System.out.format("+------------------------------------------------+%n");
            System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
            System.out.format("+------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. CREATE NEW ADDRESS");
            System.out.format(leftAlignFormat, "2. GET ALL ADDRESSES");
            System.out.format(leftAlignFormat, "3. GET ADDRESS BY ID");
            System.out.format(leftAlignFormat, "4. GET ADDRESS BY ADDRESS NAME");
            System.out.format(leftAlignFormat, "5. UPDATE ADDRESS BY ID");
            System.out.format(leftAlignFormat, "6. DELETE ADDRESS BY ID");
            System.out.format(leftAlignFormat, "7. EXIT");
            System.out.format("+------------------------------------------------+%n");

            choice = ScannerUtils.getPositiveIntInput();

            switch (choice) {
                case 1: // WORK
                    System.out.println("\n***********CREATE NEW ADDRESS***********");
                    Address addressCreate = new Address();
                    System.out.println("\nPLEASE ENTER ADDRESS NAME:");
                    String addressName = ScannerUtils.getStringInput();
                    addressCreate.setName(addressName);
                    repository.createAddress(addressCreate);
                    break;
                case 2: // WORK
                    System.out.println("\n***********GET ALL ADDRESSES***********");
                    List<Address> addresses = repository.getAllAddresses();
                    for (Address address : addresses) {
                        System.out.println(address);
                    }
                    break;
                case 3: // WORK
                    System.out.println("\n***********GET ADDRESS BY ID***********");
                    System.out.println("\nPLEASE ENTER ID:");
                    short id3 = (short) ScannerUtils.getPositiveIntInput();
                    Address addressById = repository.getAddressById(id3);
                    System.out.println(addressById);
                    break;
                case 4: // WORK
                    System.out.println("\n***********GET ADDRESS BY ADDRESS NAME***********");
                    System.out.println("\nPLEASE ENTER ADDRESS NAME:");
                    String addressName4 = ScannerUtils.getStringInput();
                    Address addressByAddressName = repository.getAddressByAddressName(addressName4);
                    System.out.println(addressByAddressName);
                    break;
                case 5: // WORK
                    System.out.println("\n***********UPDATE ADDRESS BY ID 1***********");
                    System.out.println("\nPLEASE ENTER ID:");
                    short id5 = (short) ScannerUtils.getPositiveIntInput();
                    System.out.println("\nPLEASE ENTER ADDRESS NAME:");
                    String addressName5 = ScannerUtils.getStringInput();
                    repository.updateAddress(id5, addressName5);

                    //		System.out.println("\n\n***********UPDATE ACCOUNT 2***********"); chưa hoàn thành
                    //		Account updateAccount = new Account();
                    //		updateAccount.setFirstName("update");
                    //		updateAccount.setLastName("003");
                    //		repository.updateAccount(updateAccount);
                    break;
                case 6: // WORK
                    System.out.println("\n***********DELETE ADDRESS BY ID***********");
                    System.out.println("\nPLEASE ENTER ID:");
                    short id6 = (short) ScannerUtils.getPositiveIntInput();
                    repository.deleteAddress(id6);
                    break;
                case 7: // WORK
                    System.out.println("QUIT PROGRAM SUCCESSFULLY");
                    break;
                default: // WORK
                    System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
            }
        } while (choice != 7);
    }
}
