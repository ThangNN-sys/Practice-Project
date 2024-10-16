package com.vti.entity;

import java.time.LocalDate;

public class Question {
	public int questionId;
	public String content;
	public CategoryQuestion categoryQuestion;
	public TypeQuestion typeQuestion;
	public Account creatorAcc;
	public LocalDate createDate;

}
