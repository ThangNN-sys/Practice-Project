package com.vti.test;

import com.vti.entity.Employee;
import com.vti.repository.EmployeeRep;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class EmployeeProgram {
    public static void main(String[] args) {
        EmployeeRep repository = new EmployeeRep();

        int choice;
        do {
            // %: Bắt đầu một định dạng, -: Căn trái (left-aligned), 48: Độ rộng tối thiểu là 48 ký tự,
            // s: Định dạng chuỗi (string), |: Ký tự này sẽ được thêm vào trước và sau chuỗi in ra, chiếm một ô trong bảng
            // %n: Thay thế cho ký tự xuống dòng (newline) phù hợp với hệ điều hành đang chạy (Windows, Linux, v.v.)
            String leftAlignFormat = "|%-48s|%n";
            System.out.format("+------------------------------------------------+%n");
            System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
            System.out.format("+------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. CREATE NEW EMPLOYEE");
            System.out.format(leftAlignFormat, "2. GET ALL EMPLOYEES");
            System.out.format(leftAlignFormat, "3. EXIT");
            System.out.format("+------------------------------------------------+%n");

            choice = ScannerUtils.getPositiveIntInput();

            switch (choice) {
                case 1:
                    System.out.println("\n***********CREATE NEW EMPLOYEE***********");
//                    Employee employeeCreate = new Employee();
//                    // get account by id
//                    System.out.println("\nPLEASE ENTER NEW ACCOUNT NAME:");
//                    String newName = ScannerUtils.getStringInput();
//                    System.out.println("\nPLEASE ENTER EMULATION POINT:");
//                    short emulationPoint = ScannerUtils.getShortInput();
//                    employeeCreate.setName(newName);
//                    employeeCreate.setAddress(account);
//                    employeeCreate.setEmulationPoint(emulationPoint);
//                    repository.createDepartment(employeeCreate);
                    break;
                case 2: // WORK
                    System.out.println("\n***********GET ALL EMPLOYEES***********");
                    List<Employee> employees = repository.getAllEmployees();
                    for (Employee employee : employees) {
                        System.out.println(employee);
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
