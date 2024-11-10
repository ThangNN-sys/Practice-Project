package com.vti.test;

import com.vti.entity.Address;
import com.vti.repository.AddressRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

/**
 * Class quản lý các chức năng CRUD
 * Dùng để test các chức năng quản lý thông tin đối với bảng Address
 */

public class AddressTest {
	public static void main(String[] args) {
		AddressRepository repository = new AddressRepository();

		int choice;

		do {
			String leftAlignFormat = "|%-48s|%n";
			System.out.format("+------------------------------------------------+%n");
			System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
			System.out.format("+------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. CREATE NEW ADDRESS");
			System.out.format(leftAlignFormat, "2. GET ALL ADDRESSES");
			System.out.format(leftAlignFormat, "3. GET ADDRESS BY ID");
			System.out.format(leftAlignFormat, "4. UPDATE ADDRESS");
			System.out.format(leftAlignFormat, "5. DELETE ADDRESS");
			System.out.format(leftAlignFormat, "6. EXIT");
			System.out.format("+------------------------------------------------+%n");

			choice = ScannerUtils.getPositiveIntInput();

			switch (choice) {
				case 1: // WORK
					System.out.println("***********CREATE NEW ADDRESS***********");
					Address addressCreate = new Address();
					System.out.println("\nPLEASE ENTER ADDRESS NAME:");
					String addressName = ScannerUtils.getStringInput();
					addressCreate.setAddressName(addressName);
					repository.createAddress(addressCreate);
					break;

				case 2: // WORK
					System.out.println("***********GET ALL ADDRESSES***********");
					List<Address> addresses = repository.getAllAddresses();
					for (Address address : addresses) {
						System.out.println("Address: " + address.getAddressName());
						System.out.println("----------------------------------");
					}
					break;

				case 3: // WORK
					System.out.println("\n***********GET ADDRESS BY ID***********");
					System.out.println("\nPLEASE ENTER ID:");
					short id3 = (short) ScannerUtils.getPositiveIntInput();
					Address addressById = repository.getAddressByID(id3);
					System.out.println(addressById);
					break;

				case 4: // WORK
					System.out.println("\n***********UPDATE ADDRESS BY ID***********");
					System.out.println("\nPLEASE ENTER ID:");
					short id4 = (short) ScannerUtils.getPositiveIntInput();
					System.out.println("\nPLEASE ENTER ADDRESS NAME:");
					String addressName4 = ScannerUtils.getStringInput();
					repository.updateAddress(id4, addressName4);
					break;

				case 5: // WORK
					System.out.println("\n***********DELETE ADDRESS BY ID***********");
					System.out.println("\nPLEASE ENTER ID:");
					short id5 = (short) ScannerUtils.getPositiveIntInput();
					repository.deleteAddress(id5);
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
