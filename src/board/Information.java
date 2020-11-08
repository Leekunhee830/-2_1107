package board;

import java.util.Calendar;

public class Information {
	Calendar cal=Calendar.getInstance();
	private String title;
	private String body;
	private String writer;
	private int cnt;
	private int year;
	private int month;
	private int day;
	private int pNumber=0;
    
	Information(String title,String body,int cnt){
		this.title=title;
		this.body=body;
		this.cnt=cnt;
		this.writer="익명";
		this.year=cal.get(Calendar.YEAR);
		this.month=cal.get(Calendar.MONTH)+1;
		this.day=cal.get(Calendar.DAY_OF_MONTH);
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}

}
