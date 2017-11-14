package cn.jredu.entity;

public class RecentThing {
	
	private int id;
	private String content;
	private String pubdate;
	private String username;
	
	
	public RecentThing() {}
	
	
	public RecentThing(int id, String content, String pubdate, String username) {
		this.id = id;
		this.content = content;
		this.pubdate = pubdate;
		this.username = username;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
