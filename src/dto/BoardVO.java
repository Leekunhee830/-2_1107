package dto;

import java.util.ArrayList;

public class BoardVO {
	private int num;
	private int views;
	private int like;
	private boolean likeCheck;
	private String title;
	private String body;
	private String day;
	private String writer;
	private String id;
	private ArrayList<String> comment;
	private static int pluse;
	
	public BoardVO(String title,String body,String writer,String day,String id){
		this.num=++pluse;
		this.title=title;
		this.body=body;
		this.day=day;
		this.writer=writer;
		this.id=id;
	}
	
	
	
	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
