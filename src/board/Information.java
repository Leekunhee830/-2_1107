package board;

public class Information {
	private String title;
	private String body;
	private int cnt;
    
	Information(String title,String body,int cnt){
		this.title=title;
		this.body=body;
		this.cnt=cnt;
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
}
