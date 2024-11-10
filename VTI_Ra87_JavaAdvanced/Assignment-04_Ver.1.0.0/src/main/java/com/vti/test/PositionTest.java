package com.vti.test;

import com.vti.entity.Position;
import com.vti.repository.PositionRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

/**
 * Class quản lý các chức năng CRUD
 * Dùng để test các chức năng quản lý thông tin đối với bảng Department
 */

public class PositionTest {
	public static void main(String[] args) {
		PositionRepository repository = new PositionRepository();

		int choice;

		do {
			String leftAlignFormat = "|%-48s|%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. CREATE NEW POSITION - Closed");
			System.out.format(leftAlignFormat, "2. GET ALL POSITIONS");
			System.out.format(leftAlignFormat, "3. GET POSITION BY ID");
			System.out.format(leftAlignFormat, "4. UPDATE POSITION - Closed");
			System.out.format(leftAlignFormat, "5. DELETE POSITION - Closed");
			System.out.format(leftAlignFormat, "6. EXIT");
			System.out.format("+------------------------------------------------+%n");

			choice = ScannerUtils.getPositiveIntInput();

			switch (choice) {
				case 1: // TODO: viết lại hàm để create với kiểu dữ liệu ENUM
//					System.out.println("***********CREATE NEW POSITION***********");
//					Position positionCreate = new Position();
//					System.out.println("\nPLEASE ENTER POSITION NAME:");
//					String positionName = ScannerUtils.getStringInput();
//					positionCreate.setPositionName(PositionName.valueOf(positionName));
//					repository.createPosition(positionCreate);
					break;

				case 2: // WORK
					System.out.println("***********GET ALL POSITIONS***********");
					List<Position> positions = repository.getAllPositions();
					for (Position position : positions) {
						System.out.println("Position: " + position.getPositionName());
						System.out.println("----------------------------------");
					}
					break;

				case 3: // WORK
					System.out.println("\n***********GET POSITION BY ID***********");
					System.out.println("\nPLEASE ENTER ID:");
					short id3 = (short) ScannerUtils.getPositiveIntInput();
					Position positionById = repository.getPositionByID(id3);
					System.out.println(positionById);
					break;

				case 4: // TODO: viết lại hàm để update với kiểu dữ liệu ENUM
					System.out.println("\n***********UPDATE POSITION BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id4 = (short) ScannerUtils.getPositiveIntInput();
//					System.out.println("\nPLEASE ENTER POSITION NAME:");
//					String positionName4 = ScannerUtils.getStringInput();
//					repository.updatePosition(id4, positionName4);
					break;

				case 5: // TODO: viết lại hàm để delete với kiểu dữ liệu ENUM
					System.out.println("\n***********DELETE POSITION BY ID***********");
//					System.out.println("\nPLEASE ENTER ID:");
//					short id5 = (short) ScannerUtils.getPositiveIntInput();
//					repository.deletePosition(id5);
					break;

				case 6: // WORK
					System.out.println("QUIT PROGRAM SUCCESSFULLY");
					break;

				default: // WORK
					System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
			}
		} while (choice != 6);

	}
}
