package cn.jredu.entity;

public class Annouse {

	private int id;
	private String author;
	private String content;
	private String pubdate;
	
	
	public Annouse() {}
	
	
	public Annouse(int id, String author, String content, String pubdate) {
		this.id = id;
		this.author = author;
		this.content = content;
		this.pubdate = pubdate;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	
	
	
}
