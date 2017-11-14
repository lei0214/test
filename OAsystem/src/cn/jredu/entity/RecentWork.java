package cn.jredu.entity;

public class RecentWork {
	private int id;
	private String forwho;
	private String content;
	private String pubdate;
	private String completedate;
	private String username;
	
	
	public RecentWork() {}
	
	
	public RecentWork(int id, String forwho, String content, String pubdate, String completedate, String username) {
		this.id = id;
		this.forwho = forwho;
		this.content = content;
		this.pubdate = pubdate;
		this.completedate = completedate;
		this.username = username;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getForwho() {
		return forwho;
	}
	public void setForwho(String forwho) {
		this.forwho = forwho;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getCompletedate() {
		return completedate;
	}
	public void setCompletedate(String completedate) {
		this.completedate = completedate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
