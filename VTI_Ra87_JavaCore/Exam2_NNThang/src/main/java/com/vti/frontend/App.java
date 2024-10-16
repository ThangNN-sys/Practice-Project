package com.vti.frontend;

import java.util.List;

import com.vti.backend.presentationlayer.EmployeeController;
import com.vti.backend.presentationlayer.ManagerController;
import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.ultis.ScannerUltis;

// Lớp App có chức năng nhận thông tin từ user để chuyển cho các layers thuộc backend xử lý 
public class App {
	public static EmployeeController employeecontroller;
	public static UserController usercontroller;
	public static ManagerController managercontroller;

	public App() {
		employeecontroller = new EmployeeController();
		usercontroller = new UserController();
		managercontroller = new ManagerController();
	}

	public static void main(String[] args) throws Exception {
		App app = new App();
		boolean isLoginSuccessful = false;
		// Question4 : Viết chức năng login vào manager
		while (!isLoginSuccessful) {
			String email = ScannerUltis.inputEmail("Vui lòng điền email đăng nhập: ");
			String password = ScannerUltis.inputPassword("Vui lòng điền mật khẩu đăng nhập: ");

			isLoginSuccessful = usercontroller.checkLogin(email, password);
			if (!isLoginSuccessful) {
				System.out.println("Đăng nhập không thành công. Vui lòng kiểm tra lại email hoặc mật khẩu.");
			} else {
				System.out.println("Đăng nhập thành công");
			}
		}
		// Question 2 & 3: Viết chức năng để user nhập lệnh gọi chức năng theo bảng
		// hướng dẫn tương ứng (trường hợp login thành công)
		while (isLoginSuccessful) {
			menu();
			System.out.println("Vui lòng chọn chức năng theo số tương ứng: ");
			int choice = ScannerUltis.inputInt("Vui lòng chọn số chức năng tương ứng!");
			// sử dụng vòng lặp switch-case để bắt kết quả nhận yêu cầu của user và thực thi
			// khối code tương tứng với case 1 2 3
			switch (choice) {
			case 1:
				System.out.println("Vui lòng nhập ID Project của employee cần tìm kiếm: ");
				int idproject = ScannerUltis.inputInt("Vui lòng nhập ID Project là số nguyên");
				List<Employee> employees = employeecontroller.printEmployeesByProjectId(idproject);
				if (employees != null && !employees.isEmpty()) {
					for (Employee employee : employees) {
						System.out.println(employee);
					}
				} else {
					System.out.println("Không có nhân viên nào trong dự án với ID đã nhập.");
				}
				break;
			case 2:
				List<Manager> managers = managercontroller.getAllManagers();
				if (managers != null && !managers.isEmpty()) {
					for (Manager manager : managers) {
						System.out.println(manager);
					}
				} else {
					System.out.println("Không có danh sách Manager để hiển thị");
				}
				break;
			case 3:
				System.out.println("Đăng xuất thành công....");
				return;
			default:
				System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
				break;
			}
		}
	}

	public static void menu() {
		String leftAlignFormat = "|%-48s|%n";
		System.out.format("+------------------------------------------------+%n");
		System.out.format("|                MỜI BẠN CHỌN CHỨC NĂNG          |%n");
		System.out.format("+------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. Nhập ID Project cần tìm kiếm của Employee");
		System.out.format(leftAlignFormat, "2. Hiển thị tất cả Manager của các project");
		System.out.format(leftAlignFormat, "3. Exit");
		System.out.format("+------------------------------------------------+%n");

	}
}
