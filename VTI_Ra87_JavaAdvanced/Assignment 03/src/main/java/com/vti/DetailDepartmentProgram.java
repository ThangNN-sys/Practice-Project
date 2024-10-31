package com.vti;

import com.vti.entity.Address;
import com.vti.entity.DetailDepartment;
import com.vti.repository.AddressRep;
import com.vti.repository.DetailDepartmentRep;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class DetailDepartmentProgram {
    public static void main(String[] args) {
        DetailDepartmentRep repository = new DetailDepartmentRep();
        AddressRep addressRep = new AddressRep();
        int choice;
        do {
            // %: Bắt đầu một định dạng, -: Căn trái (left-aligned), 48: Độ rộng tối thiểu là 48 ký tự,
            // s: Định dạng chuỗi (string), |: Ký tự này sẽ được thêm vào trước và sau chuỗi in ra, chiếm một ô trong bảng
            // %n: Thay thế cho ký tự xuống dòng (newline) phù hợp với hệ điều hành đang chạy (Windows, Linux, v.v.)
            String leftAlignFormat = "|%-48s|%n";
            System.out.format("+------------------------------------------------+%n");
            System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
            System.out.format("+------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. CREATE NEW DETAIL DEPARTMENT");
            System.out.format(leftAlignFormat, "2. GET ALL DETAIL DEPARTMENTS");
            System.out.format(leftAlignFormat, "3. EXIT");
            System.out.format("+------------------------------------------------+%n");

            choice = ScannerUtils.getPositiveIntInput();

            switch (choice) {
                case 1: // WORK
                    System.out.println("\n***********CREATE NEW DETAIL DEPARTMENT***********");
                    DetailDepartment detailDepartmentCreate = new DetailDepartment();
                    // get address by id
                    System.out.println("\nPLEASE ENTER NEW DEPARTMENT NAME:");
                    String newName = ScannerUtils.getStringInput();
                    System.out.println("\nPLEASE ENTER ADDRESS ID:");
                    short addressId = ScannerUtils.getShortInput();
                    Address address = addressRep.getAddressById(addressId);
                    System.out.println("\nPLEASE ENTER EMULATION POINT:");
                    short emulationPoint = ScannerUtils.getShortInput();
                    detailDepartmentCreate.setName(newName);
                    detailDepartmentCreate.setAddress(address);
                    detailDepartmentCreate.setEmulationPoint(emulationPoint);
                    repository.createDepartment(detailDepartmentCreate);
                    break;
                case 2: // WORK
                    System.out.println("\n***********GET ALL DETAIL DEPARTMENTS***********");
                    List<DetailDepartment> detailDepartments = repository.getAllDetailDepartment();
                    for (DetailDepartment detailDepartment : detailDepartments) {
                        System.out.println(detailDepartment);
                    }
                    break;
                case 3: // WORK
                    System.out.println("QUIT PROGRAM SUCCESSFULLY");
                    break;
                default: // WORK
                    System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
            }
        } while (choice != 3);
    }
}
