package com.vti.test;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRep;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class DepartmentProgram {
    public static void main(String[] args) {
        DepartmentRep repository = new DepartmentRep();
        int choice;
        do {
            String leftAlignFormat = "|%-48s|%n";
            System.out.format("+------------------------------------------------+%n");
            System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
            System.out.format("+------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. CREATE NEW DEPARTMENT");
            System.out.format(leftAlignFormat, "2. GET ALL DEPARTMENTS");
            System.out.format(leftAlignFormat, "3. GET DEPARTMENT BY ID");
            System.out.format(leftAlignFormat, "4. GET DEPARTMENT BY NAME");
            System.out.format(leftAlignFormat, "5. UPDATE DEPARTMENT");
            System.out.format(leftAlignFormat, "6. DELETE DEPARTMENT");
            System.out.format(leftAlignFormat, "7. CHECK DEPARTMENT EXISTS BY ID");
            System.out.format(leftAlignFormat, "8. CHECK DEPARTMENT EXISTS BY NAME");
            System.out.format(leftAlignFormat, "9. EXIT");
            System.out.format("+------------------------------------------------+%n");

            choice = ScannerUtils.getPositiveIntInput();

            switch (choice) {
                case 1: // WORK
                    System.out.println("\n***********CREATE NEW DEPARTMENT***********");
                    Department departmentCreate = new Department();
                    System.out.println("\nPLEASE ENTER DEPARTMENT NAME:");
                    String departmentName = ScannerUtils.getStringInput();
                    departmentCreate.setName(departmentName);
                    repository.createDepartment(departmentCreate);
                    break;
                case 2: // WORK
                    System.out.println("***********GET ALL DEPARTMENTS***********");
                    List<Department> departments = repository.getAllDepartments();
                    for (Department department : departments) {
                        System.out.println(department);
                    }
                    break;
                case 3: // WORK
                    System.out.println("\n***********GET DEPARTMENT BY ID***********");
                    short id3 = (short) ScannerUtils.getPositiveIntInput();
                    Department departmentById = repository.getDepartmentByID(id3);
                    System.out.println(departmentById);
                    break;
                case 4: // WORK
                    System.out.println("\n***********GET DEPARTMENT BY NAME***********");
                    String departmentName4 = ScannerUtils.getStringInput();
                    Department departmentByName = repository.getDepartmentByName(departmentName4);
                    System.out.println(departmentByName);
                    break;
                case 5: // WORK
                    System.out.println("\n***********UPDATE DEPARTMENT BY ID 1***********");
                    System.out.println("\nPLEASE ENTER ID:");
                    short id5 = (short) ScannerUtils.getPositiveIntInput();
                    System.out.println("\nPLEASE ENTER DEPARTMENT NAME:");
                    String departmentName5 = ScannerUtils.getStringInput();
                    repository.updateDepartment(id5, departmentName5);
//				System.out.println("\n\n***********UPDATE DEPARTMENT 2***********");
//				Department departmentUpdate = new Department();
//				departmentUpdate.setId((short) 3);
//				departmentUpdate.setName("Security2");
//				repository.updateDepartment(departmentUpdate);
                    break;
                case 6: // WORK
                    System.out.println("\n***********DELETE DEPARTMENT BY ID***********");
                    System.out.println("\nPLEASE ENTER ID:");
                    short id6 = (short) ScannerUtils.getPositiveIntInput();
                    repository.deleteDepartment(id6);
                    break;
                case 7: // WORK
                    System.out.println("\n***********CHECK DEPARTMENT EXISTS BY ID***********");
                    short id7 = (short) ScannerUtils.getPositiveIntInput();
                    System.out.println(repository.isDepartmentExistsByID(id7));
                    break;
                case 8: // WORK
                    System.out.println("\n***********CHECK DEPARTMENT EXISTS BY NAME***********");
                    String departmentName8 = ScannerUtils.getStringInput();
                    System.out.println(repository.isDepartmentExistsByName(departmentName8));
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
