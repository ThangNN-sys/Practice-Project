package com.vti.entity;

public class News implements INews {
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private Float averageRate;
	private int[] rate;
	private static int COUNT = 0;

	public News(String title, String publishDate, String author, String content, int[] rate) {
		COUNT++;
		this.id = COUNT;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.averageRate = averageRate;
		this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Float getAverageRate() {
		return averageRate;
	}

	// return the rate
	public int[] getRate() {
		return rate;
	}

	// param rate the rate to set
	public void setRate(int[] rate) {
		this.rate = rate;
	}

//	Implement các method trong interface INews như sau: 
//	a) Method Display() sẽ in ra Title, PublishDate, Author, 
//	Content và AverageRate của tin tức ra console. 
	@Override
	public void display() {
		System.out.println("New [title= " + title + ", publishDate= " + publishDate + ", author= " + author + "]");
	}

//	Implement các method trong interface INews như sau: 
//	b) Method có tên Calculate() để thiết đặt thuộc tính 
//	Khai báo một array có tên Rates kiểu int gồm 3 phần tử 
//	AverageRate là trung bình cộng của 3 phần tử của array Rates. 
	@Override
	public float calculate() {
		averageRate = (float) ((rate[0] + rate[1] + rate[2]) / 3);
		return averageRate;
	}
}
