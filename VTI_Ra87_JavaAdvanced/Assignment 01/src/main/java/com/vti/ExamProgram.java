package com.vti;


import com.vti.entity.Exam;
import com.vti.repository.ExamRepository;
import com.vti.utils.ScannerUtils;

import java.util.List;

public class ExamProgram {
	public static void main(String[] args) {
		ExamRepository repository = new ExamRepository();

		String leftAlignFormat = "|%-48s|%n";
		System.out.format("+------------------------------------------------+%n");
		System.out.format("|              MỜI BẠN CHỌN CHỨC NĂNG            |%n");
		System.out.format("+------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "1. CREATE NEW EXAM");
		System.out.format(leftAlignFormat, "2. GET ALL EXAMS");
		System.out.format(leftAlignFormat, "3. GET EXAM BY ID");
		System.out.format(leftAlignFormat, "4. GET EXAM BY CODE1");
		System.out.format(leftAlignFormat, "5. GET EXAM BY CODE2");
		System.out.format(leftAlignFormat, "6. GET EXAM BY TITLE");
		System.out.format(leftAlignFormat, "7. GET EXAM BY DURATION");
		System.out.format(leftAlignFormat, "8. UPDATE EXAM");
		System.out.format(leftAlignFormat, "9. DELETE EXAM");
		System.out.format(leftAlignFormat, "10. CHECK EXAM EXISTS BY ID");
		System.out.format(leftAlignFormat, "11. EXIT");
		System.out.format("+------------------------------------------------+%n");

		int choose = ScannerUtils.getPositiveIntInput();

		switch (choose) {
			case 1:
				System.out.println("\n***********CREATE NEW EXAM***********");
				Exam examCreate = new Exam();
				System.out.println("\nPLEASE ENTER EXAM TITLE:");
				String examTitle = ScannerUtils.getStringInput();
				System.out.println("\nPLEASE ENTER EXAM DURATION:");
				short examDuration = ScannerUtils.getShortInput();
				examCreate.setTitle(examTitle);
				examCreate.setDuration(examDuration);
				repository.createExam(examCreate);
				break;
			case 2:
				System.out.println("***********GET ALL EXAMS***********");
				List<Exam> exams = repository.getAllExams();
				for (Exam exam : exams) {
					System.out.println(exam);
				}
				break;
			case 3:
				System.out.println("\n***********GET EXAM BY ID***********");
				short id = (short) ScannerUtils.getPositiveIntInput();
				Exam examById = repository.getExamByID(id);
				System.out.println(examById);
				break;
			case 4:
				System.out.println("\n***********GET EXAM BY CODE 1***********");
				String examCode1 = ScannerUtils.getStringInput();
				Exam examByCode1 = repository.getExamByCode1(examCode1);
				System.out.println(examByCode1);
				break;
			case 5:
				System.out.println("\n***********GET EXAM BY CODE 2***********");
				String examCode2 = ScannerUtils.getStringInput();
				Exam examByCode2 = repository.getExamByCode1(examCode2);
				System.out.println(examByCode2);
				break;
			case 6:
				System.out.println("\n***********GET EXAM BY TITLE***********");
				String examTitle6 = ScannerUtils.getStringInput();
				Exam examByTitle6 = repository.getExamByTitle(examTitle6);
				System.out.println(examByTitle6);
				break;
			case 7:
				System.out.println("\n***********GET EXAM BY DURATION***********");
				short duration = (short) ScannerUtils.getPositiveIntInput();
				Exam examByDuration = repository.getExamByID(duration);
				System.out.println(examByDuration);
				break;
			case 8:
				System.out.println("\n***********UPDATE EXAM BY ID 1***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id8 = (short) ScannerUtils.getPositiveIntInput();
				System.out.println("\nPLEASE ENTER EXAM TITLE:");
				String examTitle8 = ScannerUtils.getStringInput();
				System.out.println("\nPLEASE ENTER EXAM DURATION:");
				short examDuration8 = ScannerUtils.getShortInput();
				repository.updateExam(id8, examTitle8, examDuration8);
//				System.out.println("\n\n***********UPDATE DEPARTMENT 2***********");
//				Department departmentUpdate = new Department();
//				departmentUpdate.setId((short) 3);
//				departmentUpdate.setName("Security2");
//				repository.updateDepartment(departmentUpdate);
				break;
			case 9:
				System.out.println("\n***********DELETE EXAM BY ID***********");
				System.out.println("\nPLEASE ENTER ID:");
				short id9 = (short) ScannerUtils.getPositiveIntInput();
				repository.deleteExam(id9);
				break;
			case 10:
				System.out.println("\n***********CHECK EXAM EXISTS BY ID***********");
				short id10 = (short) ScannerUtils.getPositiveIntInput();
				System.out.println(repository.isExamExistsByID(id10));
				break;
			case 11: // WORK
				System.out.println("QUIT PROGRAM SUCCESSFULLY");
				break;
			default:
				System.out.println("INVALID SELECTION, PLEASE SELECT AGAIN!");
		}
	}
}
