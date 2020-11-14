package dto;

import java.util.ArrayList;

public class BoardVO {
	private int num;
	private int views;
	private String title;
	private String body;
	private String day;
	private String writer;
	private ArrayList<String> comment;
	private static int pluse;
	
	public BoardVO(String title,String body,String day){
		this.num=++pluse;
		this.title=title;
		this.body=body;
		this.day=day;
		this.writer="익명";
	}
	
	
	public ArrayList<String> getComment() {
		return comment;
	}

	public void setComment(ArrayList<String> comment) {
		this.comment =comment;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
