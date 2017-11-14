package cn.jredu.entity;

public class Leave {

	private int lev_id;
	private String lev_person;
	private String lev_startdate;
	private String lev_enddate;
	private String lev_reason;
	private String status;
	private int bossid;
	
	
	public Leave() {}
	
	
	public Leave(int lev_id,String lev_person, String lev_startdate, String lev_enddate, String lev_reason) {
		this.lev_id=lev_id;
		this.lev_person = lev_person;
		this.lev_startdate = lev_startdate;
		this.lev_enddate = lev_enddate;
		this.lev_reason = lev_reason;
	}
	
	
	public int getBossid() {
		return bossid;
	}
	public void setBossid(int bossid) {
		this.bossid = bossid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLev_id() {
		return lev_id;
	}
	public void setLev_id(int lev_id) {
		this.lev_id = lev_id;
	}
	public String getLev_person() {
		return lev_person;
	}
	public void setLev_person(String lev_person) {
		this.lev_person = lev_person;
	}
	public String getLev_startdate() {
		return lev_startdate;
	}
	public void setLev_startdate(String lev_startdate) {
		this.lev_startdate = lev_startdate;
	}
	public String getLev_enddate() {
		return lev_enddate;
	}
	public void setLev_enddate(String lev_enddate) {
		this.lev_enddate = lev_enddate;
	}
	public String getLev_reason() {
		return lev_reason;
	}
	public void setLev_reason(String lev_reason) {
		this.lev_reason = lev_reason;
	}
	
}
