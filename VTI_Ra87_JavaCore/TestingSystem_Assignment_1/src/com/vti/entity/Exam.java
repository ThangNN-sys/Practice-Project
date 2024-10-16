package com.vti.entity;

import java.time.LocalDate;

public class Exam {
	public int examId;
	public String examCode;
	public String examTitle;
	public CategoryQuestion categoryQuestion;
	public int duration;
	public Account creatorAcc;
	public LocalDate createDate;

}
