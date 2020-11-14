package dto;

public class CommentVO {
	private int paretId;
	private String writer;
	private String body;
	private String regDate;
	
	
	
	public CommentVO(int paretId, String writer, String body, String regDate) {
		this.paretId = paretId;
		this.writer = writer;
		this.body = body;
		this.regDate = regDate;
	}
	
	public int getParetId() {
		return paretId;
	}
	public void setParetId(int paretId) {
		this.paretId = paretId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
