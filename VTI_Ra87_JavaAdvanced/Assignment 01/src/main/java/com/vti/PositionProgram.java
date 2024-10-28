package com.vti;


import com.vti.entity.Position;
import com.vti.repository.PositionRep;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class PositionProgram {
    public static void main(String[] args) {
        PositionRep repository = new PositionRep();
        String leftAlignFormat = "|%-48s|%n";
        System.out.format("+------------------------------------------------+%n");
        System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
        System.out.format("+------------------------------------------------+%n");
        System.out.format(leftAlignFormat, "1. CREATE NEW POSITION");
        System.out.format(leftAlignFormat, "2. GET ALL POSITIONS");
        System.out.format(leftAlignFormat, "3. GET POSITION BY POSITION ID");
        System.out.format(leftAlignFormat, "4. GET POSITION BY POSITION NAME");
        System.out.format(leftAlignFormat, "5. UPDATE POSITION BY ID");
        System.out.format(leftAlignFormat, "6. DELETE POSITION BY ID");
        System.out.format(leftAlignFormat, "7. EXIT");
        System.out.format("+------------------------------------------------+%n");

        int choose = ScannerUtils.getIntegerInput();

        switch (choose) {
            case 1: // CHƯA HOÀN THÀNH
                System.out.println("\n***********CREATE NEW POSITION***********");
//				Account accountCreate = new Account();
//				System.out.println("\nPLEASE ENTER EMAIL ADDRESS:");
//				String email = ScannerUtils.getEmailInput();
//				System.out.println("\nPLEASE ENTER USERNAME:");
//				String userName = ScannerUtils.getStringInput();
//				System.out.println("\nPLEASE ENTER FIRSTNAME:");
//				String firstName = ScannerUtils.getStringInput();
//				System.out.println("\nPLEASE ENTER LASTNAME:");
//				String lastName = ScannerUtils.getStringInput();
//				accountCreate.setEmail(email);
//				accountCreate.setUsername(userName);
//				accountCreate.setFirstName(firstName);
//				accountCreate.setLastName(lastName);
//				repository.createAccount(accountCreate);
                break;
            case 2: // WORK
                System.out.println("***********GET ALL POSITIONS***********");
                List<Position> positions = repository.getAllPositions();
                for (Position position : positions) {
                    System.out.println(position);
                }
                break;
            case 3: // WORK
                System.out.println("\n***********GET POSITION BY ID***********");
                System.out.println("\nPLEASE ENTER ID:");
                short id = (short) ScannerUtils.getPositiveIntInput();
                Position positionById = repository.getPositionByID(id);
                System.out.println(positionById);
                break;
            case 4: // WORK
                System.out.println("\n***********GET POSITION BY NAME***********");
                System.out.println("\nPLEASE ENTER POSITION NAME:");
                String name = ScannerUtils.getStringInput();
                Position positionByName = repository.getPositionByName(name);
                System.out.println(positionByName);
                break;
            case 5: // CHƯA HOÀN THÀNH
                System.out.println("\n***********UPDATE POSITION BY ID***********");
//				System.out.println("\nPLEASE ENTER ID:");
//				short id5 = (short) ScannerUtils.getPosIntegerInput();
//				System.out.println("\nPLEASE ENTER POSITION NAME:");
//				String name5 = ScannerUtils.getStringInput();
//				repository.(id5, name5);

                //		System.out.println("\n\n***********UPDATE ACCOUNT 2***********"); chưa hoàn thành
                //		Account updateAccount = new Account();
                //		updateAccount.setFirstName("update");
                //		updateAccount.setLastName("003");
                //		repository.updateAccount(updateAccount);
                break;
            case 6: // WORK
                System.out.println("\n\n***********DELETE POSITION BY ID***********");
                System.out.println("\nPLEASE ENTER ID:");
                short id6 = (short) ScannerUtils.getPositiveIntInput();
                repository.deletePosition(id6);
                break;
            case 7: // WORK
                System.out.println("QUIT PROGRAM SUCCESSFULLY");
                break;
            default:
                System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
        }
    }
}
