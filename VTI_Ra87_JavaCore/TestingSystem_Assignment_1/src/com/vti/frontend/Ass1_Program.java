package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.ExamQuestion;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Question;
import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.typeName;

public class Ass1_Program {
	public static void main(String[] args) {

// Question 1: hãy chuyển sang các Object Java và tối ưu các thuộc tính

// Question 2: Tạo file Program.java và khởi tạo ít nhất 3 đối tượng đối với mỗi class

		// khởi tạo đối tượng trong class Department

		Department dep1 = new Department();
		dep1.depId = 1;
		dep1.depName = "Hành Chính";

		Department dep2 = new Department();
		dep2.depId = 2;
		dep2.depName = "Bảo Vệ";

		Department dep3 = new Department();
		dep3.depId = 3;
		dep3.depName = "Tài Chính";

		// khởi tạo đối tượng trong class Position

		Position pos1 = new Position();
		pos1.posId = 1;
		pos1.posName = PositionName.Dev;

		Position pos2 = new Position();
		pos2.posId = 2;
		pos2.posName = PositionName.Test;

		Position pos3 = new Position();
		pos3.posId = 3;
		pos3.posName = PositionName.Scrum_Master;

		Position pos4 = new Position();
		pos4.posId = 4;
		pos4.posName = PositionName.PM;

		// khởi tạo đối tượng trong class Account

		Account acc1 = new Account();
		acc1.accId = 1;
		acc1.email = "acc1@gmail.com";
		acc1.userName = "UserNameAcc1";
		acc1.fullName = "Full Name Acc1";
		acc1.department = dep1;
		acc1.position = pos1;
		acc1.createDate = LocalDate.of(2024, 04, 25);

		Account acc2 = new Account();
		acc2.accId = 2;
		acc2.email = "acc2@gmail.com";
		acc2.userName = "UserNameAcc2";
		acc2.fullName = "Full Name Acc2";
		acc2.department = dep2;
		acc2.position = pos2;
		acc2.createDate = LocalDate.now();

		Account acc3 = new Account();
		acc3.accId = 3;
		acc3.email = "acc3@gmail.com";
		acc3.userName = "UserNameAcc3";
		acc3.fullName = "Full Name Acc3";
		acc3.department = dep3;
		acc3.position = pos3;
		acc3.createDate = LocalDate.now();

		// khởi tạo đối tượng trong class Group

		Group gru1 = new Group();
		gru1.groupId = 1;
		gru1.groupName = "Group1";
		gru1.creatorAcc = acc1;
		gru1.createDate = LocalDate.now();

		Group gru2 = new Group();
		gru2.groupId = 2;
		gru2.groupName = "Group2";
		gru2.creatorAcc = acc2;
		gru2.createDate = LocalDate.now();

		Group gru3 = new Group();
		gru3.groupId = 3;
		gru3.groupName = "Group3";
		gru3.creatorAcc = acc2;
		gru3.createDate = LocalDate.now();

		// khởi tạo đối tượng trong class GroupAccount

		GroupAccount gra1 = new GroupAccount();
		gra1.groupAccId = gru1.groupId;
		gra1.accountId = acc1;
		gra1.joinDate = LocalDate.now();

		GroupAccount gra2 = new GroupAccount();
		gra2.groupAccId = gru2.groupId;
		gra2.accountId = acc2;
		gra2.joinDate = LocalDate.now();

		GroupAccount gra3 = new GroupAccount();
		gra3.groupAccId = gru3.groupId;
		gra3.accountId = acc3;
		gra3.joinDate = LocalDate.now();

		// khởi tạo đối tượng trong class TypeQuestion

		TypeQuestion tqe1 = new TypeQuestion();
		tqe1.typeQuestionId = 1;
		tqe1.typeQuestionName = typeName.Essay;

		TypeQuestion tqe2 = new TypeQuestion();
		tqe2.typeQuestionId = 2;
		tqe2.typeQuestionName = typeName.Multiple_Choice;

		// khởi tạo đối tượng trong class CategoryQuestion

		CategoryQuestion cqu1 = new CategoryQuestion();
		cqu1.categoryQuestionId = 1;
		cqu1.categoryQuestionName = "Java Question";

		CategoryQuestion cqu2 = new CategoryQuestion();
		cqu2.categoryQuestionId = 2;
		cqu2.categoryQuestionName = ".NET Question";

		CategoryQuestion cqu3 = new CategoryQuestion();
		cqu3.categoryQuestionId = 3;
		cqu3.categoryQuestionName = "SQL Question";

		// khởi tạo đối tượng trong class Question

		Question que1 = new Question();
		que1.questionId = 1;
		que1.content = "Giói thiệu về Java";
		que1.categoryQuestion = cqu1;
		que1.typeQuestion = tqe1;
		que1.creatorAcc = acc1;
		que1.createDate = LocalDate.now();

		Question que2 = new Question();
		que2.questionId = 1;
		que2.content = "Nêu đặc điểm Java";
		que2.categoryQuestion = cqu1;
		que2.typeQuestion = tqe2;
		que2.creatorAcc = acc2;
		que2.createDate = LocalDate.now();

		Question que3 = new Question();
		que3.questionId = 1;
		que3.content = "Nêu ứng dụng của Java";
		que3.categoryQuestion = cqu1;
		que3.typeQuestion = tqe2;
		que3.creatorAcc = acc2;
		que3.createDate = LocalDate.now();

		// khởi tạo đối tượng trong class Answer

		Answer ans1 = new Answer();
		ans1.answerId = 1;
		ans1.content = "Java là một ngôn ngữ lập trình";
		ans1.question = que1;
		ans1.isCorrect = true;

		Answer ans2 = new Answer();
		ans2.answerId = 2;
		ans2.content = "Java là một ngôn ngữ mạnh và khó";
		ans2.question = que2;
		ans2.isCorrect = true;

		Answer ans3 = new Answer();
		ans3.answerId = 3;
		ans3.content = "Java được sử dụng rộng rãi";
		ans3.question = que3;
		ans3.isCorrect = false;

		// khởi tạo đối tượng trong class Exam

		Exam exa1 = new Exam();
		exa1.examId = 1;
		exa1.examCode = "EXAM001";
		exa1.examTitle = "Exam No.01";
		exa1.categoryQuestion = cqu1;
		exa1.duration = 60;
		exa1.creatorAcc = acc1;
		exa1.createDate = LocalDate.now();

		Exam exa2 = new Exam();
		exa2.examId = 2;
		exa2.examCode = "EXAM002";
		exa2.examTitle = "Exam No.02";
		exa2.categoryQuestion = cqu2;
		exa2.duration = 60;
		exa2.creatorAcc = acc2;
		exa2.createDate = LocalDate.now();

		Exam exa3 = new Exam();
		exa3.examId = 3;
		exa3.examCode = "EXAM003";
		exa3.examTitle = "Exam No.03";
		exa3.categoryQuestion = cqu3;
		exa3.duration = 90;
		exa3.creatorAcc = acc3;
		exa3.createDate = LocalDate.now();

		// khởi tạo đối tượng trong class ExamQuestion

		ExamQuestion equ1 = new ExamQuestion();
		equ1.examId = exa1;
		equ1.questionId = que1;

		ExamQuestion equ2 = new ExamQuestion();
		equ2.examId = exa2;
		equ2.questionId = que2;

		ExamQuestion equ3 = new ExamQuestion();
		equ3.examId = exa3;
		equ3.questionId = que3;

// Question 3: hãy in ít nhất 1 giá trị của mỗi đối tượng ra

		System.out.println("+---Excercise 1---Question 3---+");
		System.out.println("In ít nhất 1 giá trị của mỗi đối tượng");
		System.out.println("   Phòng ban số 1 là: " + dep1.depName);
		System.out.println("   Chức danh số 1 là: " + pos1.posName);
		System.out.println("   Tên tài khoản số 1 là: " + acc1.userName);
		System.out.println("   Tên nhóm số 1 là: " + gru1.groupName);
		System.out.println("   Tên nhóm acc số 1 là: " + gra1.groupAccId);
		System.out.println("   Loại câu hỏi số 1 là: " + tqe1.typeQuestionName);
		System.out.println("   Nhóm câu hỏi số 1 là: " + cqu1.categoryQuestionName);
		System.out.println("   Câu hỏi số 1 là: " + que1.content);
		System.out.println("   Câu trả lời số 1 là: " + ans1.content);
		System.out.println("   Mã đề thi số 1 là: " + exa1.examCode);
		System.out.println("   Câu hỏi 1 của đề thi số 1 là: " + equ1.questionId.questionId);

	}

}
