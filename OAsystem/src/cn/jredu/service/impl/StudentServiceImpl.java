package cn.jredu.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jredu.dao.StudentDao;
import cn.jredu.entity.Student;
import cn.jredu.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao dao;
	
	@Override
	public List<Student> show(Integer start, Integer limit) {
		
		
		
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		//System.out.println("service"+start+':'+end);
		String sql="select no,name,sex,birthday,school,major,classNo,indate from (select rownum r ,student.*  "
				+ "from student where rownum<?) xx"+" where xx.r>?";
		List<Object> params=new ArrayList<Object>();
		params.add(end);
		params.add(st);
		List<Student> list = new ArrayList<Student>();
		try {
			list=dao.showAllStudentInfo(sql,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Student> showSelect(Integer start, Integer limit,String selectValue) {
		int st=0;
		int end=0;
		if(start!=null&&limit!=null){
			st=(start-1)*limit;
			end=start*limit+1;
		}
		String sql = "select * from (select rownum r ,oo.* from (select * from student where 1=1";
		List<Object> params = new ArrayList<Object>();
		sql += " and name like ?";
		params.add("%" + selectValue + "%");
		sql += ") oo where rownum<?) xx where xx.r>?";
		params.add(end);
		params.add(st);
		List<Student> list=null;
		try {
			list=dao.showAllStudentInfo(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalCount() {
		String sql1="select * from student";
		int total=0;
		try {
			total = dao.getTotalCount(sql1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public int getTotalCountSelect(String selectValue) {
		int total=0;
		String sql="select * from student where name like ?";
		List<Object> params=new ArrayList<Object>();
		String s="%"+selectValue+"%";
		params.add(s);
		try {
			total = dao.getTotalCountSelect(sql,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	@Override
	public boolean deleteStudentByNo(String nosStr) {
		String[] nos=nosStr.split(",");
		StringBuffer sb=new StringBuffer();
		List<Object> params=new ArrayList<Object>();
		for(String s:nos){
			sb.append("?,");
			params.add(s);
		}
		String finalNo=sb.substring(0,sb.length()-1);
		String sql="delete from student where no in("+finalNo+")";
		int count=0;
		try {
			count=dao.deleteStudentByNo(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}

	@Override
	public boolean addStudent(Student stu) {
		String sql="insert into student values(?,?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(stu.getNo());
		params.add(stu.getName());
		params.add(stu.getSex());
		params.add(stu.getBirthday());
		params.add(stu.getSchool());
		params.add(stu.getMajor());
		params.add(stu.getClassNo());
		params.add(stu.getIndate());
		int count =0;
		try {
			count=dao.addStudent(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count>0;
	}

	
	
}
