package com.vti;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;
import com.vti.utils.ScannerUltis;

import java.util.List;

public class ProgramGroup {
	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();

		String leftAlignFormat = "|%-48s|%n";
		System.out.format("+------------------------------------------------+%n");
		System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
		System.out.format("+------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. CREATE NEW GROUP");
		System.out.format(leftAlignFormat, "2. GET ALL GROUPS");
		System.out.format(leftAlignFormat, "3. GET GROUP BY ID");
		System.out.format(leftAlignFormat, "4. GET GROUP BY NAME");
		System.out.format(leftAlignFormat, "5. UPDATE GROUP");
		System.out.format(leftAlignFormat, "6. DELETE GROUP BY ID");
		System.out.format(leftAlignFormat, "7. CHECK GROUP EXISTS BY ID");
		System.out.format(leftAlignFormat, "8. CHECK GROUP EXISTS BY NAME");
		System.out.format(leftAlignFormat, "9. EXIT");
		System.out.format("+------------------------------------------------+%n");

		int choose = ScannerUltis.inputInt();

		switch (choose) {
			case 1:
				System.out.println("\n***********CREATE GROUP***********");
				System.out.println("\nPLEASE ENTER GROUP NAME:");
				String groupName = ScannerUltis.inputString();
				Group groupCreate = new Group();
				groupCreate.setName(groupName);
				repository.createGroup(groupCreate);
				break;
			case 2:
				System.out.println("\n***********GET ALL GROUPS***********");
				List<Group> groups = repository.getAllGroups();
				for (Group group : groups) {
					System.out.println(group);
				}
				break;
			case 3:
				System.out.println("\n***********GET GROUP BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id3 = (short) ScannerUltis.inputId();
				Group groupById = repository.getGroupByID(id3);
				System.out.println(groupById);
				break;
			case 4:
				System.out.println("\n***********GET GROUP BY NAME***********");
				System.out.println("\nPLEASE ENTER GROUPNAME:");
				String groupName4 = ScannerUltis.inputString();
				Group groupByName = repository.getGroupByName(groupName4);
				System.out.println(groupByName);
				break;
			case 5:
				System.out.println("\n\n***********UPDATE GROUP 1***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id5 = (short) ScannerUltis.inputId();
				System.out.println("\nPLEASE ENTER GROUPNAME:");
				String groupName5 = ScannerUltis.inputString();
				repository.updateGroup(id5, groupName5);
//				System.out.println("\n\n***********UPDATE GROUP 2***********");
//				Group groupUpdate = new Group();
//				groupUpdate.setId((short) 3);
//				groupUpdate.setName("Security2");
//				repository.updateGroup(groupUpdate);
				break;
			case 6:
				System.out.println("\n***********DELETE GROUP BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id6 = (short) ScannerUltis.inputId();
				repository.deleteGroup(id6);
				break;
			case 7:
				System.out.println("\n***********CHECK GROUP EXISTS BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id7 = (short) ScannerUltis.inputId();
				System.out.println(repository.isGroupExistsByID(id7));
				Group groupById7 = repository.getGroupByID(id7);
				System.out.println(groupById7);
				break;
			case 8:
				System.out.println("***********CHECK GROUP EXISTS BY NAME***********");
				System.out.println("\nPLEASE ENTER GROUPNAME:");
				String groupName8 = ScannerUltis.inputString();
				System.out.println(repository.isGroupExistsByName(groupName8));
				Group groupByName8 = repository.getGroupByName(groupName8);
				System.out.println(groupByName8);
				break;
			case 9:
				System.out.println("QUIT PROGRAM SUCCESSFULLY");
				break;
			default:
				System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
		}

//
//
//
//

//

//
//
//
//
//
//
//

	}
}
