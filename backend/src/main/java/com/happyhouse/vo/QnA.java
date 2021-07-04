package com.happyhouse.vo;

public class QnA {
	String no;
	String title;
	String content;
	String writer;
	String wdate;
	
	public QnA(){}
	
	public QnA(String no, String title, String content, String writer, String wdate) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.wdate = wdate;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	
}
