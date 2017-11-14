package cn.jredu.entity;

/**
 * 
 * @author DELL
 *	用户  实体类
 */

public class User {
	private int userId;
	private String userName;
	private String userPwd;
	private String phone;
	private String sex;
	private String checkcode;
	private String headImg;
	private String nickname;
	private int bossid;
	private String bossname;
	
	public User() {}

	

	public User(int userId, String userName, String userPwd, String phone, String sex, String checkcode, String headImg,
			String nickname) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
		this.sex = sex;
		this.checkcode = checkcode;
		this.headImg = headImg;
		this.nickname = nickname;
	}


	
	public String getBossname() {
		return bossname;
	}
	public void setBossname(String bossname) {
		this.bossname = bossname;
	}
	
	public int getBossid() {
		return bossid;
	}
	public void setBossid(int bossid) {
		this.bossid = bossid;
	}


	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	
	
	
}
