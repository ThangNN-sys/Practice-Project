package com.vti;

import com.vti.entity.DetailDepartment;
import com.vti.repository.DetailDepartmentRep;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class DetailDepartmentProgram {
    public static void main(String[] args) {
        DetailDepartmentRep repository = new DetailDepartmentRep();
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
            System.out.format(leftAlignFormat, "3. GET DETAIL DEPARTMENT BY DEPARTMENT ID");
            System.out.format(leftAlignFormat, "4. GET DETAIL DEPARTMENT BY ADDRESS ID");
            System.out.format(leftAlignFormat, "5. UPDATE DETAIL DEPARTMENT");
            System.out.format(leftAlignFormat, "6. DELETE DETAIL DEPARTMENT");
            System.out.format(leftAlignFormat, "7. EXIT");
            System.out.format("+------------------------------------------------+%n");

            choice = ScannerUtils.getPositiveIntInput();

            switch (choice) {
                case 1:
                    System.out.println("\n***********CREATE NEW DETAIL DEPARTMENT***********");
                    DetailDepartment detailDepartmentCreate = new DetailDepartment();
                    System.out.println("\nPLEASE ENTER EMULATION POINT:");
                    short emulationPoint = ScannerUtils.getShortInput();
                    detailDepartmentCreate.setEmulationPoint(emulationPoint);
                    repository.createDetailDepartment(detailDepartmentCreate);
                    break;
                case 2:
                    System.out.println("\n***********GET ALL DEPARTMENTS***********");
                    List<DetailDepartment> detailDepartments = repository.getAllDetailDepartment();
                    for (DetailDepartment detailDepartment : detailDepartments) {
                        System.out.println(detailDepartment);
                    }
                    break;
                case 3:
                    System.out.println("\n***********GET DETAIL DEPARTMENT BY DEPARTMENT ID***********");
                    System.out.println("\nPLEASE ENTER DEPARTMENT ID:");
                    short id3 = (short) ScannerUtils.getPositiveIntInput();
                    List detailDepartmentByDepId = repository.getDetailByDepartmentId(id3);
                    System.out.println(detailDepartmentByDepId);
                    break;
                case 4:
                    System.out.println("\n***********GET DETAIL DEPARTMENT BY ADDRESS ID***********");
                    System.out.println("\nPLEASE ENTER DEPARTMENT ID:");
                    short id4 = ScannerUtils.getShortInput();
                    List detailAddressByDepId = repository.getDetailByAddressId(id4);
                    System.out.println(detailAddressByDepId);
                    break;
                case 5:
                    System.out.println("\n***********UPDATE DETAIL DEPARTMENT 1***********");
                    System.out.println("\nPLEASE ENTER DEPARTMENT ID:");
                    short depId5 = ScannerUtils.getShortInput();
                    System.out.println("\nPLEASE ENTER ADDRESS ID:");
                    short addId5 = ScannerUtils.getShortInput();
                    System.out.println("\nPLEASE ENTER EMULATION POINT:");
                    short emuPoint5 = ScannerUtils.getShortInput();
                    repository.updateDetailDepartment(depId5, addId5, emuPoint5);

                    //		System.out.println("\n\n***********UPDATE ACCOUNT 2***********"); chưa hoàn thành
                    //		Account updateAccount = new Account();
                    //		updateAccount.setFirstName("update");
                    //		updateAccount.setLastName("003");
                    //		repository.updateAccount(updateAccount);
                    break;
                case 6: // WORK
                    System.out.println("\n***********DELETE DETAIL DEPARTMENT***********");
                    System.out.println("\nPLEASE ENTER DEPARTMENT ID:");
                    short depId6 = ScannerUtils.getShortInput();
                    System.out.println("\nPLEASE ENTER ADDRESS ID:");
                    short addId6 = ScannerUtils.getShortInput();
                    repository.deleteDetailDepartment(depId6, addId6);
                    break;
                case 7: // WORK
                    System.out.println("QUIT PROGRAM SUCCESSFULLY");
                    break;
                default: // WORK
                    System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
            }
        } while (choice != 9);
    }
}
