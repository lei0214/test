package cn.jredu.entity;


public class Student {
	private int no;
	private String name;
	private String sex;
	private String birthday;
	private String school;
	private String major;
	private String classNo;
	private String indate;
	
	
	public Student() {}


	public Student(int no, String name, String sex, String birthday, String school, String major, String classNo,
			String indate) {
		super();
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.school = school;
		this.major = major;
		this.classNo = classNo;
		this.indate = indate;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getClassNo() {
		return classNo;
	}


	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}


	public String getIndate() {
		return indate;
	}


	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	
}
